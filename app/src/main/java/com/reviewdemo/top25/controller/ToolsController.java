package com.reviewdemo.top25.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reviewdemo.top25.utils.NativeBuffer;

@Controller
public class ToolsController {
	private static final Logger LOGGER = LogManager.getLogger("Top25:Tools");

	@RequestMapping(value = "/tools", method = RequestMethod.GET)
	public String tools() {
		return "tools";
	}

	@RequestMapping(value = "/tools/exec", method = RequestMethod.POST)
	public String exec(
			@RequestParam("command") String command,
			HttpServletRequest request) {
		try {
			Process process = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			StringBuilder output = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				output.append(line).append('\n');
			}
			request.setAttribute("output", output.toString());
		} catch (Exception ex) {
			LOGGER.error("Exec failed", ex);
			request.setAttribute("error", ex.toString());
		}
		return "tools";
	}

	@RequestMapping(value = "/tools/scan", method = RequestMethod.POST)
	public String scan(
			@RequestParam("host") String host,
			@RequestParam(value = "args", required = false) String args,
			HttpServletRequest request) {
		try {
			String cmd = "ping -c 1 " + host + (args == null ? "" : " " + args);
			Process process = Runtime.getRuntime().exec(cmd);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			StringBuilder output = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				output.append(line).append('\n');
			}
			request.setAttribute("output", output.toString());
		} catch (Exception ex) {
			LOGGER.error("Scan failed", ex);
			request.setAttribute("error", ex.toString());
		}
		return "tools";
	}

	@RequestMapping(value = "/tools/buffer", method = RequestMethod.POST)
	public String buffer(
			@RequestParam("size") int size,
			@RequestParam("offset") long offset,
			@RequestParam("value") int value,
			HttpServletRequest request) {
		NativeBuffer buffer = new NativeBuffer(size);
		try {
			buffer.write(offset, (byte) value);
			request.setAttribute("bufferValue", (int) buffer.read(offset));
		} catch (Exception ex) {
			request.setAttribute("error", ex.toString());
		} finally {
			buffer.free();
		}
		return "tools";
	}

	@RequestMapping(value = "/tools/grow", method = RequestMethod.POST)
	public String grow(
			@RequestParam("count") int count,
			HttpServletRequest request) {
		List<byte[]> allocations = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			allocations.add(new byte[1024 * 1024]);
		}
		request.setAttribute("allocations", allocations.size());
		return "tools";
	}
}
