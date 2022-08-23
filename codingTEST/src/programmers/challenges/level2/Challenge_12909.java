package programmers.challenges.level2;

import java.util.Stack;

//¿Ã¹Ù¸¥ °ýÈ£
public class Challenge_12909 {

	public static boolean solution(String s) {
		boolean answer = true;
		Stack<Character> stack = new Stack<Character>();
		
		for(Character c : s.toCharArray()) {
			if(c == '(')
				stack.push(c);
			else {
				if(stack.isEmpty())
					return false;
				else
					stack.pop();
			}
		}
		
		if(!stack.isEmpty())
			return false;
		
		return answer;
	}

	public static void main(String args[]) throws Exception {
//		String s = "()()";
		String s = "(()(";

		System.out.println(solution(s));
	}
}
