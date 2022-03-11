package study.step5;

import java.util.Scanner;
import java.util.Stack;

public class Main04 {
	
	//후위식연산(postfix)
	public static int solution(String arg) {
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		
		//ascii code 
		// 0 : 48, 1 : 49 ... 
		for(char a : arg.toCharArray()) {
			if(Character.isDigit(a))
				stack.push(a - 48);
			else {
				int rt = stack.pop();
				int lt = stack.pop();
				
				if(a == '+')
					stack.push(rt + lt);
				else if(a == '-')
					stack.push(lt - rt);
				else if(a == '*')
					stack.push(lt * rt);
				else if(a == '/')
					stack.push(lt / rt);
			}
		}
		
		ans = stack.get(0);
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String arg = sc.next();
		System.out.println(solution(arg));
	}

}
