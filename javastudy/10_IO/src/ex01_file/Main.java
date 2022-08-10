package ex01_file;

import java.io.File;

public class Main {

	public static void m1() {
		
		// File 클래스
		// 1. 패키지 : java.io
		// 2. 파일 및 디렉터리 관리
		// 3. 생성 방법
		//    1) new File(경로, 파일)
		//    2) new File(파일)
		// 4. 윈도우의 경로 구분 방법 : 백슬래시(\)
		// 5. 리눅스의 경로 구분 방법 : 슬래시(/)
		
		
		// 폴더(디렉터리) 만들기
		File dir = new File("C:\\storage");
		
		// 존재하지 않으면 만들겠다.
		if(dir.exists() == false) {  // if(!dir.exists())
			dir.mkdirs();
		}
		
	}
	
	public static void main(String[] args) {
		m1();
	}

}
