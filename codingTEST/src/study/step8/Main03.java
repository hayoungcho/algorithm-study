package study.step8;

import java.util.Scanner;

public class Main03 {
	
	static int ans = 0;
	static int[][] arr;
	static int timeLimit = 0;
	static int n = 0;
	static int maxScore = 0;
	static int totTime = 0;

	public static void dfs(int level, int score, int time) {
		if(timeLimit < totTime)
			return;
		
		if(level == n) {
			ans = Math.max(ans, maxScore);
		}else {
			dfs(level + 1, maxScore + arr[level][0], totTime + arr[level][1]);
			dfs(level + 1, maxScore, totTime);
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
