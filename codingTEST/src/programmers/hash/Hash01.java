package programmers.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//완주하지 못한 선수
public class Hash01 {
	static public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> hash = new HashMap<>();
        
        for (String arg : participant) 
            hash.put(arg, hash.getOrDefault(arg, 0) + 1);
        
        for (String arg : completion) 
            hash.put(arg, hash.get(arg) - 1);
 
        for (String key : hash.keySet()) {
            if (hash.get(key) != 0) 
            	answer = key;
        }
 
        return answer;
    }
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
//		String[] participant = {"leo", "kiki", "eden"};
//		String[] completion = {"eden", "kiki"};
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		System.out.println(solution(participant, completion));
	}
}
