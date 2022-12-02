package ex01_string;

public class Ex03_StringBuilder {

	public static void m1() {
		
		// java.lang.StringBuilder 클래스(JDK 1.5)
		// synchronized 적용 안 됨
		//   => 멀티쓰레드 환경에서 사용 불가능하지만 빠름 
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("a");
		stringBuilder.append("p");
		stringBuilder.append("p");
		stringBuilder.append("l");
		stringBuilder.append("e");
		
		String result = stringBuilder.toString();
		System.out.println(result);
		
	}
	
	public static void prac() {
		
		// 연습. 1 2 3 4 5 6 7 8 9 10 만들기
		StringBuilder sb = new StringBuilder();
		for(int n = 1; n <= 10; n++) {
			sb.append(n + " ");
		}
		String paging = sb.toString();
		System.out.println(paging);
		
	}
	
	public static void main(String[] args) {
		prac();
	}

}
