package study.step9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//씨름선수(Greedy)
class Athlete implements Comparable<Athlete>{
	int height;
	int weight;
	
	Athlete(int h, int w){
		this.height = h;
		this.weight = w;
	}

	@Override
	public int compareTo(Athlete o) {
		// TODO Auto-generated method stub
		//h에 의한 내림차순
		return o.height - this.height;
	}
}
public class Main01 {
	
	public static int solution(ArrayList<Athlete> array) {
		//가장 큰 도전자(height)
		int ans = 1;
		Collections.sort(array);
		
		int max = array.get(0).weight;
		for(int i = 1; i < array.size(); i++) {
			if(max < array.get(i).weight) {
				max = array.get(i).weight;
				ans++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Athlete> array = new ArrayList<Athlete>();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			array.add(new Athlete(h, w));
		}
		System.out.println(solution(array));
	}
}
