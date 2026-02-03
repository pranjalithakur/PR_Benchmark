package com.reviewdemo.top25.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reviewdemo.top25.utils.Utils;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		String user = Utils.getSessionUser(request);
		if (user == null) {
			return "login";
		}
		return "dashboard";
	}
}
