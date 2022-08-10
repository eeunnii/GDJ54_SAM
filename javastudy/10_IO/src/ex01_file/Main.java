package ex01_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

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
		// 존재하면 삭제하겠다.
		else {
			// dir.delete();  // 지금 지운다.
			dir.deleteOnExit();  // JVM이 종료되면 지운다.
		}
		
	}
	
	public static void m2() {
		
		File file = new File("C:\\storage", "my.txt");
		
		try {
			if(file.exists() == false) {
				file.createNewFile();  // IOException 처리를 필요로 하는 코드
			}
			else {
				file.delete();
			}
		} catch(IOException e) {
			// 개발할 때 넣는 catch 블록 코드
			e.printStackTrace();  // 에러를 콘솔에 찍어라.
		}
		
	}
	
	public static void m3() {

		File file = new File("C:\\storage", "my.txt");
		
		System.out.println("파일명 : " + file.getName());
		System.out.println("경로 : " + file.getParent());
		System.out.println("전체경로(경로 + 파일명) : " + file.getPath());
		
		System.out.println("디렉터리인가? " + file.isDirectory());
		System.out.println("파일인가? " + file.isFile());
		
		long lastModifiedDate = file.lastModified();
		System.out.println("수정한날짜 : " + lastModifiedDate);
		
		String lastModified = new SimpleDateFormat("a hh:mm yyyy-MM-dd").format(lastModifiedDate);
		System.out.println("수정한날짜 : " + lastModified);
		
		long size = file.length();  // 바이트 단위
		System.out.println("파일크기 : " + size + "byte");
		
	}
	
	public static void m4() {
		
		File dir = new File("D:\\GDJ54");  // C:\\GDJ
		
		File[] list = dir.listFiles();  // 디렉터리 내부의 모든 파일/디렉터리를 File 객체로 가져옴
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i].getName());
		}
		
	}
	
	public static void q1() {
		
	}
	
	public static void main(String[] args) {
		q1();
	}

}
