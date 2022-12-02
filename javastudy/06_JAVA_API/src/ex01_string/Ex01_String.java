package ex01_string;

public class Ex01_String {

	public static void literal_object() {
		
		// 문자열 리터럴
		String str1 = "hello";
		String str2 = "hello";
		
		/*
		     |-------|
		str1 | 0x123 |
		     |-------|
		str2 | 0x123 |
		     |-------|
		     | hello | 0x123
		     |-------|
		*/
		System.out.println(str1 == str2);
		
		
		// 문자열 객체
		String str3 = new String("hi");
		String str4 = new String("hi");
		
		/*
		     |-------|
		str3 | 0x123 |
		     |-------|
		str4 | 0x456 |
		     |-------|
		     | hi    | 0x123
		     |-------|
		     | hi    | 0x456
		     |-------|
		*/
		System.out.println(str3 == str4);
		
	}
	
	public static void equals() {
		
		// equals()
		// 문자열이 동일하면 true 아니면 false 반환
		
		// 문자열 리터럴
		String str1 = "hello";
		String str2 = "hello";
		
		if(str1.equals(str2)) {
			System.out.println("str1, str2는 같아요");
		} else {
			System.out.println("str1, str2는 달라요");
		}
		
		// 문자열 객체
		String str3 = new String("hi");
		String str4 = new String("hi");
		
		if(str3.equals(str4)) {
			System.out.println("str3, str4는 같아요");
		} else {
			System.out.println("str3, str4는 달라요");
		}
		
		// 대소문자를 무시
		String str5 = "Hello World";
		String str6 = "hELLO wORLD";
		if(str5.equalsIgnoreCase(str6)) {
			System.out.println("str5, str6는 같아요");
		} else {
			System.out.println("str5, str6는 달라요");
		}
		
	}
	
	public static void length() {
		
		// length()
		// 문자열 길이 반환
		
		String name = "I am a boy.";
		int length = name.length();
		System.out.println("글자수 : " + length);
		
	}
	
	public static void charAt() {
		
		// charAt()
		// 특정 위치(인덱스: index)의 문자(char)만 반환
		// 인덱스는 0부터 시작
		
		String name = "홍길동";
		
		System.out.println(name.charAt(0));
		System.out.println(name.charAt(1));
		System.out.println(name.charAt(2));
		
	}
	
	public static void substring() {

		// substring()
		// 문자열의 일부 문자열(String)을 반환
		//   1) substring(begin) : 인덱스 begin(포함)부터 끝까지 반환
		//   2) substring(begin, end) : 인덱스 begin(포함)부터 인덱스 end(불포함)까지 반환
		
		String name = "홍길동";
		
		System.out.println(name.substring(0, 1));
		System.out.println(name.substring(1));
		
	}
	
	public static void indexOf() {
		
		// indexOf()
		//   1) 발견된 첫 번째 문자열의 인덱스를 반환
		//   2) 발견된 문자열이 없는 경우 -1을 반환

		String slogan = "good good good";
		
		int idx1 = slogan.indexOf("good");
		int idx2 = slogan.indexOf("good", idx1 + 1);
		int idx3 = slogan.indexOf("good", idx2 + 1);
		System.out.println(idx1);
		System.out.println(idx2);
		System.out.println(idx3);
		
		
		// lastIndexOf
		//   1) 발견된 마지막 문자열의 인덱스를 반환
		//   2) 발견된 문자열이 없는 경우 -1을 반환
		
		int idx4 = slogan.lastIndexOf("good");
		System.out.println(idx4);
		
	}
	
	public static void startsWith() {
		
		// startsWith()
		// 문자열이 특정 패턴으로 시작하는지 여부를 boolean(true, false) 반환
		
		String name = "민경태";
		
		if(name.startsWith("민")) {
			System.out.println("민씨입니다.");
		} else {
			System.out.println("민씨가 아닙니다.");
		}
		
		
		// endsWith()
		// 문자열이 특정 패턴으로 끝나는지 여부를 boolean(true, false) 반환
		
		String filename = "image.jpg";  // jpg, png로 끝나면 이미지로 가정
		
		if(filename.endsWith("jpg") || filename.endsWith("png")) {
			System.out.println("이미지입니다.");
		} else {
			System.out.println("이미지가 아닙니다.");
		}
		
	}
	
	public static void contains() {
		
		// contains()
		// 문자열이 특정 패턴을 포함하는지 여부를 boolean(true, false) 반환
		
		String email = "gt_min@naver.com";
		
		if(email.contains("@") && email.contains(".")) {
			System.out.println("이메일입니다.");
		} else {
			System.out.println("이메일이 아닙니다.");
		}
		
	}
	
	public static void trim() {
		
		// trim()
		// 불필요한 공백 제거(좌우 공백)
		
		String message = "  안녕  하세요  ";
		
		System.out.println(message.trim());
		System.out.println(message.trim().length());
		
	}
	
	public static void toUpperCase() {
		
		// toUpperCase()
		// 대문자로 변환
		
		String str = "I am a student.";
		System.out.println(str.toUpperCase());
		
		
		// toLowerCase()
		// 소문자로 변환하기
		System.out.println(str.toLowerCase());
		
	}
	
	public static void replace() {
		
		// replace(text1, text2)
		// 모든 text1을 text2로 변환한 결과를 반환
		
		String source = "best of the best";
		String replaced = source.replace("best", "worst");
		System.out.println(source);
		System.out.println(replaced);
		
		
		// replaceAll(regex, text)
		// 정규식(regex)을 만족하는 부분을 text로 변환한 결과를 반환
		// 주의! replaceAll()는 정규식을 사용하므로 정규식을 공부한 뒤 사용할 것
		
		String ip = "192.168.101.91";
		String replacedIp = ip.replaceAll(".", "_");  // 192_168_101_91를 기대
		System.out.println(replacedIp);
		
		replacedIp = ip.replaceAll("\\.", "_");       // 마침표(.)를 문자로 인식시키기 위해 이스케이프(\) 부착
		System.out.println(replacedIp);
		
	}
	
	public static void isEmpty() {
		
		// isEmpty() : JDK 1.6
		// 빈 문자열인지 여부를 검사한 뒤 boolean(true, false) 반환
		// 길이가 0이면 true를 반환
		
		String id = " ";  // 공백 문자
		if(id.isEmpty()) {
			System.out.println("아이디 없음");
		} else {
			System.out.println("아이디 있음");
		}
		
		
		// isBlank() : JDK 11
		// 빈 문자열인지 여부를 검사한 뒤 boolean(true, false) 반환
		// 길이가 0이거나 공백 문자(whitespace)로만 구성된 경우 true 반환
		
		String name = " ";  // 공백 문자
		if(name.isBlank()) {
			System.out.println("이름 없음");
		} else {
			System.out.println("이름 있음");
		}
		
	}
	
	public static void format() {
		
		// format()
		// 지정한 형식의 문자열 반환
		
		int n = 1000;
		
		System.out.println(String.format("%d", n));  // 10진수
		System.out.println(String.format("%o", n));  // 8진수
		
		// 16진수는 간혹 사용되는 경우가 있음
		System.out.println(String.format("%x", n));  // 16진수(소문자 사용)
		System.out.println(String.format("%X", n));  // 16진수(대문자 사용)
		
	}
	
	public static void prac() {
		
		// 연습1. 파일이름을 파일명과 확장자로 분리하시오.
		String fullname = "apple.tar.gz";
		String filename = "";
		String extension = "";
		
		String except = "tar.gz";
		if(fullname.endsWith(except)) {
			filename = fullname.substring(0, fullname.lastIndexOf(except) - 1);
			extension = except;
		} else {
			filename = fullname.substring(0, fullname.lastIndexOf("."));
			extension = fullname.substring(fullname.lastIndexOf(".") + 1);			
		}
		
		System.out.println(filename);
		System.out.println(extension);
		
		// 연습2. 문자열 "abc12345def67890ghijk"에서
		// 아라비아 숫자 1234567890을 제외하고 한 글자씩 화면에 출력하시오.
		String str1 = "abc12345def67890ghijk";
		for(int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			if(ch >= '0' && ch <= '9') {
				continue;
			}
			System.out.print(ch);
		}
		System.out.println();
		
		// 정규식 활용
		String str2 = "abc12345def67890ghijk";
		str2 = str2.replaceAll("[0-9]", "");
		System.out.println(str2);
		
	}
	
	public static void main(String[] args) {
		prac();
	}

}
