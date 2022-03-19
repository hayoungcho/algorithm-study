package study.step8;

import java.util.Scanner;

//수열추측하기
public class Main08 {
	static int n;
	static int m;
	static int[] combi;
	static int[] ch;
	static int[] p;
	static int[][] arr;
	static boolean finish = false;
	
	public static void dfs(int level, int sum) {
		if(finish)
			return;
		
		if(level == n) {
			if(sum == m) {
				for(int x : p)
					System.out.print(x + " ");
				finish = true;
			}
		}else {
			for(int i = 1; i <= n; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					p[level] = i;
					dfs(level + 1, sum + p[level] * combi[level]);
					ch[i] = 0;
				}
			}
		}
	}
	
	public static int getCombi(int l, int r) {
		if(r == 0 || l == r)
			return 1;
		else if(r == 1)
			return l;
		else {
			if(arr[l][r] == 0)
				return arr[l][r] = getCombi(l - 1, r - 1) + getCombi(l - 1, r);
			else
				return arr[l][r];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		combi = new int[n];
		p = new int[n];
		ch = new int[n + 1];
		arr = new int[n][n];

		for(int i = 0; i < n; i++)
			combi[i] = getCombi(n - 1, i);
		
		dfs(0, 0);
	}
		
}
