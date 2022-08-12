package ex04_outputstream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {

	public static void m1() {
		
		File file = new File("C:\\storage", "b1.bin");
		FileOutputStream fos = null;
		
		try {
			
			// C:\\storage\\b1.bin 파일과 연결되는 바이트 출력 스트림 생성
			fos = new FileOutputStream(file);
			
			// 출력할 데이터 단위
			// 1. 1개 : int
			// 2. 여러 개 : byte[]
			
			// 출력할 데이터
			int c = 'A';
			String str = "pple Mango 맛있다.";
			byte[] b = str.getBytes(StandardCharsets.UTF_8);  // str.getBytes("UTF-8")
			
			// 출력
			fos.write(c);
			fos.write(b);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) fos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void m2() {
		
		// 출력 속도 향상을 위한 BufferedOutputStream
		
		File file = new File("C:\\storage", "b2.bin");
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			
			String str = "안녕하세요 반갑습니다.";
			byte[] b = str.getBytes("UTF-8");
			
			bos.write(b);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) bos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void m3() {
	
		// 변수를 그대로 출력하는 DataOutputStream
		
		File file = new File("C:\\storage", "b3.dat");
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
			
			fos = new FileOutputStream(file);
			dos = new DataOutputStream(fos);
			
			// 출력할 변수
			String name = "에밀리";
			int age = 30;
			double height = 165.5;
			
			// 출력
			dos.writeUTF(name);
			dos.writeInt(age);
			dos.writeDouble(height);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dos != null) dos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public static void main(String[] args) {
		m3();
	}

}
