package study.step3;

import java.util.HashMap;
import java.util.Scanner;

public class Main02 {

	public static String solution(String str1, String str2) {
		String ans = "YES";
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		for(char x : str1.toCharArray()) {
			map1.put(x, map1.getOrDefault(x, 0) + 1);
		}
		for(char x : str2.toCharArray()) {
			map2.put(x, map2.getOrDefault(x, 0) + 1);
		}
		
		for(char key : map1.keySet()) {
			if(map2.get(key) == null || map1.get(key) != map2.get(key)) {
				ans = "NO";
				break;
			}
			
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);


		String str1 = kb.next();
		String str2 = kb.next();
		
		System.out.println(solution(str1 , str2));
	}
}
