package study.step8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//미로의 최단거리 통로(bfs)
//격자판
class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main11_1 {
	static int[][] board = new int[8][8];
	static int[][] dis = new int[8][8];
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<Point>();
		que.offer(new Point(x, y));
		
		while(!que.isEmpty()) {
			Point point = que.poll();
			
			for(int i = 0; i < dx.length; i++) {
				int mx = point.x + dx[i];
				int my = point.y + dy[i];
				if(mx <= 7 && my <= 7 && mx >= 1 && my >= 1
						&& board[mx][my] == 0) {
					board[mx][my] = 1;
					que.offer(new Point(mx, my));
					dis[mx][my] = dis[point.x][point.y] + 1;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; i <= 7; i++) {
			for(int j = 1; j <= 7; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		//시작점 change
		board[1][1] = 1;
		bfs(1, 1);
		
		int ans = dis[7][7];
		if(ans == 0)
			ans = -1;
		System.out.println(ans);
	}
}
