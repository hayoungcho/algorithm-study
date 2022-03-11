package study.step1;

import java.util.Scanner;

public class Main2 {
	public String solution(String str) {
		String answer = "";
		
//		for(char a : str.toCharArray()) {
//			if(Character.isLowerCase(a)) {
//				answer += Character.toUpperCase(a);
//			}else
//				answer += Character.toLowerCase(a);
//		}
		
		for(char a : str.toCharArray()) {
			if(a >= 65 && a <= 90) {
				answer +=(char) (a-32);
			}else
				answer += (char)(a+32);
		}
			
		return answer ;
	}
	public static void main(String[] args) {
		Main2 T = new Main2();
		
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		
		System.out.println(T.solution(str));
	}
}
