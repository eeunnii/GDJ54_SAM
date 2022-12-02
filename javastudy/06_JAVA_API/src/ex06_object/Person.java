package ex06_object;

public class Person {

	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void eat() {
		System.out.println("먹는다.");
	}

	@Override
	public String toString() {
		return "이름 : " + name;  // System.out.println(person);에서 사용됨
	}
	
	@Override
	public boolean equals(Object anObject) {  // p1.equals(p2) 에서 사용됨
		Person p = (Person) anObject;
		return name.equals(p.name);
	}
	
	// toString()과 equals()는 수업에서는 직접 만들어 보았으나,
	// 실무에서는 IDE가 제공하는 코드 자동 완성 기능을 이용하거나, 라이브러리를 활용해서 처리함
	
}
