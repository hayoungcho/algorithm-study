package study.step1;

import java.util.Scanner;

public class Main6 {
	public static String solution(String str) {
		String returnStr = "";
		for(int i = 0; i < str.length(); i++) {
//			System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
			
			if(i != str.indexOf(str.charAt(i)))
				returnStr += str.charAt(i);
			
		}
		return returnStr;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String test = kb.nextLine();
		
		System.out.println(solution(test));
	}
}
