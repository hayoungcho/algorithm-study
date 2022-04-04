package programmers.challenges.stackQue;

import java.util.Collections;
import java.util.PriorityQueue;

class Unit implements Comparable<Unit>{
	int itemIdx = 0;
	int priority = 0;
	
	Unit(int i, int p){
		this.itemIdx = i;
		this.priority = p;
	}

	@Override
	public int compareTo(Unit o) {
		// TODO Auto-generated method stub
		return this.priority - o.priority;
	}
}

public class StackQue02 {
	static public int solution(int[] priorities, int location) {
		int answer = 0;
		int[] ch = new int[priorities.length];
		
		PriorityQueue<Unit> pQue = new PriorityQueue<Unit>(Collections.reverseOrder());
	    
		for(int i = 0; i < priorities.length; i++) 
			pQue.add(new Unit(i, priorities[i]));
		
		while(!pQue.isEmpty()) {
			for(int i = 0; i < priorities.length; i++) {
				if(ch[i] == 0) {
					Unit unit = pQue.peek();
					if(priorities[i] == unit.priority) {
						answer++;
						ch[i] = 1;
						if(i == location)
							return answer;
						
						pQue.poll();
					}
				}
			}
		}
		return answer;
    }
	
	public static void main(String[] args) {
//		int [] proprties = {2, 1, 3, 2};
//		int location = 2;
		int [] proprties = {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		System.out.println(solution(proprties, location));
	}
}
