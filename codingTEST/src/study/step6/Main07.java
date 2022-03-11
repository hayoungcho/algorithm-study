package study.step6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point>{
	public int x = 0;
	public int y = 0; 
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point point) {
		// TODO Auto-generated method stub

		//정렬 순서 this > parameter point 
		//오름차순일 경우 음수값이 return 되어야 함
		if(this.x == point.x)
			return this.y - point.y;
		else
			return this.x - point.x;
	}
}

public class Main07 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Point> arr = new ArrayList<Point>();
		
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr.add(new Point(x, y));
		}
		
		//Comparable의 compareTo 호출
		Collections.sort(arr);
		
		for(Point point : arr)
			System.out.println(point.x + " " + point.y);
	}
}
