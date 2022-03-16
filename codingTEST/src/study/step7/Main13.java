package study.step7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//그래프 최단거리(bfs, 인접리스트)
//최단거리의 경우 bfs사용
public class Main13 {
	static int ans = 0;
	static int n;
	static int m;
	static int[] ch;
	static int[] dis;
	static ArrayList<ArrayList<Integer>> graph; 
	
	public static void bfs(int v) {
		Queue<Integer> que = new LinkedList<Integer>();
		ch[v] = 1;
		dis[v] = 0;
		que.offer(v);
		
		while(!que.isEmpty()) {
			int cv = que.poll();
			for(int nv : graph.get(cv)) {
				if(ch[nv] == 0) {
					ch[nv] = 1;
					que.offer(nv);
					dis[nv] = dis[cv] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		ch = new int[n + 1];
		dis = new int[n + 1];
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <= n; i++)
			graph.add(new ArrayList<Integer>());
		
		for(int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph.get(x).add(y);
		}
		
		bfs(1);
		
		for(int i = 2; i <= n; i++)
			System.out.println(i + " : " + dis[i]);

	}
}
