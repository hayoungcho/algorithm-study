package study.step1;

import java.util.Scanner;

public class Main9 {
	
	public static int solution(String test) {
		int returnInt= 0;
		String tmp = "";
		for(int i = 0; i < test.length(); i++) {
//			if(!Character.isAlphabetic(test.charAt(i))) {
//				tmp += test.charAt(i);
//			}
			
			if(test.charAt(i) >= 48 && test.charAt(i) <= 57) {
				tmp += test.charAt(i);
			}
		}
		returnInt = Integer.parseInt(tmp);
		return returnInt;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String test = kb.nextLine();
		
		System.out.println(solution(test));
	}

	
}
