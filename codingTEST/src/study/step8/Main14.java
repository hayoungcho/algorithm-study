package study.step8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//섬나라 아일랜드(bfs)
public class Main14 {
	static int arr[][];
	static int ans = 0;
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
	
	public static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<Point>();
		que.offer(new Point(x, y));
		
		while(!que.isEmpty()) {
			Point point = que.poll();
			for(int i = 0; i < dx.length; i++) {
				int mx = point.x + dx[i];
				int my = point.y + dy[i];
				
				if(mx >= 0 && my >= 0 && mx < arr.length
						&& my < arr.length && arr[mx][my] == 1) {
					arr[mx][my] = 0;
					que.add(new Point(mx, my));
				}
			}
		}
		
	}
	
	public static void solution(int x, int y) {
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length; j++){
				if(arr[i][j] == 1) {
					ans++;
					arr[i][j] = 0;
					bfs(i, j);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				arr[i][j] = sc.nextInt();
		}
		
		solution(0, 0);
		System.out.println(ans);
	}
}
