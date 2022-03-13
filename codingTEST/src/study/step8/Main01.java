package study.step8;

import java.util.Scanner;

public class Main01 {
	
	static String ans = "NO";
	static int n = 0; 
	static int total = 0;
	static boolean flag = false;
	static int[] arr;
	
	public static void dfs(int level, int sum) {
		if(flag) 
			return;
		
		if(level == n) {
			if(total / 2 == sum) {
				ans = "YES";
				flag = true;
			}
		}else {
			dfs(level + 1, sum + arr[level]);
			dfs(level + 1, sum);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		
		dfs(0, 0);
		
		System.out.println(ans);
	}

}
