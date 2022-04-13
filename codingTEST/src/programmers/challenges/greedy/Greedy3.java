package programmers.challenges.greedy;

//큰 수 만들기
public class Greedy3 {
	public static String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int lt = 0;
        for(int i = 0; i < number.length() - k; i++) {
        	int max = 0;
        	for(int j = lt; j <= i + k; j++) {
        		if(max < number.charAt(j) - '0') {
        			max = number.charAt(j) - '0';
        			lt = j + 1;
        		}
        	}
        	sb.append(max);
        	
        }
        answer = sb.toString();
        return answer;
    }
	
	public static void main(String[] args) {
		String number = "1231234";
		int k = 3;
		
		System.out.println(solution(number, k));
	}
}
