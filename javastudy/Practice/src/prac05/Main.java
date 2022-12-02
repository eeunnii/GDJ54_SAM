package prac05;

public class Main {

	public static void main(String[] args) {
	
		String[] names = {
				"상철",
				"영희",
				"희수",
				"정숙",
				"재홍"
		};
		
		int[] scores = new int[names.length];
		
		for(int i = 0; i < scores.length; i++) {
			scores[i] = (int)(Math.random() * 101);
			System.out.println((i + 1) + "번째 학생 이름: " + names[i] + ", 점수: " + scores[i] + "점");
		}
		
		int total = scores[0];
		int max = scores[0];
		int min = scores[0];
		int top = 0;
		int bottom = 0;
		for(int i = 1; i < scores.length; i++) {
			total += scores[i];
			if(max < scores[i]) {
				max = scores[i];
				top = i;
			}
			if(min > scores[i]) {
				min = scores[i];
				bottom = i;
			}
		}
		
		double average = (double)total / scores.length;
		System.out.println("평균 : " + average + "점");
		System.out.println("1등 점수 : " + max + "점");
		System.out.println("1등 이름 : " + names[top]);
		System.out.println("꼴등 점수 : " + min + "점");
		System.out.println("꼴등 이름 : " + names[bottom]);
		
	}
	
}
