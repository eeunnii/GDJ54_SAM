package prac04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// 입력 받은 정수 -> 배열의 길이로 사용하기
		// 1~100만 가능
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇 개 생성할까요? >>> ");
		int count = sc.nextInt();
		
		if(count < 1 || count > 100) {
			System.out.println("1~100 사이만 가능합니다.");
			sc.close();
			return;
		}
		
		int[] arr = new int[count];
		
		// 배열 arr에 난수(1~100) 저장
		// 중복 생성되면 재생성
		for(int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random() * 100) + 1;
			if(CheckArray.exists(arr, i, random)) {
				i--;
				continue;  // for문의 i++로 이동함. 중복 생성된 경우 인덱스 i의 변화를 주지 않기 위해서 미리 i--를 해 둔 상태임.
			}
			arr[i] = random;
		}
		
		// 배열 arr의 출력: 한 줄에 10개씩
		for(int i = 0; i < arr.length; i++) {
			if(i != 0 && i % 10 == 0)
				System.out.println();
			System.out.print(arr[i] + "\t");
		}
		
		sc.close();
		
	}

}
