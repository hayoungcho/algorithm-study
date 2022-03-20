package study.step8;

import java.util.ArrayList;
import java.util.Scanner;

public class Main15 {
	static int[] combi;
	static int ans = Integer.MAX_VALUE;
	static int m;
	static ArrayList<Point> house = new ArrayList<Point>();
	static ArrayList<Point> pizza = new ArrayList<Point>();

	public static void dfs(int level, int s) {
		if(level == m) {
			int sum = 0;
			for(Point h : house) {
				int dis = Integer.MAX_VALUE;
				for(int i : combi) {
					dis = Math.min(dis, Math.abs(h.x - pizza.get(i).x) + 
							Math.abs(h.y - pizza.get(i).y));
				}
				//도시의 피자배달거리
				sum += dis;
			}
			ans = Math.min(ans, sum);
		}else {
			//조합
			for(int i = s; i < pizza.size(); i++) {
				combi[level] = i;
				dfs(level + 1, i + 1);
			}
		}
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int input = sc.nextInt();
				if(input == 1)
					house.add(new Point(i, j));
				else if(input == 2)
					pizza.add(new Point(i, j));
			}
		}
		
		combi = new int[m];
		dfs(0, 0);
		System.out.println(ans);
	}
}
