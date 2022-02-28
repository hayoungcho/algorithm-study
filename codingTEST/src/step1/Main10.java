package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main10 {
	public static int[] solution(String str, char s) {
		int[] answer = new int[str.length()];
		int p = 1000;
		for(int i = 0 ; i < str.length(); i++) {
			if(str.charAt(i) == s) {
				p = 0;
			}else {
				p++;
			}
			answer[i] = p;
		}

		p = 1000;
		for(int i = str.length() -1; i >= 0; i--) {
			if(str.charAt(i) == s ) {
				p = 0;
			}else {
				p++;
				answer[i] = Math.min(answer[i], p);
			}
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String test = kb.nextLine();
		char letter = kb.next().charAt(0);
		
		System.out.println(solution(test, letter));
	}
}
