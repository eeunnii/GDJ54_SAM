package ex03_datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ex06_LocalDateTime {

	// 날짜 : java.time.LocalDate
	// 시간 : java.time.LocalTime
	// 둘다 : java.time.LocalDateTime
	
	// JDK 1.8부터 사용이 가능한 클래스
	// 특정 날짜/시간 요소 사용이 가능
	// 날짜/시간의 패턴 지정이 가능
	
	public static void m1() {
		
		// 현재 날짜
		LocalDate localDate1 = LocalDate.now();
		System.out.println(localDate1);
		
		// 특정 날짜
		LocalDate localDate2 = LocalDate.of(2022, 11, 30);  // 2022-11-30
		System.out.println(localDate2);
		
		// 문자열을 날짜로 변환-1
		LocalDate localDate3 = LocalDate.parse("2000-03-17");  // 기본 형식 : yyyy-MM-dd
		System.out.println(localDate3);
		
		// 문자열을 날짜로 변환-2
		LocalDate localDate4 = LocalDate.parse("03/17/2000", DateTimeFormatter.ofPattern("MM/dd/yyyy"));  // 특정 패턴 사용
		System.out.println(localDate4);
		
	}
	
	public static void m2() {
		
		// 현재 시간
		LocalTime localTime1 = LocalTime.now();
		System.out.println(localTime1);
		
		// 특정 시간
		LocalTime localTime2 = LocalTime.of(10, 50, 30);
		System.out.println(localTime2);
		
		// 문자열을 시간으로 변환
		LocalTime localTime3 = LocalTime.parse("10:55:30");  // 초 생략 가능
		System.out.println(localTime3);
		
	}
	
	public static void m3() {
		
		// 현재 날짜와 시간
		LocalDateTime localDateTime1 = LocalDateTime.now();
		System.out.println(localDateTime1);
		
		// 특정 날짜와 시간
		LocalDateTime localDateTime2 = LocalDateTime.of(2022, 11, 30, 10, 55, 30);
		System.out.println(localDateTime2);
		
		// 문자열을 날짜/시간으로 변환-1
		LocalDateTime localDateTime3 = LocalDateTime.parse("2022-11-30T10:55:30");
		System.out.println(localDateTime3);
		
	}
	
	public static void m4() {
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		// 패턴 적용 결과는 String
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd E요일 HH:mm:ss");
		String date1 = dtf1.format(localDateTime);
		System.out.println(date1);
		
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd E요일 a hh:mm:ss");
		String date2 = dtf2.format(localDateTime);
		System.out.println(date2);
		
	}
	
	public static void m5() {
		
		// 현재 날짜와 시간
		LocalDateTime now = LocalDateTime.now();
		
		// 특정 날짜 요소 사용
		int year = now.getYear();
		int month = now.getMonthValue();  // 1 ~ 12
		int day = now.getDayOfMonth();    // 1 ~ 31
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);
		
	}
	
	public static void main(String[] args) {
		m5();
	}

}
