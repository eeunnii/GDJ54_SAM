package ex03_reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void m1() {
		
		File file = new File("C:\\storage", "m2.txt");		
		FileReader fr = null;
		
		try {
			// FileReader 클래스 생성
			// file 객체에 등록된 파일이 없으면 FileNotFoundException 발생
			fr = new FileReader(file);
			
			// FileReader 입력 데이터
			// 1. 1글자 : int
			// 2. 여러 글자 : char[]
			
			// 1글자를 저장할 변수
			int c;
			
			// read() 메소드
			// 1. 읽은 문자를 반환
			// 2. 모두 읽어서 읽은 문자가 없으면 -1 반환
			
			// String str에 파일 내용 저장하기
			StringBuilder sb = new StringBuilder();
			while(true) {
				c = fr.read();
				if(c == -1) {
					break;
				}
				sb.append((char)c);
			}
			String str = sb.toString();
			System.out.println(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void m2() {
		
		File file = new File("C:\\storage", "m3.txt");
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(file);
			
			// 5글자를 저장할 배열
			char[] cbuf = new char[9];
			
			// read(char[] cbuf) 메소드
			// 1. 읽은 글자는 cbuf 배열에 저장
			// 2. 실제로 읽은 글자 수를 반환
			// 3. 읽은 글자가 없으면 -1 반환
			while(true) {
				
				int readCnt = fr.read(cbuf);
				
				if(readCnt == -1) {
					break;
				}
			
				for(int i = 0; i < readCnt; i++) {  // 읽은 글자 수(readCnt)만큼 반복
					System.out.print(cbuf[i]);
				}
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) {
					fr.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		m2();
	}

}
