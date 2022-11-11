package com.gdu.app12.util;

public class SecurityUtil {

	// 크로스 사이트 스크립팅 방지
	public String preventXSS(String str) {
		str = str.replace("<", "&lt;");
		str = str.replace(">", "&gt;");
		str = str.replace("\"", "&quot;");
		str = str.replace("\'", "&#x27;");
		return str;
	}
	
}
