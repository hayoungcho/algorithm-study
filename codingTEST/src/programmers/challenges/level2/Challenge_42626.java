package programmers.challenges.level2;

import java.util.PriorityQueue;

//스코빌 지수
public class Challenge_42626 {

	public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<Integer>();
        
        for(int s : scoville)
        	que.offer(s);
        
        while(que.peek() < K) {
        	if(que.size() == 1)
        		return -1;
        	
        	int first = que.poll();
        	int second = que.poll();
        	
        	que.offer(first + second * 2);
        	
        	answer++;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] scoville= {1, 2, 3, 9, 10, 12};
		int K = 7;
		
		System.out.println(solution(scoville, K));
	}
}
