package ex05_wrapper;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Wrapper Class
		 * 1. 기본 자료형을 참조 자료형으로 변경해주는 클래스이다.
		 * 2. 주요 종류
		 *    1) int	-> Integer
		 *    2) double	-> Double
		 *    3) char	-> Character
		 * 3. 변수를 객체로 변경해준다.
		 * 4. 변수와 객체는 자동으로 상호변환된다.
		 *    1) Auto Boxing   : 변수 -> 객체
		 *    2) Auto UnBoxing : 객체 -> 변수
		 * 5. 언제 사용하는가? 반드시 참조자료형을 요구할 때 사용한다.
		 */

		Integer a = 10;     // Auto Boxing (기본 자료형 10이 참조 자료형 a로 auto boxing)
		Integer b = 20;
		
		int total = a + b;  // Auto UnBoxing (참조 자료형 a, b를 기본 자료형 int로 auto unboxing
		System.out.println(total);
		
		
		// int (Integer) 타입의 최대 값
		System.out.println("Integer 최대값: " + Integer.MAX_VALUE);
		System.out.println("Integer 최소값: " + Integer.MIN_VALUE);
		
		// long (Long) 타입의 최대 값
		System.out.println("Long 최대값: " + Long.MAX_VALUE);  // 19자리
		System.out.println("Long 최소값: " + Long.MIN_VALUE);  // 19자리
		
	}
	
}
