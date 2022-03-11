package study.step1;

import java.util.Scanner;

public class Main12 {

	public static String count(String str) {
		String ans = "";
		int num = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '#') {
//				System.out.println(">" + Math.pow(2, i) + ">" + i);
				num += (int)Math.pow(2, 6 - i);
			}
		}
		ans = Character.toString((char)num);
//		System.out.println(ans);
		
		return ans;
	}
	public static String solution(String str) {
		String returnStr = "";
		String[] arr = new String[str.length()/7];
		String tmp = ""; 
		int idx= 0;
		for(int i = 0; i < str.length(); i++) {
			tmp += str.charAt(i);
			if(i % 7 == 6) {
				arr[idx] = tmp;
				idx++;
				tmp = "";
			}
		}
		for(String s : arr)
			returnStr += count(s);
		return returnStr;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String test = kb.nextLine();
		System.out.println(solution(test));
	}
}

//#****###**#####**#####**##** 
