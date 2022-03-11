package study.step5;

import java.util.Scanner;
import java.util.Stack;

public class Main05 {

	public static int solution(String arg) {
		int ans = 0;
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < arg.length(); i++) {
			if(arg.charAt(i) == '(')
				stack.push(arg.charAt(i));
			else {
				if(arg.charAt(i-1) == '(') {
					ans += stack.size();
				}else {
					ans += 1;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String arg = sc.next();
		System.out.println(solution(arg));
	}

}
