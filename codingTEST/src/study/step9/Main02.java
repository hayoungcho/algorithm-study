package study.step9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//회의실 배정(Greedy)
class Room implements Comparable<Room>{
	int start;
	int end;
	
	Room(int s, int e){
		this.start = s;
		this.end = e;
	}
	
	//오름차순 negative
	@Override
	public int compareTo(Room o) {
		// TODO Auto-generated method stub
		if(this.end == o.end)
			return this.start - o.start;
		else
			return this.end - o.end;
	}
}

public class Main02 {
	public static int solution(ArrayList<Room> array) {
		int ans = 1;
		Collections.sort(array);
		int endTime = array.get(0).end;
		for(int i = 1; i < array.size(); i++) {
			//시작시간<=끝시간일 경우
			if(endTime <= array.get(i).start) {
				ans++;
				endTime = array.get(i).end;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Room> array = new ArrayList<Room>();
		for(int i = 0; i < n; i++) 
			array.add(new Room(sc.nextInt(), sc.nextInt()));
		
		System.out.println(solution(array));
	}
}
