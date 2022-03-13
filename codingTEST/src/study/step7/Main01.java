package study.step7;

import java.util.Scanner;

public class Main01 {
	
	public static void dfs(int num) {
		if(num == 0)
			return;
		
		dfs(num  - 1);
		System.out.print(num + " ");
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dfs(n);
	}
}
