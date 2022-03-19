package study.step8;

import java.util.Scanner;

//조합수(메모이제이션)
public class Main07 {
	static int n;
	static int m;
	static int[][] arr;
	
	public static int dfs(int l, int r) {
		if(r == 1)
			return l;
		else if(r == 0 || r ==l)
			return 1;
		else {
			if(arr[l][r] == 0) {
				return arr[l][r] = dfs(l - 1, r - 1) + dfs(l - 1, r);
			}else
				return arr[l][r]; 
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n + 1][m + 1];
		System.out.println(dfs(n, m));
	}
}
