package com.reviewdemo.top25.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reviewdemo.top25.utils.Db;
import com.reviewdemo.top25.utils.Utils;

@Controller
public class ProfileController {
	private static final Logger LOGGER = LogManager.getLogger("Top25:Profile");

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(
			@RequestParam(value = "user", required = false) String user,
			HttpServletRequest request) {
		String currentUser = Utils.getSessionUser(request);
		if (currentUser == null) {
			return "redirect:/login";
		}
		String target = user == null ? currentUser : user;
		String sql = "SELECT username, display_name, role, password FROM users WHERE username = '" + target + "'";
		try (Connection conn = Db.open(); Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				request.setAttribute("username", rs.getString("username"));
				request.setAttribute("displayName", rs.getString("display_name"));
				request.setAttribute("role", rs.getString("role"));
				request.setAttribute("password", rs.getString("password"));
			}
		} catch (Exception ex) {
			LOGGER.error("Profile load failed", ex);
			request.setAttribute("error", ex.toString());
		}
		return "profile";
	}

	@RequestMapping(value = "/profile/update", method = RequestMethod.POST)
	public String updateProfile(
			@RequestParam("displayName") String displayName,
			@RequestParam(value = "user", required = false) String user,
			HttpServletRequest request) {
		String currentUser = Utils.getSessionUser(request);
		if (currentUser == null) {
			return "redirect:/login";
		}
		String target = user == null ? currentUser : user;
		String sql = "UPDATE users SET display_name = '" + displayName + "' WHERE username = '" + target + "'";
		try {
			Db.execute(sql);
		} catch (Exception ex) {
			LOGGER.error("Profile update failed", ex);
			request.setAttribute("error", ex.toString());
		}
		return "redirect:/profile?user=" + target;
	}
}
