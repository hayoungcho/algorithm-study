package step3;

import java.util.Scanner;

public class Main04_02 {

	/*
	 * 연속 부분 수열
	 * 연속된 수열의 합이 n이 되는 수
	 */
	public static int solution(int[] arr, int a) {
		int ans = 0;
		int sum = 0;

		int lt = 0;
		for(int rt = 0; rt < arr.length; rt++) {
			sum += arr[rt];
			
			if(sum == a)
				ans++;
			
			while(sum >= a) {
				sum -= arr[lt++];
				if(sum == a)
					ans++;
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int a = kb.nextInt();
		int b = kb.nextInt();
		int[] arr = new int[a];
		for(int i = 0; i < a; i++ )
			arr[i] = kb.nextInt(); 
		
		System.out.print(solution(arr , b));
	}
}
