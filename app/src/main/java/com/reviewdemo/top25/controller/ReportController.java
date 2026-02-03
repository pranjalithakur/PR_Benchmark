package com.reviewdemo.top25.controller;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reviewdemo.top25.utils.UrlFetcher;

@Controller
public class ReportController {
	private static final Logger LOGGER = LogManager.getLogger("Top25:Report");

	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public String reports() {
		return "reports";
	}

	@RequestMapping(value = "/reports/run", method = RequestMethod.POST)
	public String runReport(
			@RequestParam("expression") String expression,
			HttpServletRequest request) {
		try {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("JavaScript");
			Object result = engine.eval(expression);
			request.setAttribute("reportResult", result == null ? "" : result.toString());
		} catch (Exception ex) {
			LOGGER.error("Report failed", ex);
			request.setAttribute("error", ex.toString());
		}
		return "reports";
	}

	@RequestMapping(value = "/reports/fetch", method = RequestMethod.POST)
	public String fetchUrl(
			@RequestParam("url") String url,
			HttpServletRequest request) {
		try {
			String body = UrlFetcher.fetch(url);
			request.setAttribute("fetchResult", body);
		} catch (Exception ex) {
			LOGGER.error("Fetch failed", ex);
			request.setAttribute("error", ex.toString());
		}
		return "reports";
	}
}
