package study.step10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick>{
	int dimen;
	int height;
	int weight;
	
	Brick(int d, int h, int w){
		this.dimen = d;
		this.height = h;
		this.weight = w;
	}

	@Override
	public int compareTo(Brick o) {
		// TODO Auto-generated method stub
		return o.dimen - this.dimen;
	}
}
public class Main04 {
	public static int solution(ArrayList<Brick> array) {
		Collections.sort(array);
		
		int ans = array.get(0).height;
		int maxD = array.get(0).dimen;
		int maxW = array.get(0).weight;
		for(int i = 1; i < array.size(); i++) {
			if(maxD > array.get(i).dimen && maxW > array.get(i).weight) {
				ans += array.get(i).height;
				maxD = array.get(i).dimen;
				maxW = array.get(i).weight;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Brick> array = new ArrayList<Brick>();
		
		for(int i = 0; i < n; i++)
			array.add(new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		
		System.out.println(solution(array));
	}
}
