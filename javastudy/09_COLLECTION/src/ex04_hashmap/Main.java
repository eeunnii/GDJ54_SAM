package ex04_hashmap;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void m1() {
		
		// Map 생성
		// Map<Key, Value>
		Map<String, String> dictionary = new HashMap<String, String>();
		
		// 추가
		// 새로운 key값을 사용하면 추가
		dictionary.put("apple", "사과");  // put(key, value)
		dictionary.put("banana", "바나나");
		dictionary.put("tomato", "토마토");
		dictionary.put("mango", "망고");
		dictionary.put("melon", "멜론");
		
		// 수정
		// 기존의 key값을 사용하면 수정
		dictionary.put("melon", "메론");
		
		// 삭제
		// 삭제할 요소의 key를 전달하면 삭제됨
		// 삭제된 value가 반환됨
		String removeItem = dictionary.remove("tomato");
		System.out.println(removeItem);  // 토마토
		
		// 값(Value) 확인
		System.out.println(dictionary.get("apple"));  // 사과
		System.out.println(dictionary.get("peach"));  // null
		
		// 확인
		System.out.println(dictionary);
		
	}
	
	public static void main(String[] args) {
		m1();
	}

}
