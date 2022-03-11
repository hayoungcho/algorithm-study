package study.step4;

import java.util.HashMap;
import java.util.Scanner;

public class Main01 {
	
	public static char solution(String txt) {
		char ans = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(char a : txt.toCharArray()) {
			map.put(a, map.getOrDefault(a, 0) + 1);
		}
		
		int max = Integer.MIN_VALUE;
		for(char key : map.keySet()) {
			int tmp = map.get(key);
			if(tmp > max) {
				max = tmp;
				ans = key;
			}
		}
		
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int cnt = kb.nextInt();
		
		String txt = kb.next();
		
		System.out.println(solution(txt));
		
	}
}
