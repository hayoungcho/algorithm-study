package study.step9;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//원더랜드(Priority que)
class Element implements Comparable<Element>{
	int to;
	int cost;
	
	Element(int t, int c){
		this.to = t;
		this.cost = c;
	}

	@Override
	public int compareTo(Element o) {
		// TODO Auto-generated method stub
		return this.cost - o.cost;
	}
	
}

public class Main08 {
	static int ch[];
	static int n;
	
	public static int solution(ArrayList<ArrayList<Element>> array) {
		int ans = 0;
		
		PriorityQueue<Element> pQue = new PriorityQueue<Element>();
		pQue.add(new Element(1, 0));
		
		int cnt = 0;
		while(!pQue.isEmpty()) {
			Element ele = pQue.poll();
			
			if(ch[ele.to] != 1) {
				ArrayList<Element> edges = array.get(ele.to); 
				for(Element e : edges) {
					if(ch[e.to] == 0)
						pQue.add(e);
				}
			
				ans += ele.cost;
				ch[ele.to] = 1;
				cnt++;
			}
			if(cnt == n)
				break;
		}
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		ch = new int[n + 1];
		
		ArrayList<ArrayList<Element>> array = new ArrayList<ArrayList<Element>>();
		
		for(int i = 0; i <= m; i++)
			array.add(new ArrayList<Element>());
		
		for(int i = 0; i < m; i++) {
			int p1 = sc.nextInt();
			int p2 = sc.nextInt();
			int cost = sc.nextInt();
			
			array.get(p1).add(new Element(p2, cost));
			array.get(p2).add(new Element(p1, cost));
		}
		
		System.out.println(solution(array));
			
	}
}
