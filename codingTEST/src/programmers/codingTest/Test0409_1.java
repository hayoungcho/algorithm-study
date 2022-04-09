package programmers.codingTest;

import java.util.Stack;

class Point{
	Character direction;
	int distance = 0;

	Point(Character dir, int dis){
		this.direction = dir;
		this.distance = dis;
	}
}
public class Test0409_1 {
	public static String[] solution(String path) {
		String[] answer = {};
		Stack<Point> stack = new Stack<Point>();
		
		int cnt = 1;
		for(int i = path.length() - 1; i >= 0 ; i--) {
			if(i != 0 && path.charAt(i) == path.charAt(i - 1)) {
				cnt++;
			}else {
				stack.push(new Point(path.charAt(i), cnt));
				cnt = 1;
			}
		}
		answer = new String[stack.size() - 1];
		int time = 0;
		int idx = 0;
		Point now = stack.pop();
		while(!stack.isEmpty()) {
			Point next = stack.pop();
			Character dir = next.direction;
			String dirStr = getDirection(now.direction, dir);
			int distance = now.distance;
			
			while(distance > 5) {
				int diff = distance - 5;
				distance -= diff;
				time += diff;
			}
			answer[idx] = "Time " + time + ": Go straight " + distance * 100 
					+ "m and turn " + dirStr;
			
			time += distance;
			now = next;
			idx++;
		}
		return answer;
	}
	
	public static String getDirection(Character now, Character after) {
		String returnStr = "";
		
		if(now == 'W') {
			if(after == 'S')
				returnStr = "left";
			else if(after =='N')
				returnStr = "right";
		}else if(now == 'S') {
			if(after == 'E')
				returnStr = "left";
			else if(after =='W')
				returnStr = "right";
		}else if(now == 'E') {
			if(after == 'N')
				returnStr = "left";
			else if(after =='S')
				returnStr = "right";
		}else if(now == 'N') {
			if(after == 'W')
				returnStr = "left";
			else if(after =='S')
				returnStr = "right";
		}
		return returnStr;
	}
	
	public static void main(String[] args) {
//		String path = "EEESEEEEEENNNN";
		String path = "SSSSSSWWWNNNNNN";
		
		for(String s : solution(path))
			System.out.println(s + " ");
	}
}
