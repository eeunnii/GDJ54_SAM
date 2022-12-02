package ex02_random;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class Main {

	public static void m1() {
		
		// java.lang.Math 클래스
		
		System.out.println(Math.random());

		// 0.0 <= Math.random() < 1.0
		// 0%  <= Math.random() < 100%
		
		// 1. 확률 처리하기
		// 10% 확률로 "대박", 90% 확률로 "쪽박"
		if(Math.random() < 0.1) {
			System.out.println("대박");
		} else {
			System.out.println("쪽박");
		}
		
		// 2. 난수 값 생성
		
		// Math.random()                     0.0 <= n < 1.0
		// Math.random() * 5                 0.0 <= n < 5.0
		// (int)(Math.random() * 5)            0 <= n < 5
		// (int)(Math.random() * 5) + 1        1 <= n < 6
		
		// 주사위 2개 던지기
		for(int n = 0; n < 2; n++) {
			int dice = (int)(Math.random() * 6) + 1;
			System.out.println("주사위 " + dice);
		}
		
		// 연습. 6자리 숫자 인증번호 만들기
		// String code = "501924"
		String code = "";
		for(int n = 0; n < 6; n++) {
			code += (int)(Math.random() * 10);
		}
		System.out.println(code);
		
	}
	
	public static void m2() {
		
		// java.util.Random 클래스
		// 시드를 이용해 난수 생성
		// 기본적으로 현재 시간을 시드로 사용
		// 동일한 시드가 사용되면 생성되는 난수가 동일함
		// 즉, 동일한 시간에 생성된 난수는 동일한 값을 가짐
		
		Random random = new Random();
		
		// 정수
		System.out.println(random.nextInt());     // int 범위 난수
		System.out.println(random.nextInt(10));   // 0~9 범위 난수
		
		// 실수
		System.out.println(random.nextDouble());  // 0 이상 1 미만
		
	}
	
	
	public static void m3() {
		
		// java.security.SecureRandom 클래스
		// 시드를 이용해 난수 생성
		// 기본적으로 현재 시간을 시드로 사용
		// 동일한 시드가 사용되면 생성되는 난수가 동일함
		// 즉, 동일한 시간에 생성된 난수는 동일한 값을 가짐
		
		SecureRandom secureRandom = new SecureRandom();
		
		// 정수
		System.out.println(secureRandom.nextInt());     // int 범위 난수
		System.out.println(secureRandom.nextInt(10));   // 0~9 범위 난수
		
		// 실수
		System.out.println(secureRandom.nextDouble());  // 0 이상 1 미만
		
	}
	
	public static void m4() {
		
		// java.util.UUID 클래스
		// 32개의 16진수 문자와 4개의 하이픈(-)으로 구성된 전역 고유 식별자(Universally Unique Identifier)
		// 객체, 문서, 이미지 등의 식별자로 사용
		
		UUID uuid1 = UUID.randomUUID();
		String str1 = uuid1.toString();
		System.out.println(str1);
		
		UUID uuid2 = UUID.fromString("6d1911c0-a601-44cd-b6e1-916194b3803d");
		String str2 = uuid2.toString();
		System.out.println(str2);
		
	}
	
	
	public static void prac() {
		
		// 연습. 6자리 영문(대문자 + 소문자) 인증번호 만들기
		
		SecureRandom secureRandom = new SecureRandom();
		StringBuilder sbCode = new StringBuilder();
		
		for(int n = 0; n < 6; n++) {
			if(secureRandom.nextDouble() < 0.5) {
				sbCode.append((char)((int)(secureRandom.nextDouble() * 26) + 'A'));
			} else {
				sbCode.append((char)((int)(secureRandom.nextDouble() * 26) + 'a'));
			}
		}
		
		String code = sbCode.toString();
		System.out.println(code);
		
	}
	
	public static void main(String[] args) {
		prac();
	}

}