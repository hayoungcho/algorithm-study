package study.step8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//익은 토마토
//class Point{
//	int x;
//	int y;
//	Point(int x, int y){
//		this.x = x;
//		this.y = y;
//	}
//}
public class Main12 {
	static int arr[][];
	
	static int days[][];
	static int n, m;
	static Queue<Point> que = new LinkedList<Point>();
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void bfs() {
		while(!que.isEmpty()) {
			Point point = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int mx = point.x + dx[i];
				int my = point.y + dy[i];
				
				if(mx >= 0 && my >=0 && mx < m && my < n && arr[mx][my] == 0) {
					arr[mx][my] = 1;
					que.offer(new Point(mx, my));
					days[mx][my] = days[point.x][point.y] + 1;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[m][n];
		days = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				
				if(arr[i][j] == 1)
					que.offer(new Point(i, j));
			}
		}
		
		bfs();
		
		int ans = Integer.MIN_VALUE;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				ans = Math.max(ans, days[i][j]);
			}
		}
		
		if(ans == 0)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}
