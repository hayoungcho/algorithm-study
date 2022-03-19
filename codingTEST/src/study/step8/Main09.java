package study.step8;

import java.util.Scanner;

//조합 구하기
public class Main09 {
	static int n;
	static int m;
	static int[] ans;
	
	public static void dfs(int level, int start) {
		if(level == m) {
			for(int a : ans)
				System.out.print(a + " ");
			System.out.println();
		}else {
			for(int i = start; i <= n; i++) {
				ans[level] = i;
				dfs(level + 1, i + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		ans = new int[m];
		
		dfs(0, 1);
	}
}
