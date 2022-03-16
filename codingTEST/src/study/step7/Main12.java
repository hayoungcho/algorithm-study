package study.step7;

import java.util.ArrayList;
import java.util.Scanner;

//경로탐색(인접리스트)
//인접리스트 : 정점이 많을 때 행렬은 비효율적이므로 리스트 사용
public class Main12 {
	static int ans = 0;
	static int n;
	static int m;
	static int[] ch;
	static ArrayList<ArrayList<Integer>> graph; 
	
	public static void dfs(int v) {
		if(v == n)
			ans++;
		else {
			for(int nv : graph.get(v)) {
				if(ch[nv] == 0) {
					ch[nv] = 1;
					dfs(nv);
					ch[nv] = 0;
				}
			}
		}
	}
	
	static public void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();

		ch = new int[n + 1];
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <= n; i++)
			graph.add(new ArrayList<Integer>());
		
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph.get(x).add(y);
		}
		
		ch[1] = 1;
		dfs(1);
		System.out.println(ans);
	}
}
