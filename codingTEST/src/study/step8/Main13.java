package study.step8;

import java.util.Scanner;

//섬나라 아일랜드(dfs)
public class Main13 {
	static int arr[][];
	static int ans = 0;
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
	
	public static void solution(int x, int y) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][j] == 1) {
					ans++;
					arr[i][j] = 0;
					dfs(i, j);
				}
			}
		}
	}
	public static void dfs(int x, int y) {
		for(int i = 0; i < dx.length; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if(mx >= 0 && my >= 0 && mx < arr.length 
					&& my < arr.length && arr[mx][my] == 1) {
				arr[mx][my] = 0;
				dfs(mx, my);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				arr[i][j] = sc.nextInt();
		}
		solution(0, 0);
		System.out.println(ans);
		
	}
}
