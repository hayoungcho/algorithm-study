package programmers.date20220320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main05 {
	static ArrayList<Character> open = new ArrayList<>(Arrays.asList('(', '{', '['));
	static ArrayList<Character> close = new ArrayList<>(Arrays.asList(')', '}', ']'));
	
	 public static int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
        	Character c = s.charAt(i);
        	if(open.contains(c))
        		stack.push(c);
        	else {
        		int tmp = stack.peek();
        		//½ÖÀÌ ¸Â´Â °ýÈ£¸é
        		if(close.indexOf(c) == open.indexOf(stack.peek()))
        			stack.pop();
        		else {
        			for(int j = 0; j <= s.length(); j++) {
        				//´Ý´Â°ýÈ£ ºÎÁ·ÇÒ °æ¿ì
        				if(stack.contains(open.get(close.indexOf(c)))) {
        					if(getCheck(s, j, close.get(open.indexOf(stack.peek()))))
        						answer++;
        				}else {
        					if(getCheck(s, j, open.get(close.indexOf(c))))
        						answer++;
        				}
        			}
        			return answer;
        		}
        	}
        }
        if(!stack.isEmpty()) {
        	for(int j = 0; j <= s.length(); j++) {
        		Character tmp = stack.peek();
        		if(close.contains(tmp)) {
        			if(getCheck(s, j, open.get(close.indexOf(tmp))))
						answer++;
        		}else {
        			if(getCheck(s, j, close.get(open.indexOf(tmp))))
        			answer++;
        		}
        	}
        }
        return answer;
    }
	 
	 public static boolean getCheck(String s, int idx, Character c) {
		 boolean ans = true;
			Stack<Character> stack = new Stack<Character>();
			
			String tmp1 = s.substring(0, idx);
			String tmp2 = s.substring(idx, s.length());
			String tmp = tmp1 + c + tmp2;
			
			for(int i = 0; i < tmp.length(); i++) {
				Character a = tmp.charAt(i);
				
				if(a == '[' || a == '(' || a == '{')
					stack.push(a);
				else {
					if(stack.isEmpty())
						return false;
					//½ÖÀÌ ¸Â´Â °ýÈ£¸é
	        		if(close.indexOf(a) == open.indexOf(stack.peek()))
	        			stack.pop();
	        		else
	        			return false;
				}
			}
			
			if(!stack.isEmpty())
				ans = false;
			
			return ans;
	 }
	 
	 public static void main(String[] args) {
		 String s = "[]([[]){}";
//		 String s = "{([()]))}";
//		 String s = "(()()()";
		 
		 System.out.println(solution(s));
		 
	 }
}
