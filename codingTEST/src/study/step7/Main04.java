package study.step7;

import java.util.Scanner;

public class Main04 {
	static int[] fibo;
	//메모이제이션
	public static int dfs(int n) {
		if(fibo[n] > 0)
			return fibo[n];
		
		if(n == 1 || n ==2)
			return fibo[n] = 1;
		else {
			
			return fibo[n] = dfs(n - 2) + dfs(n - 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		fibo = new int[n + 1];
		
		dfs(n);
		for(int i = 1; i < n; i++)
			System.out.print(fibo[i] + " ");
	}
}
