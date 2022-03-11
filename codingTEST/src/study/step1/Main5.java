package study.step1;

import java.util.Scanner;

public class Main5 {
	
	public String solution(String str) {
		String returnStr = "";
		char[] s = str.toCharArray();
		int lt = 0;
		int rt = str.length() - 1;
		
	
		while ( lt < rt) {
			if(!Character.isAlphabetic(s[lt]))
				lt++;
			else if(!Character.isAlphabetic(s[rt]))
				rt--;
			else {
				char tmp = s[lt];
				s[lt] = s[rt];
				s[rt] = tmp; 
				lt++;
				rt--;
			}
		}
		returnStr = String.valueOf(s);
		return returnStr; 
	}
	
	public static void main(String[] args) {
		Main5 T = new Main5();
		
		Scanner kb = new Scanner(System.in);
		String test = kb.nextLine();
		
		System.out.println(T.solution(test));
	}

}
