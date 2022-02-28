package step1;

import java.util.ArrayList;
import java.util.Scanner;

//단어뒤집기
public class Main4 {
	public ArrayList<String> solution(String[] str) {
		ArrayList<String> answer = new ArrayList<String>();

//		for(String s : str) {
//		StriungBuilder : 문자열객체 일종 
//			String tmp = new StringBuilder(s).reverse().toString();
//			answer.add(tmp);
//		}
		for(String s : str) {
			char[] x = s.toCharArray();
			
			int lt = 0 ; 
			int rt = x.length - 1;
			
			while ( lt < rt) {
				char tmp = x[lt];
				x[lt] = x[rt];
				x[rt] = tmp; 
				lt++;
				rt--;
			}
			String tmp = String.valueOf(x);
			answer.add(tmp);
		}
		
//		for(int i = 0 ; i < str.length; i++) {
//			String ans = "";
//			for(int j = 0; j < str[i].toCharArray().length; j++) {
//				ans += c;
//				if(j str.length % 2)
//					break;
//			}
//		}
		
		return answer ;
	}
	public static void main(String[] args) {
		Main4 T = new Main4();
		
		Scanner kb = new Scanner(System.in);
		int num = kb.nextInt();
		String [] str = new String[num];
		for(int i = 0 ; i < num; i++) {
			str[i] = kb.next();
		}
		
		for(String s : T.solution(str)) {
			System.out.println(s);
		}
	}
}
