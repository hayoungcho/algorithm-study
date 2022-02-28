package step1;

import java.util.Scanner;

public class Main11 {

	public static String solution(String str) {
		String answer = "";
		char tmp = str.charAt(0);
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == tmp) {
				cnt++;
			}else {
				answer += tmp;
				if(cnt > 1)
					answer += String.valueOf(cnt);
				tmp = str.charAt(i);
				cnt = 1;
			}
			if(i == str.length() - 1) {
				answer += tmp;
				if(cnt > 1)
					answer += String.valueOf(cnt);
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String test = kb.nextLine();
		
		System.out.println(solution(test));
	}
}
