package study.step8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//동전교환(dfs)
public class Main05 {
	static int ans = Integer.MAX_VALUE;
	static int m;
	static Integer[] arr;
	
	public static void dfs(int total, int cnt) {
		if(cnt >= ans)
			return;
		if(total == m) {
			ans = Math.min(ans, cnt);
		}else {
			for(int i = 0; i < arr.length; i++) {
				if(total + arr[i] <= m)
					dfs(total + arr[i], cnt + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		arr = new Integer[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		m = sc.nextInt();
		Arrays.sort(arr, Collections.reverseOrder());
		
		dfs(0, 0);
		
		System.out.println(ans);
	}
		
	
}
