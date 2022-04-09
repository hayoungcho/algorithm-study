package programmers.codingTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test0409_2 {
	public static String solution(String call) {
		String answer = call;
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		String tmp = "";
		for(int lt = 0; lt < call.length(); lt++){
			for(int rt = 0; rt <= lt; rt++) {
				tmp = call.substring(rt, lt + 1);
				
				map.put(tmp, map.getOrDefault(tmp, 0) + 1);
				
			}
		}
		int max = Integer.MIN_VALUE;
		int maxLength = Integer.MIN_VALUE;
		List<String> removeStr = new ArrayList<String>();
		for(String key : map.keySet()){
			if(max <= map.get(key) && maxLength <= key.length()) {
				if(max < map.get(key))
					removeStr.clear();
				
				max = map.get(key);
				maxLength = key.length();
				removeStr.add(key);
			}
		}
		for(String s : removeStr)
			answer = answer.replaceAll(s, "");
		
		return answer;
	}
	
	public static void main(String args[]) {
		String call = "abxdeydeabz";
		System.out.println(solution(call));
	}
}
