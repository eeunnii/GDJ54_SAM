package ex11_static;

public class MyMathMain {

	public static void main(String[] args) {
		
		// 클래스 멤버는 클래스 이름 MyMath를 이용해서 호출하는 것이 좋음
		
		System.out.println(MyMath.PI);
		System.out.println(MyMath.abs(-5));
		
		System.out.println(MyMath.pow(2, 5));  // 2의 5제곱(32)
		
	}

}
