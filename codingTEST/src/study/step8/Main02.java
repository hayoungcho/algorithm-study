package study.step8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main02 {

	static int n;
	static int[] arr;
	static int max;
	static ArrayList<Integer> totalList = new ArrayList<Integer>();
	
	public static void dfs(int level, int sum) {
		if(sum > max)
			return;
		
		if(level == n) {
			totalList.add(sum);
		}else {
			dfs(level + 1, sum + arr[level]);
			dfs(level + 1, sum);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		max = sc.nextInt();
		n = sc.nextInt();
		arr = new int[n];
		
		for(int i = 0; i < n; i++) 
			arr[i] = sc.nextInt();
		
		dfs(0, 0);
		
		Collections.sort(totalList);
		
		System.out.println(totalList.get(totalList.size() - 1));
	}
}
