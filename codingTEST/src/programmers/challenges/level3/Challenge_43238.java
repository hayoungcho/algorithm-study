package programmers.challenges.level3;

import java.util.Arrays;

//입국심사
//이분탐색 > 정렬이 되어야있어야함
public class Challenge_43238 {

	public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
//		이분탐색을 위한 정렬
        Arrays.sort(times);

        long min = times[0];
        long max = times[times.length - 1] * n;
        
        long mid = 0;
        long sum = 0;
        while(min <= max) {
        	mid = (min + max) / 2;
        	sum = 0;
        	for(int time : times)
        		sum += mid / time;
        	
        	if(sum >= n) {
        		answer = Math.min(answer, mid);
        		max = mid - 1;
        	}else
        		min = mid + 1;
        }
        return answer;
    }
	 
	public static void main(String args[]) {
		int n = 6;
		int[] times = {7, 10};
	
		System.out.println(solution(n, times));	
	}
	
}
