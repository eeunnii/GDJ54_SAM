package ex03_datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex04_SimpleDateFormat {

	public static void main(String[] args) {
		
		// java.text.SimpleDateFormat 클래스
		// 패턴이 적용된 String 타입의 날짜 반환
		
		Date date1 = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd E요일 HH:mm:ss");
		String result1 = sdf1.format(date1);
		System.out.println(result1);
		
		java.sql.Date date2 = new java.sql.Date(System.currentTimeMillis());
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd E요일 a hh:mm:ss");
		String result2 = sdf2.format(date2);
		System.out.println(result2);
		
	}

}
