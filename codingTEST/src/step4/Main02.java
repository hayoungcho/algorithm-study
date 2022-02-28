package step4;

import java.util.HashMap;
import java.util.Scanner;

public class Main02 {
	
	public static String solution2(String word1, String word2) {
		String ans = "YES";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();  
		for(char key : word1.toCharArray()) {
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		for(char key : word2.toCharArray()) {
			if(!map.containsKey(key) || map.get(key) == 0)
				return "NO";
			
			map.put(key, map.get(key) - 1);
		}
		return ans;
	}
	
	public static String solution(String word1, String word2) {
		String ans = "NO";
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();  
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();  
		for(char key : word1.toCharArray()) {
			map1.put(key, map1.getOrDefault(key, 0) + 1);
		}
		for(char key : word2.toCharArray()) {
			map2.put(key, map2.getOrDefault(key, 0) + 1);
		}
		
		for(char key : map1.keySet()) {
			if(map1.get(key).equals(map2.get(key)))
				ans = "YES";
			else
				ans = "NO";
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word1 = sc.next();
		String word2 = sc.next();
		
		System.out.println(solution(word1, word2));
	}
}
