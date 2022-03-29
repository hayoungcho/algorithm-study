package programmers.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//전화번호목록
public class Hash02 {
	static public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> phoneMap = new HashMap<String, Integer>();
        
        for(int i = 0; i < phone_book.length; i++) 
        	phoneMap.put(phone_book[i], 0);
        
        for(int i = 0; i < phone_book.length; i++) {
        	for(int j = 0; j < phone_book[i].length(); j++) {
        		if(phoneMap.containsKey(phone_book[i].substring(0, j)))
    				return false;
        	}
        }
        return answer;
    }
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
//		String[] phone_book = {"119", "97674223", "1195524421"};
//		String[] phone_book = {"123","456","789"};
		String[] phone_book = {"12","123","1235","567","88"};
		System.out.println(solution(phone_book));
	}
	
}
