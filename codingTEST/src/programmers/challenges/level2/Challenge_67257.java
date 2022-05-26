package programmers.challenges.level2;

import java.util.ArrayList;
import java.util.Arrays;

//수식 최대화
public class Challenge_67257 {
	//자료형 확인, Remove시 index확인
	static ArrayList<String> operator = new ArrayList<String>(Arrays.asList("*", "+", "-"));
	static ArrayList<String> expressArr = new ArrayList<String>();
	static long answer = Long.MIN_VALUE;
	
	public static long solution(String expression) {
        StringBuilder number = new StringBuilder();
        for(Character c : expression.toCharArray()) {
        	if(Character.isDigit(c))
        		number.append(c);
        	else {
        		expressArr.add(number.toString());
        		expressArr.add(c.toString());
        		number.delete(0, number.length());
        	}
        }
    	expressArr.add(number.toString());
        
        for(int i = 0; i < operator.size(); i++) {
        	if(!expressArr.contains(operator.get(i)))
        		operator.remove(i--);
        }
        
        getCombi(0, new String[operator.size()], new int[operator.size()], 0); 
        
        return answer;
    }
	
	public static void getCombi(int level, String[] combi, int[] ch, int cnt) {
		if(level == operator.size())
			answer = Math.max(calcuation(combi), answer);
		else {
			for(int i = 0; i < operator.size(); i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					combi[level++] = operator.get(i);
					getCombi(level, combi, ch, cnt++);
					level--;
					ch[i] = 0;
				}
			}
		}
	}
	
	public static long calcuation(String[] combi) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.addAll(expressArr);
		for(int i = 0; i < combi.length; i++) {
			while(arr.contains(combi[i])) {
				for(int j = 0; j < arr.size(); j++) {
					if(arr.get(j).equals(combi[i])) {
						String ans = calculateByOpt(arr.get(j - 1), arr.get(j + 1), arr.get(j));
						arr.remove(j + 1);
						arr.remove(j);
						arr.remove(j - 1);
						arr.add(j - 1, String.valueOf(ans));
						j -= 2;
					}
				}
			}
		}
		return Math.abs(Long.parseLong((arr.get(0))));
	}
	
	public static String calculateByOpt(String n1, String n2, String oper) {
		long answer = 0;
		long num1 = Long.parseLong(n1);
		long num2 = Long.parseLong(n2);
		
		if(oper.equals("*"))
			answer = num1 * num2;
		if(oper.equals("+"))
			answer = num1 + num2;
		if(oper.equals("-"))
			answer = num1 - num2;
		
		return String.valueOf(answer);
	}
	
	public static void main(String[] args) {
//		String expression = "100-200*300-500+20";
		String expression = "177-661*999*99-133+221+334+555-166-144-551-166*166-166*166-133*88*55-11*4+55*888*454*12+11-66+444*99";
		
		System.out.println(solution(expression));
	}
}
