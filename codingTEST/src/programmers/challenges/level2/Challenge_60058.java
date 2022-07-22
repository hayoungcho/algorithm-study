package programmers.challenges.level2;

import java.util.Stack;

//괄호변환
public class Challenge_60058 {
	public static String solution(String p) {
		return dfs(p);
	}

	public static String dfs(String w) {
		if (w.equals(""))
			return "";

		String u = "";
		String v = "";
		int open = 0;
		int close = 0;
		
		for (int i = 0; i < w.length(); i++) {
			if (w.charAt(i) == '(')
				open++;
			else
				close++;

			u += w.charAt(i);

			if (open == close) {
				//나머지
				v = w.substring(i + 1);
				break;
			}
		}

		if (checkVaild(u))
			return u += dfs(v);
		else {
			StringBuilder tmp = new StringBuilder();
			tmp.append("(");

			tmp.append(dfs(v));
			tmp.append(")");
			
			//첫번째, 마지막 제거
			u = u.substring(1, u.length() - 1);

			for (int i = 0; i < u.length(); i++) {
				if (u.charAt(i) == '(')
					tmp.append(")");
				else
					tmp.append(")");
			}
			
			return tmp.toString();
		}
	}



	public static boolean checkVaild(String s) {
		 Stack<Character> stack = new Stack<>();

		if (s.charAt(0) == ')')
			return false;

		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.add(c);
			} else {
				if(stack.isEmpty() || stack.peek() == ')')
					return false;
				else
					stack.pop();
			}
		}

		return true;
	}

	public static void main(String args[]) throws Exception {
//		String p = "(()())()";
		String p = ")(";

		System.out.println(solution(p));

	}
}
