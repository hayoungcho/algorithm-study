package step5;

import java.util.Scanner;
import java.util.Stack;

public class Main01 {

	//stack ±âº» 
	//push(), pop(), isEmpty()
	public static String solution(String str) {
		String ans = "YES";
		Stack<Character> stack = new Stack<Character>();
		
		for(char a : str.toCharArray()) {
			if(a == '(')
				stack.push(a);
			else {
				if(stack.isEmpty())
					return "NO";
				
				stack.pop();
			}
		}
		
		if(!stack.isEmpty())
			ans = "NO";
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		System.out.println(solution(str));
	}
	
}
