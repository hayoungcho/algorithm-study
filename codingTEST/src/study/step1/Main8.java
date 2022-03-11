package study.step1;

import java.util.Scanner;

//알파벳만 회문검사
//이외의 문자 제거 ? 
public class Main8 {
	public static String solution(String str) {
		String returnStr = "NO";
		//A-Z가 아니면 ~ ^A-Z
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		
		String tmp = new StringBuffer(str).reverse().toString();
		
		if(str.equals(tmp))
			returnStr = "YES";
				
		return returnStr;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String test = kb.nextLine();
		
		System.out.println(solution(test));
	}

}
