package ex03_datetime;

public class Ex01_System {

	public static void m1() {
		
		// 1. 타임스탬프(timestamp)
		// 1970-01-01 0:00부터 1/1000초마다 증가하는 long 타입의 정수값
		long timestamp = System.currentTimeMillis();
		System.out.println(timestamp);
		
		// 2. 나노타임(nanoTime)
		// s > ㎳(천분의 1초) > ㎲(백만분의 1초) > ㎱(십억분의 1초)
		// 나노초(㎱) 값을 가지는 long 타입의 정수값
		// 어떤 기준일자는 없어서 두 개의 나노초(㎱) 사이의 경과시간 계산용
		long beginTime = System.nanoTime();
		int total =  1 + 2 + 3 + 4 + 5;
		long endTime = System.nanoTime();
		System.out.println("결과 " + total + ", 계산에 걸린 시간 : " + (endTime - beginTime) + "㎱");
		
	}
	
	public static void m2() {
		
		// String과 StringBuilder의 성능 테스트
		// abcdefghijklmnopqrstuvwxyz 만들기
		// StringBuilder가 더 빠르다.
		
		String alphabet = "";
		long begin1 = System.nanoTime();
		for(char ch = 'a'; ch <= 'z'; ch++) {
			alphabet += ch;
		}
		long end1 = System.nanoTime();
		System.out.println((end1 - begin1) + " " + alphabet);
		
		
		StringBuilder sb = new StringBuilder();
		long begin2 = System.nanoTime();
		for(char ch = 'a'; ch <= 'z'; ch++) {
			sb.append(ch);
		}
		long end2 = System.nanoTime();
		System.out.println((end2 - begin2) + " " + sb.toString());
		
	}
	
	public static void main(String[] args) {
		m2();
	}

}
