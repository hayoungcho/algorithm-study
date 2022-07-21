package programmers.challenges.level1;

//숫자 문자열과 영단어
public class Challenge_81301 {

	public static int solution(String s) {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] numberStrs = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < numberStrs.length; i++) {
        	if(s.contains(numberStrs[i])) {
        		s = s.replaceAll(numberStrs[i], String.valueOf(numbers[i]));
        	}
        }
        
        return Integer.parseInt(s);
    }
	
	public static void main(String args[]) throws Exception {
		String p = "one4seveneight";
		
		System.out.println(solution(p));
		
	}
}
