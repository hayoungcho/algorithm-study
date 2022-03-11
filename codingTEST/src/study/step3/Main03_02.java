package study.step3;

import java.util.Scanner;

public class Main03_02 {
	
	public static int solution(int[] arr, int b) {
		int ans = 0;
		for(int i = 0; i < b; i++) {
			ans += arr[i];
		}
		
		int tmp = ans;
		for(int i = b; i < arr.length; i++) {
			tmp = tmp - arr[i - b] + arr[i];
			if(tmp > ans)
				ans = tmp;
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
