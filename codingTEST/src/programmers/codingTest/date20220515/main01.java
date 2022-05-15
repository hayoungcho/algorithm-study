package tmp;

import java.util.Collections;
import java.util.PriorityQueue;

public class main01 {
	
	public static int solution(int[] v, int a, int b) {
		int answer = 0;
		boolean progress = true;
		PriorityQueue<Integer> que = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int truck : v)
			que.add(truck);
		
		while(progress) {
			int pre = que.poll();
			if(pre >= a) {
				int[] posArr = new int[v.length - 1];
				for(int i = 0; i < posArr.length; i++) {
					int pos = que.poll();
					if(pos < b)
						progress = false;
					else
						posArr[i] = pos - b;
				}
				
				if(progress) {
					for(int pos : posArr)
						que.add(pos);
				}
				
				if(que.peek() < a)
					progress = false;
				else 
					que.add(pre - a);
				answer++;
			}else
				progress = false;
			
		}
		
		return answer;
	}
	public static void main(String[] args) {
		int[] v = {4, 5, 5};
		int a = 6;
		int b= 1;
		
		System.out.println(solution(v, a, b));
	}
}
