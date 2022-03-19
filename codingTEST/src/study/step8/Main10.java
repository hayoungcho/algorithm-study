package study.step8;

import java.util.Scanner;

//미로탐색(dfs)
//격자판
public class Main10 {
	static int ans = 0;
	static int[][] board = new int[8][8];
	
	//x, y 진행방향의 경우 dx + dy가 범위 +-1 이내
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void dfs(int x, int y) {
		if(x == 7 && y == 7)
			ans++;
		else {
			for(int i = 0; i < dx.length; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if(mx <= 7 && my <= 7 && mx >= 1 && my >= 1
						&& board[mx][my] == 0) {
					board[mx][my] = 1;
					dfs(mx, my);
					board[mx][my] = 0;
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
		dfs(1, 1);
		
		System.out.println(ans);
	}
}
