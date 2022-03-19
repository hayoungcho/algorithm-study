package study.step8;

import java.util.Scanner;

//중복순열구하기
public class Main04 {
	static int n;
	static int m;
	
	static int[] pm;

	public void DFS(int L){
		if(L == m){
			for(int x : pm) 
				System.out.print(x + " ");
			System.out.println();
		}
		else{
			for(int i = 1; i <= n; i++){
				pm[L] = i;
				DFS(L + 1);
			}
		}
	}
	
	public static void dfs(int cnt) {
		if(cnt > n)
			return;
		else {
			for(int i = 1; i <= n; i++)
				System.out.println(cnt + " " + i);
			
			dfs(cnt + 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		pm = new int[m];
		
		dfs(1);
	}
}
