package prac04;

public class CheckArray {
	
	public static boolean exists(int[] arr, int idx, int number) {
		
		// 배열arr의 인덱스 0부터 idx사이에 number가 존재하면 true 아니면 false 반환
		for(int i = 0; i <= idx; i++)
			if(arr[i] == number)
				return true;
		
		return false;
		
	}
	
}
