package study.step8;

import java.util.Scanner;

//최대점수구하기(DFS)
public class Main03 {
	
	static int ans = 0;
	static int[][] arr;
	static int timeLimit = 0;
	static int n = 0;

	public static void dfs(int level, int score, int time) {
		if(timeLimit < time)
			return;
		
		if(level == (n - 1)) {
			ans = Math.max(ans, score);
		}else {
			dfs(level + 1, score + arr[level][0], time + arr[level][1]);
			dfs(level + 1, score, time);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		timeLimit = sc.nextInt();
		
		arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		dfs(0, 0, 0);
		
		System.out.println(ans);
		
		
	}

}
