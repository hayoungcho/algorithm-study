package programmers.challenges.stackQue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Progress{
	int progress = 0; 
	int speed = 0;
	int idx = 0;
	
	public Progress(int p, int s, int i) {
		this.progress = p;
		this.speed = s;
		this.idx = i;
	}
	
	public void setProgress(int progress) {
		this.progress = progress;
	}
}
public class StackQue01 {
	static public int[] solution2(int[] progresses, int[] speeds) {
		List<Integer> returnList = new ArrayList<Integer>();
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(int i = 0; i < progresses.length; i++) {
			//일 진행에 필요한 days
			int days = (int) Math.ceil((100 - progresses[i]) / (double)speeds[i]);
			
			if(!que.isEmpty() && que.peek() < days) {
				returnList.add(que.size());
				que.clear();
			}
			
			que.offer(days);
		}
		
		returnList.add(que.size());
		
		return returnList.stream().mapToInt(Integer::intValue).toArray();
	}
	
	static public int[] solution(int[] progresses, int[] speeds) {
		int ans[] = {};
		int[] chk = new int[progresses.length];
		List<Integer> returnList = new ArrayList<Integer>();
        Queue<Progress> que = new LinkedList<Progress>();
        
        for(int i = 0; i < progresses.length; i++)
        	que.offer(new Progress(progresses[i], speeds[i], i));
        
        int cnt = 0;
        int priorIdx = 0;
        while(!que.isEmpty()) {
        	Progress progress = que.poll();
        	
        	if(progress.progress < 100) {
        		if(progress.progress + progress.speed >= 100)
        			chk[progress.idx] = 1;
        		
        		progress.setProgress(progress.progress + progress.speed);
        		que.offer(progress);

        	}else {
        		if(priorIdx >= progress.idx) {
        			for(int i = progress.idx; i < chk.length; i++) {
        				if(chk[i] == 1) {
        					cnt++;
        					chk[i] = 0;
        				}else
        					break;
        			}
        			if(cnt != 0)
        				returnList.add(cnt);
        			cnt = 0;
        			
        			if(!que.isEmpty())
        				priorIdx = que.peek().idx;
        		}
        	}
        }

        ans = new int[returnList.size()];
        for(int i = 0; i < returnList.size(); i++)
    		ans[i] = returnList.get(i).intValue();
        		
        return ans;
    }
	
	public static void main(String args[]) {
//		int[] progresses = {93, 30, 55};
//		int[] speeds = {1, 30, 5};
//		int[] progresses = {95, 90, 99, 99, 80, 99};
//		int[] speeds = {1, 1, 1, 1, 1, 1};
		int[] progresses = {0, 0, 0, 0};
		int[] speeds = {100, 50, 34, 25};
		
		for(int i : solution(progresses, speeds))
			System.out.print(i + " ");
	}
}
