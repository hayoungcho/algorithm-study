package step5;

import java.util.Scanner;
import java.util.Stack;

public class Main02 {

	public static String solution(String str) {
		String ans = "";
		
		Stack<Character> stack = new Stack<Character>();
		for(char a : str.toCharArray()) {
			if(a == '(')
				stack.push(a);
			else if(a == ')')
					stack.pop();
			else {
				if(stack.isEmpty())
					ans += a;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		System.out.println(solution(str));
	}
	
}
