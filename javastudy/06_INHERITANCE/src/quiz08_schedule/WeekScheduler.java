package quiz08_schedule;

import java.util.Scanner;

public class WeekScheduler {

	private int nthWeek;  // 1 ~ n주차
	private Day[] week;
	private String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
	private Scanner sc;
	
	public WeekScheduler(int nthWeek) {
		this.nthWeek = nthWeek;
		week = new Day[7];
		sc = new Scanner(System.in);
	}
	
	private void makeSchedule() {
		System.out.println("▒▒▒ 등록 ▒▒▒");
		System.out.print("요일 입력 >>> ");
		String dayName = sc.next().substring(0, 1);
		sc.nextLine();
		for(int i = 0; i < week.length; i++) {
			if(dayName.equals(dayNames[i])) {
				if(week[i] == null) {  // 등록된 스케쥴이 없으면
					
				} else {
					System.out.println(dayName + "요일은 이미 스케쥴이 있습니다.");
				}
				return;
			}
		}
		System.out.println(dayName + "요일은 없는 요일입니다.");
	}
	
	private void changeSchedule() {
		System.out.println("▒▒▒ 수정 ▒▒▒");
	}
	
	private void deleteSchedule() {
		System.out.println("▒▒▒ 삭제 ▒▒▒");
	}
	
	private void printWeekSchedule() {
		System.out.println("▒▒▒ 전체조회 ▒▒▒");
	}
	
	public void manage() {
		
		while(true) {
			
			System.out.print("1.등록 2.수정 3.삭제 4.전체조회 0.종료 >>> ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 : makeSchedule(); break;
			case 2 : changeSchedule(); break;
			case 3 : deleteSchedule(); break;
			case 4 : printWeekSchedule(); break;
			case 0 : System.out.println("스케쥴러를 종료합니다."); return;
			default : System.out.println("인식할 수 없는 명령입니다.");
			}
			
		}
		
	}
	
}
