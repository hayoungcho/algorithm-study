package programmers.challenges.level2;

import java.util.HashMap;


//소수 찾기
public class Challenge_42839 {
	
	static boolean[] ch;
	static int cnt = 0;
	
	public static int solution(String numbers) {
		ch = new boolean[numbers.length()];
		
		HashMap<Integer, Integer> checkMap = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < numbers.length(); i++)
			dfs(numbers, new StringBuilder(), i + 1, checkMap);
		
		return cnt;
	}
	
	public static void dfs(String numbers, StringBuilder tmp, int level, HashMap<Integer, Integer> checkMap){
		if(level == tmp.length()) {
			int toInt = Integer.parseInt(tmp.toString());
			if(!checkMap.containsKey(toInt) && checkPrime(toInt)) {
				cnt++;
				checkMap.put(toInt, 0);
			}
		}else {
			for(int i = 0; i < numbers.length(); i++) {
				if(!ch[i]) {
					ch[i] = true;
					dfs(numbers, tmp.append(numbers.charAt(i)), level, checkMap);
					ch[i] = false;
					tmp.deleteCharAt(tmp.length() - 1);
				}
			}
		}
	}
	
	//소수면 true, 아니면 false
	public static boolean checkPrime(int number) {
		if(number == 1 || number == 0)
			return false;
		
		for(int i = 2; i <= number / 2; i++) {
			if(number % i == 0)
				return false;
		}
		
		return true;
	}

	public static void main(String args[]) throws Exception {
		String numbers = "17";

		System.out.println(solution(numbers));
	}
}
