package study.step5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main07 {

	public static String solution(String essential, String allSub) {
		String ans = "YES";
		
		Queue<Character> que = new LinkedList<Character>();
		
		for(char a : allSub.toCharArray())
			que.offer(a);
		
		for(char a : essential.toCharArray()){
			if(que.contains(a))
				while(que.poll() != a);
			else
				return "NO";
		}
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String essential = sc.next();
		String allSub = sc.next();
		
		System.out.println(solution(essential, allSub));
	}
}
