package com.gdu.search;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class ApiSearchBook {

	public static void main(String[] args) {
		
		String clientId = "ZuA2Hxw8DnfFAdWjRSk4";
		String clientSecret = "aSF2zE3ZRQ";
		
		try {
			
			String apiURL = "https://openapi.naver.com/v1/search/book?query=" + 검색어;
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			BufferedReader br = null;
			if() {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			con.disconnect();
			
			JSONObject obj = new JSONObject(sb.toString());
			
			File dir = new File();
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			File file = new File(dir, 검색어 + ".html");
			PrintWriter out = new PrintWriter(file);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title></title>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("</body>");
			out.println("</html>");
			out.close();
			
		} catch(Exception e) {
			
			try {
				
				File dir = new File();
				if(dir.exists() == false) {
					dir.mkdirs();
				}
				File file = new File(dir, "");
				PrintWriter out = new PrintWriter(file);
				out.println();
				out.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}
	
}
