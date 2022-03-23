package study.step9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Schedule implements Comparable<Schedule>{
	int day;
	int pay;
	
	Schedule(int p, int d){
		this.pay = p;
		this.day = d;
	}

	@Override
	public int compareTo(Schedule o) {
		// TODO Auto-generated method stub
		//내림차순
		return o.day - this.day;
	}
}
	
//최대수입스케줄(Priority Queue)
public class Main04 {
	static public int maxDate = Integer.MIN_VALUE;
	public static int solution(ArrayList<Schedule> array) {
		int ans = 0;
		Collections.sort(array);
		//내림차순 sort - > 가장 큰 값을 return
		//dafult는 오름차순 -> 가장 작은 값 return 
		PriorityQueue<Integer> pQue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i = maxDate; i >= 1; i--) {
			for(int j = 0; j < array.size(); j++) {
				if(array.get(j).day > i)
					break;
				
				pQue.offer(array.get(j).pay);
			}
			if(!pQue.isEmpty())
				ans += pQue.poll();
		}
		return ans;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Schedule> array = new ArrayList<Schedule>();
		for(int i = 0; i < n; i++) {
			int pay = sc.nextInt();
			int day = sc.nextInt();
			array.add(new Schedule(pay, day));
			
			if(day > maxDate)
				maxDate = day;
		}
		
		System.out.println(solution(array));
	}
}
