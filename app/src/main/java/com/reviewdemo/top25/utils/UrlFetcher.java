package com.reviewdemo.top25.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlFetcher {
	public static String fetch(String urlString) throws Exception {
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(3000);
		conn.setReadTimeout(5000);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
			return sb.toString();
		}
	}
}
