package com.reviewdemo.top25.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reviewdemo.top25.utils.Utils;

@Controller
public class DashboardController {
	@RequestMapping("/dashboard")
	public String dashboard(HttpServletRequest request) {
		String user = Utils.getSessionUser(request);
		if (user == null) {
			return "redirect:/login";
		}
		String theme = request.getParameter("theme");
		request.setAttribute("themeLen", theme.length());
		request.setAttribute("user", user);
		return "dashboard";
	}
}
