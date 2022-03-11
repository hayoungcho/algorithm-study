package study.step3;

import java.util.HashMap;
import java.util.Scanner;

public class Main01 {

	public static char solution(int n, String s) {
		char ans = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}
		
		int max = Integer.MIN_VALUE;
		for(char key : map.keySet()) {
			if(map.get(key) > max)
				max = map.get(key);
				ans = key;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();

		String str = kb.next();
		
		System.out.println(solution(n , str));
	}
}
