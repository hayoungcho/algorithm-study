package study.step9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	//정점
	int vex;
	int cost;
	
	Edge(int v, int c){
		this.vex = v;
		this.cost = c;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
}
//다익스트라
public class Main05 {
	static ArrayList<ArrayList<Edge>> graph;
	static int dis[];
	
	public static void solution(int a) {
		PriorityQueue<Edge> pQue = new PriorityQueue<Edge>();

		//시작점 1
		pQue.offer(new Edge(a, 0));
		dis[a] = 0;
		
		while(!pQue.isEmpty()) {
			Edge tmp = pQue.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			if(nowCost > dis[now])
				continue;
			
			for(Edge ob : graph.get(now)) {
				if(dis[ob.vex] > nowCost + ob.cost) {
					dis[ob.vex] = nowCost + ob.cost;
					pQue.offer(new Edge(ob.vex, nowCost + ob.cost));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		graph = new ArrayList<ArrayList<Edge>>();
		
		for(int i = 0; i <= n; i++)
			graph.add(new ArrayList<Edge>());
		
		dis = new int[n = 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			graph.get(a).add(new Edge(b, c));
		}
		
//		solution(1);
		
		for(int i = 2; i <= n; i++) {
			if(dis[i] != Integer.MAX_VALUE)
				System.out.println(i + " : " + dis[i]);
			else
				System.out.println(i + " : impossible");
		}
		
		
	}
}
