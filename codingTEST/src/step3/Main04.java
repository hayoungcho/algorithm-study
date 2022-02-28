package step3;

import java.util.HashMap;
import java.util.Scanner;

public class Main04 {

	public static int solution(String s, String t) {
		int ans = 0;
		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		for(char a : t.toCharArray()) {
			tMap.put(a, tMap.getOrDefault(a, 0) + 1);
		}
		int l = t.length() - 1;
		for(int i = 0; i < l; i++) {
			sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
		}
		int lt = 0;
		for(int rt = l; lt < s.length(); lt++) {
			sMap.put(s.charAt(rt), sMap.getOrDefault(s.charAt(rt), 0) + 1);
			
			if(sMap.equals(tMap))
				ans++;
			sMap.put(s.charAt(lt), sMap.get(s.charAt(lt)) - 1);
			if(sMap.get(s.charAt(lt)) == 0)
				sMap.remove(s.charAt(lt));
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
