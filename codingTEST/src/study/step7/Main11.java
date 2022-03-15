package study.step7;

import java.util.Scanner;

public class Main11 {
	static int ans = 0;
	static int[] ch;
	static public void dfs(int n, int[][] arr, int point) {
		if(point == n) {
			ans++;
		}else {
			for(int i = 1; i <= n; i++) {
				if(arr[point][i] == 1 && ch[i] == 0) {
					ch[i] = 1;
					dfs(n, arr, i);
					ch[i] = 0;
				}
			}
		}
	}
	
	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		ch = new int[n+1];
		int[][] arr = new int[n + 1][n + 1];
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
		}
		ch[1] = 1;
		dfs(n, arr, 1);
		System.out.println(ans);
	}
	
	 
}
