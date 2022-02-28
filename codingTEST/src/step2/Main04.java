package step2;

import java.util.Scanner;

public class Main04 {
	public static int[] solution(int n ) {
		int[] ans = new int[n];
		
		for(int i = 0; i < n; i++) {
			if(i == 0 || i == 1)
				ans[i] = 1;
			else
				ans[i] = ans[i -1] + ans[i - 2] ;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();

		for(int res : solution(n)) {
			System.out.print(res + "");
		}
//		System.out.println(solution(inputA, inputB));
	}

}
