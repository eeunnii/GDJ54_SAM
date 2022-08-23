package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.json.XML;

public class Main {

	public static void main(String[] args) {
		
		// XML 파싱
		// API응답(XML) -> XML파일 -> Document
		
		// JSON 파싱
		// API응답(JSON) -> JSONObject
		
		
		try {
			
			String apiURL = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			// con.setRequestMethod("GET");
			// con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
			StringBuilder sb = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			
			// StringBuilder에 저장된 응답(XML) 데이터를 JSON으로 변경하기
			JSONObject obj = XML.toJSONObject(sb.toString());
			System.out.println(obj);
			
			File file = new File("test.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
