package step4;

import java.util.HashMap;
import java.util.Scanner;

public class Main04 {
	
	public static int solution(String s, String t) {
		int ans = 0;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		for(char a : t.toCharArray())
			map.put(a, map.getOrDefault(a, 0) + 1);
		
		for(int i = 0; i < t.length() - 1; i++)
			map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);
		
		int lt = 0;
		for(int rt = t.length() - 1; rt < s.length(); rt++){
			map2.put(s.charAt(rt), map2.getOrDefault(s.charAt(rt), 0) + 1);
			
			if(map.equals(map2))
				ans++;
			
			map2.put(s.charAt(lt), map2.get(s.charAt(lt)) - 1);

			if(map2.get(s.charAt(lt)) == 0) {
				map2.remove(s.charAt(lt));
			}
			lt++;
			
		}
			
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		String t = sc.next();
		
		System.out.println(solution(s, t));
	}
	
}
