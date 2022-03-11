package study.step5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main06 {

	public static int solution(int n, int k) {
		int ans = 0;
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i = 1; i < n + 1; i++) 
			que.offer(i);
		
		while(!que.isEmpty()) {
			for(int i = 1; i < k; i++) 
				que.offer(que.poll());

			que.poll();
			
			if(que.size() == 1)
				ans = que.poll();

		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(solution(n, k));
	}
}
