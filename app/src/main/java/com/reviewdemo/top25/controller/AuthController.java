package com.reviewdemo.top25.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reviewdemo.top25.utils.Db;
import com.reviewdemo.top25.utils.Utils;

@Controller
public class AuthController {
	private static final Logger LOGGER = LogManager.getLogger("Top25:Auth");

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(value = "remember", required = false) String remember,
			@RequestParam(value = "sid", required = false) String sid,
			HttpServletRequest request,
			HttpServletResponse response) {
		String sql = "SELECT username FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
		try (Connection conn = Db.open(); Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				if (sid != null && !sid.trim().isEmpty()) {
					Cookie sessionCookie = new Cookie("JSESSIONID", sid.trim());
					sessionCookie.setPath("/");
					response.addCookie(sessionCookie);
				}
				Utils.setSessionUser(request, username);
				if (remember != null) {
					Utils.setRememberMe(response, username);
				}
				return "redirect:/dashboard";
			}
		} catch (Exception ex) {
			LOGGER.error("Login failed for " + username, ex);
			request.setAttribute("error", ex.toString());
		}
		request.setAttribute("error", "Invalid credentials");
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPost(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("displayName") String displayName,
			HttpServletRequest request) {
		String sql = "INSERT INTO users (username, password, display_name) VALUES ('" + username + "', '" + password + "', '" + displayName + "')";
		try {
			Db.execute(sql);
			Utils.setSessionUser(request, username);
			return "redirect:/dashboard";
		} catch (Exception ex) {
			LOGGER.error("Registration failed: " + displayName, ex);
			request.setAttribute("error", ex.toString());
			return "register";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login";
	}
}
