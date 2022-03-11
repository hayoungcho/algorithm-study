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

		//���� ���� this > parameter point 
		//���������� ��� �������� return �Ǿ�� ��
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
		
		//Comparable�� compareTo ȣ��
		Collections.sort(arr);
		
		for(Point point : arr)
			System.out.println(point.x + " " + point.y);
	}
}
