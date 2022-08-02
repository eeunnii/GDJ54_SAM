package ex12_object_class;

public class Main {

	public static void main(String[] args) {
		
		// Object 클래스는 모든 객체(변수)를 저장할 수 있다.
		Object p = new Person();
		
		// Object 클래스타입의 객체는
		// 항상 다운캐스팅해서 사용해야 한다.
		if(p instanceof Person) {
			((Person) p).eat();
		}
		
	}

}
