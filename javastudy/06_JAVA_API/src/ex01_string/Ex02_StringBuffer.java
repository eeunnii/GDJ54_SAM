package ex01_string;

public class Ex02_StringBuffer {

	public static void main(String[] args) {
		
		// java.lang.StringBuffer 클래스(JDK 1.0)
		// synchronized 적용됨
		//   => 멀티쓰레드 환경에서 사용 가능하지만 느림 
		
		StringBuffer stringBuffer = new StringBuffer();
		
		stringBuffer.append("a");
		stringBuffer.append("p");
		stringBuffer.append("p");
		stringBuffer.append("l");
		stringBuffer.append("e");
		
		String result = stringBuffer.toString();
		System.out.println(result);

	}

}
