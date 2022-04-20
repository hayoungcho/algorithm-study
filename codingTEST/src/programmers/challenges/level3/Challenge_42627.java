package programmers.challenges.level3;

import java.util.Arrays;
import java.util.PriorityQueue;

//디스크 컨트롤러
class Work implements Comparable<Work>{
	int start = 0;
	int time = 0;
	
	Work(int s, int t){
		this.start = s;
		this.time = t;
	}

	//오름차순
	@Override
	public int compareTo(Work o) {
		// TODO Auto-generated method stub
		return this.time - o.time;
	}
}
public class Challenge_42627 {

	public static int solution(int[][] jobs) {
        int answer = 0;
        
       //시간 순 오름차순
       Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
       PriorityQueue<Work> waitQue = new PriorityQueue<Work>();

       int cnt = 0;
       int end = 0;
       int jobIdx = 0;
       
       //모든 작업이 끝날 때까지
       while(cnt < jobs.length) {
    	   //작업이 끝나는 시간에 먼저 도착한 job 대기 que에 추가
    	   while(jobIdx < jobs.length && jobs[jobIdx][0] <= end) {
    		   waitQue.add(new Work(jobs[jobIdx][0], jobs[jobIdx][1]));
    		   jobIdx++;
			};
			
			if(waitQue.isEmpty())
				end = jobs[jobIdx][1];
			else {
				Work w = waitQue.poll();
				answer += w.time + end - w.start;
				//수행시간
				end += w.time;
				cnt++;
			}
       }
       
       return answer / jobs.length;
    }
	
	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		
		System.out.println(solution(jobs));
	}

}
