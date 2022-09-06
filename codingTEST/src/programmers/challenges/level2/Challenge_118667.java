package programmers.challenges.level2;

import java.util.LinkedList;
import java.util.Queue;

//두 큐 합 같게 만들기
public class Challenge_118667 {

	//loop count 주의
	//Dequeue - 큐의 first, end 엘리먼트의 삽입, 삭제 지원하는 자료구조
	//구현클래스 : ArrayDeque, LinkedBlockingDeque, ConcurrentLinkedDeque, LinkedList 
	public static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<Integer>();
        Queue<Integer> que2 = new LinkedList<Integer>();

        long sum1 = 0;
        for(int i : queue1) {
        	sum1 += i;
        	que1.offer(i);
        }

        long sum2 = 0;
        for(int i : queue2) {
        	sum2 += i;
        	que2.offer(i);
        }
        
        if((sum1 + sum2) % 2 == 1)
        	return -1;
        
        int cnt = 0;
        while(sum1 != sum2) {
        	cnt++;
        	
        	if(sum1 > sum2) {
        		int poll = que1.poll();
        		sum1 -= poll;
        		sum2 += poll;
        		que2.offer(poll);
        	}else {
        		int poll = que2.poll();
        		sum2 -= poll;
        		sum1 += poll;
        		que1.offer(poll);
        	}
        	
        	if(cnt > (que1.size() + que2.size()) * 2)
        		return -1;
        }
        
        return cnt;
    }
	
	public static void main(String args[]) throws Exception {
		int[] queue1 = {3, 2, 7, 2};
		int[] queue2 = {4, 6, 5, 1};
		
		System.out.println(solution(queue1, queue2));
	}
}
