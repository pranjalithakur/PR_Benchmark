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

import com.reviewdemo.top25.model.Message;
import com.reviewdemo.top25.utils.Db;
import com.reviewdemo.top25.utils.Utils;

@Controller
public class MessageController {
	private static final Logger LOGGER = LogManager.getLogger("Top25:Messages");

	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public String listMessages(
			@RequestParam(value = "userId", required = false) String userId,
			HttpServletRequest request) {
		String user = Utils.getSessionUser(request);
		if (user == null) {
			return "redirect:/login";
		}
		String target = userId == null ? user : userId;
		List<Message> messages = new ArrayList<>();
		String sql = "SELECT id, sender, recipient, content, sent_at FROM messages WHERE recipient = '" + target + "' ORDER BY sent_at DESC";
		try (Connection conn = Db.open(); Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				messages.add(new Message(
						rs.getInt("id"),
						rs.getString("sender"),
						rs.getString("recipient"),
						rs.getString("content"),
						new Date(rs.getTimestamp("sent_at").getTime())));
			}
		} catch (Exception ex) {
			LOGGER.error("Message list failed: " + sql, ex);
			request.setAttribute("error", ex.toString());
		}
		request.setAttribute("messages", messages);
		request.setAttribute("target", target);
		return "messages";
	}

	@RequestMapping(value = "/messages", method = RequestMethod.POST)
	public String sendMessage(
			@RequestParam("recipient") String recipient,
			@RequestParam("content") String content,
			HttpServletRequest request) {
		String user = Utils.getSessionUser(request);
		if (user == null) {
			return "redirect:/login";
		}
		String sql = "INSERT INTO messages (sender, recipient, content, sent_at) VALUES ('" + user + "', '" + recipient + "', '" + content + "', NOW())";
		try {
			Db.execute(sql);
		} catch (Exception ex) {
			LOGGER.error("Send message failed: " + recipient, ex);
			request.setAttribute("error", ex.toString());
		}
		return "redirect:/messages?userId=" + recipient;
	}
}
