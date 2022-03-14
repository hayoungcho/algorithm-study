package study.step7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//송아지찾기(BFS : 상태트리탐색)
//최소 거리 탐색 시 사용
public class Main08 {

	static int ans = 0;
	static Queue<Integer> que = new LinkedList<>();
	static int[] ch;
	static int[] distance = {1, -1, 5};
	
	public static int bfs(int hyunsoo, int song) {
		ch = new int[10001];
		ch[hyunsoo] = 1;
		que.offer(hyunsoo);
		int level = 0;
		
		while(!que.isEmpty()) {
			int len = que.size();
			for(int i = 0; i < len; i++) {
				int x = que.poll();
				if(x == song)
					return level;
				for(int j = 0; j < distance.length; j++) {
					int nx = x + distance[j];
					if(nx >= 1 && nx <= 10000 && ch[nx] == 0) {
						que.offer(nx);
						ch[nx] = 1;
					}
				}
			}
			level++;
		}
		return ans; 
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hyunsoo = sc.nextInt();
		int song = sc.nextInt();
		
		System.out.println(bfs(hyunsoo, song));
	}
}
