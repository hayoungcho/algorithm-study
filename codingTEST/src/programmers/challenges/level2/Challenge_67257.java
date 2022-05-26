package programmers.challenges.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Challenge_67257 {
	static String[] operator = {"*", "+", "-"};
	static Queue<String> expressQue = new LinkedList<String>();
	public static long solution(String expression) {
        long answer = 0;
        
        ArrayList<String> expressArr = new ArrayList<String>();
        StringBuilder number = new StringBuilder();
        for(Character c : expression.toCharArray()) {
        	if(Character.isDigit(c))
        		number.append(c);
        	else {
        		expressArr.add(number.toString());
        		expressArr.add(c.toString());
        		number = new StringBuilder();
        	}
        }
        
        for(String s : expressArr)
        	expressQue.add(s);
        
        getCombi(0, new String[3], new int[3], 0, new long[6]); 
        
        return answer;
    }
	
	public static void getCombi(int level, String[] combi, int[] ch, int cnt, long[] answer) {
		if(level == operator.length)
			answer[cnt++] = calcuation(combi);
		else {
			for(int i = 0; i < operator.length; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					combi[level++] = operator[i];
					getCombi(level, combi, ch, cnt++, answer);
					level--;
					ch[i] = 0;
				}
			}
		}
	}
	
	public static long calcuation(String[] combi) {
		long answer = 0;
		
		long num1 = 0;
		long num2 = 0;
		String oper = "";
		for(int i = 0; i < operator.length; i++) {
			while(expressQue.contains(operator[0])) {
				String str = expressQue.poll();
				if(str.length() == 1) {
					num2 = Integer.parseInt(expressQue.poll());
					answer = calculateByOpt(num1, num2, str);
					expressQue.add(String.valueOf(answer)); 
				}else {
					num1 = Integer.parseInt(str);
				}
			}
		}
		return answer;
	}
	
	public static long calculateByOpt(long num1, long num2, String oper) {
		long answer = 0;
		
		if(oper == operator[0])
			answer = num1 * num2;
		if(oper == operator[1])
			answer = num1 + num2;
		if(oper == operator[0])
			answer = num1 - num2;
		
		return answer;
	}
	
	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		
		System.out.println(solution(expression));
	}
}
