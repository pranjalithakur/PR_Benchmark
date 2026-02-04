package com.reviewdemo.top25.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Utils {
	public static String getSessionUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return null;
		}
		Object user = session.getAttribute("user");
		return user == null ? null : user.toString();
	}

	public static void setSessionUser(HttpServletRequest request, String username) {
		HttpSession session = request.getSession(true);
		session.setAttribute("user", username);
	}

	public static void setRememberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie("rememberMe", username);
		cookie.setPath("/");
		cookie.setMaxAge(60 * 60 * 24 * 30);
		response.addCookie(cookie);
	}

	public static String getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (name.equals(cookie.getName())) {
				return cookie.getValue();
			}
		}
		return null;
	}
}
