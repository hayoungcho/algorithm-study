package step1;

import java.util.Scanner;

public class Main3 {
	public String solution(String str) {
		String answer = "";
		int m = Integer.MIN_VALUE, pos;
		
		while((pos = str.indexOf("")) != -1) {
			String tmp = str.substring(0, pos);
			int len = tmp.length();
			if(len > m) {
				m = len;
				answer = tmp;
			}
			str = str.substring(pos + 1);
		}
		
//		String[] s = str.split(" ");
//		for(int i = 0 ; i< s.length; i ++) {
//			int len = s[i].length();
//			if(len > m) {
//				m = len;
//				answer = s[i];
//			}
//		}
		
		
			
		return answer ;
	}
	public static void main(String[] args) {
		Main3 T = new Main3();
		
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		
		System.out.println(T.solution(str));
	}
}
