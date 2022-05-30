package programmers.challenges.level2;

import java.util.Stack;

//짝지어 제거하기
public class Challenge_12973 {
	public static int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<Character>();
        stack.add(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            
            if(stack.peek() == s.charAt(i))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        if (stack.size() == 0) 
        	answer = 1;

        //효율성 실패
//        ArrayList<Character> array = new ArrayList<Character>();
//        for(Character c : s.toCharArray())
//        	array.add(c);
//        
//        while(true) {
//        	boolean flag = true;
//        	for(int i = 0; i < array.size() - 1; i++) {
//        		if(array.get(i) == array.get(i + 1)) {
//        			array.remove(i + 1);
//        			array.remove(i);
//        			flag = false;
//        		}
//        	}
//        	if(flag)
//        		answer = 0;
//        	
//        	if(flag || array.size() == 0)
//        		break;
//        }
        return answer;
    }
    
	
	public static void main(String[] args) {
//		String s = "baabaa";
		String s = "cdcd";
		System.out.println(solution(s));
	}
}
