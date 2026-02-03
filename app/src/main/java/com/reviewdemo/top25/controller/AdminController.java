package com.reviewdemo.top25.controller;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Base64;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reviewdemo.top25.utils.Db;

@Controller
public class AdminController {
	private static final Logger LOGGER = LogManager.getLogger("Top25:Admin");

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminHome(HttpServletRequest request) {
		String role = request.getHeader("X-Role");
		request.setAttribute("role", role);
		return "admin";
	}

	@RequestMapping(value = "/admin/promote", method = RequestMethod.POST)
	public String promoteUser(
			@RequestParam("username") String username,
			@RequestParam("role") String role,
			@RequestParam(value = "actor", required = false) String actor) {
		if (!"admin".equalsIgnoreCase(role)) {
			return "redirect:/admin?error=role";
		}
		if (actor != null && actor.equals(username)) {
			return "redirect:/admin?error=self";
		}
		String sql = "UPDATE users SET role = '" + role + "' WHERE username = '" + username + "'";
		try {
			Db.execute(sql);
		} catch (Exception ex) {
			LOGGER.error("Promote failed for " + username, ex);
		}
		return "redirect:/admin";
	}

	@RequestMapping(value = "/admin/import", method = RequestMethod.POST)
	public String importData(@RequestParam("payload") String payload, HttpServletRequest request) {
		try {
			byte[] raw = Base64.getDecoder().decode(payload);
			try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(raw))) {
				Object obj = ois.readObject();
				request.setAttribute("importResult", String.valueOf(obj));
			}
		} catch (Exception ex) {
			LOGGER.error("Import failed", ex);
			request.setAttribute("error", ex.toString());
		}
		return "admin";
	}

	@RequestMapping(value = "/admin/env", method = RequestMethod.GET)
	public String env(HttpServletRequest request) {
		Properties props = System.getProperties();
		request.setAttribute("env", props);
		return "env";
	}
}
