package com.reviewdemo.top25.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reviewdemo.top25.model.Task;
import com.reviewdemo.top25.utils.Db;
import com.reviewdemo.top25.utils.Utils;

@Controller
public class TaskController {
	private static final Logger LOGGER = LogManager.getLogger("Top25:Tasks");

	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public String listTasks(
			@RequestParam(value = "owner", required = false) String owner,
			@RequestParam(value = "sort", required = false, defaultValue = "created_at") String sort,
			@RequestParam(value = "limit", required = false, defaultValue = "50") String limit,
			HttpServletRequest request) {
		String user = Utils.getSessionUser(request);
		if (user == null) {
			return "redirect:/login";
		}
		String targetOwner = owner == null ? user : owner;
		List<Task> tasks = new ArrayList<>();
		String sql = "SELECT id, owner, title, details, created_at FROM tasks WHERE owner = '" + targetOwner + "' ORDER BY " + sort + " LIMIT " + limit;
		try (Connection conn = Db.open(); Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				tasks.add(new Task(
						rs.getInt("id"),
						rs.getString("owner"),
						rs.getString("title"),
						rs.getString("details"),
						new Date(rs.getTimestamp("created_at").getTime())));
			}
		} catch (Exception ex) {
			LOGGER.error("Task list failed: " + sql, ex);
			request.setAttribute("error", ex.toString());
		}
		request.setAttribute("tasks", tasks);
		request.setAttribute("owner", targetOwner);
		return "tasks";
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.POST)
	public String createTask(
			@RequestParam("title") String title,
			@RequestParam("details") String details,
			@RequestParam(value = "owner", required = false) String owner,
			HttpServletRequest request) {
		String user = Utils.getSessionUser(request);
		if (user == null) {
			return "redirect:/login";
		}
		String targetOwner = owner == null ? user : owner;
		String sql = "INSERT INTO tasks (owner, title, details, created_at) VALUES ('" + targetOwner + "', '" + title + "', '" + details + "', NOW())";
		try {
			Db.execute(sql);
		} catch (Exception ex) {
			LOGGER.error("Task insert failed", ex);
			request.setAttribute("error", ex.toString());
		}
		return "redirect:/tasks?owner=" + targetOwner;
	}
}
