package study.step9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//°áÈ¥½Ä(Greedy)
class Time implements Comparable<Time>{
	int come;
	int go;
	
	Time(int c, int g){
		this.come = c;
		this.go = g;
	}

	@Override
	public int compareTo(Time o) {
		// TODO Auto-generated method stub
		if(this.come == o.come)
			return this.go - o.go;
		else
			return this.come - o.come;
	}
}

public class Main03 {
	
	public static int solution(ArrayList<Time> array) {
		int ans = Integer.MIN_VALUE;
		Collections.sort(array);
		int endTime = array.get(0).go;
		
		int cnt = 1;
		for(int i = 1; i < array.size(); i++) {
			if(endTime > array.get(i).come) {
				cnt++;
			}else {
				endTime = array.get(i).go;
				cnt--;
			}
			ans = Math.max(ans, cnt);
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Time> array = new ArrayList<Time>();
		
		for(int i = 0; i < n; i++) 
			array.add(new Time(sc.nextInt(), sc.nextInt()));
		
		System.out.println(solution(array));
		
	}
}
