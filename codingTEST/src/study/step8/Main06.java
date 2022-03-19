package study.step8;

import java.util.Scanner;

//순열구하기(dfs)
public class Main06 {
	static int m;
	static int[] arr;
	static int[] row;
	static int[] ch;
	
	public static void dfs(int level, int idx) {
		if(level == m) {
			for(int a : row)
				System.out.print(a + " ");
			System.out.println();
		}else {
			for(int i = 0; i < arr.length; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					row[level] = arr[i];
					dfs(level + 1, i + 1);
					ch[i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		row = new int[m];
		ch = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		dfs(0, 1);
	}
}
