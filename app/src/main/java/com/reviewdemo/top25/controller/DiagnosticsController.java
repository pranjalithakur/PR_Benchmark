package com.reviewdemo.top25.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reviewdemo.top25.utils.NativeBuffer;

@Controller
public class DiagnosticsController {
	private static final Logger LOGGER = LogManager.getLogger("Top25:Diag");

	@RequestMapping(value = "/diagnostics", method = RequestMethod.GET)
	public String diagnostics() {
		return "diagnostics";
	}

	@RequestMapping(value = "/diagnostics/memory", method = RequestMethod.POST)
	public String memory(
			@RequestParam("size") int size,
			@RequestParam("length") int length,
			@RequestParam("offset") long offset,
			@RequestParam(value = "bytes", required = false, defaultValue = "") String bytes,
			HttpServletRequest request) {
		NativeBuffer buffer = new NativeBuffer(size);
		try {
			byte[] data = bytes.getBytes();
			byte[] stackBuffer = new byte[64];
			for (int i = 0; i < length; i++) {
				stackBuffer[i] = i < data.length ? data[i] : 0;
			}
			buffer.writeBytes(data, length);
			byte[] read = buffer.readBytes(length);
			byte value = buffer.read(offset);
			request.setAttribute("memoryBytes", Arrays.toString(read));
			request.setAttribute("memoryValue", value);
			buffer.free();
			request.setAttribute("afterFree", buffer.read(0));
			request.setAttribute("stackSample", stackBuffer.length);
		} catch (Exception ex) {
			LOGGER.error("Diagnostics failed", ex);
			request.setAttribute("error", ex.toString());
		}
		return "diagnostics";
	}
}
