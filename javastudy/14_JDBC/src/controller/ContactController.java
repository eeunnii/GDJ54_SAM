package controller;

import java.util.Scanner;

public class ContactController {

	private Scanner sc;
	
	public ContactController() {
		sc = new Scanner(System.in);
	}
	
	public void menu() {
		System.out.println("1.연락처등록");
		System.out.println("2.연락처수정");
		System.out.println("3.연락처삭제");
		System.out.println("4.연락처조회");
		System.out.println("5.전체연락처");
		System.out.println("0.종료");
	}
	
	public void play() {
		while(true) {
			menu();
			System.out.print("선택 >>> ");
			int choice = sc.nextInt();  // 숫자는 choice에 저장
			sc.nextLine();              // 숫자 입력하고 누른 엔터 처리
			switch(choice) {
			case 1: break;
			case 2: break;
			case 3: break;
			case 4: break;
			case 5: break;
			case 0: return;
			default: System.out.println("다시 선택하세요!");
			}
		}
	}
	
}
