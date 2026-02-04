package com.reviewdemo.top25.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	private static final Logger LOGGER = LogManager.getLogger("Top25:Upload");

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "upload";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadFile(
			@RequestParam("file") MultipartFile file,
			@RequestParam(value = "dir", required = false, defaultValue = "/tmp/uploads") String dir,
			HttpServletRequest request) {
		try {
			File targetDir = new File(dir);
			targetDir.mkdirs();
			File target = new File(targetDir, file.getOriginalFilename());
			try (FileOutputStream fos = new FileOutputStream(target)) {
				fos.write(file.getBytes());
			}
			request.setAttribute("uploaded", target.getAbsolutePath());
		} catch (Exception ex) {
			LOGGER.error("Upload failed", ex);
			request.setAttribute("error", ex.toString());
		}
		return "upload";
	}

	@RequestMapping(value = "/files", method = RequestMethod.GET)
	public String readFile(
			@RequestParam("path") String path,
			HttpServletRequest request) {
		try (FileInputStream fis = new FileInputStream(new File(path))) {
			String content = IOUtils.toString(fis, StandardCharsets.UTF_8);
			request.setAttribute("fileContent", content);
		} catch (Exception ex) {
			LOGGER.error("Read failed", ex);
			request.setAttribute("error", ex.toString());
		}
		return "files";
	}
}
