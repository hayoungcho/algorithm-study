package study.step9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point>{
	int start;
	int end;
	int cost;
	
	Point(int s, int e, int c){
		this.start = s;
		this.end = e;
		this.cost = c;
	}
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		//오름차순
		return this.cost - o.cost;
	}
}
//원더랜드(최소스패닝트리 : 크루스칼, Union&Find 활용)
//최소유지비용 출력
public class Main07 {
	static int[] unf;

	//회로가 되면 안됨
	public static int find(int a) {
		if(a == unf[a])
			return unf[a];
		else
			return unf[a]= find(unf[a]);
	}
	
	public static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		
		if(fa != fb)
			unf[fa] = fb;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		unf = new int[n + 1];
		
		ArrayList<Point> array = new ArrayList<Point>();
		for(int i = 1; i <= n; i++)
			unf[i] = i;
		
		for(int i = 0; i < m; i++)
			array.add(new Point(sc.nextInt(), sc.nextInt(), sc.nextInt()));
	
		int ans = 0;
		//cost에 따른 오름차순
		Collections.sort(array);
		
		for(Point p : array) {
			int start = find(p.start);
			int end = find(p.end);
			
			if(start != end) {
				ans += p.cost;
				//같은 집합으로 union
				union(start, end);
			}
		}
		
		
		System.out.println(ans);
	}
}
