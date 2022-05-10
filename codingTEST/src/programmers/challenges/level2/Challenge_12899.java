package programmers.challenges.level2;

//124나라의 숫자 
public class Challenge_12899 {

	public static String solution(int n) {
		int nums[] = new int[]{4, 1, 2}; 
        String answer = "";
        
        while(n > 0){
        	//나머지
            int remainder = n % 3;
            n = n / 3;
            
            if(remainder == 0)
            	n--;
            
            answer = nums[remainder] + answer;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 4;
		
		System.out.println(solution(n));
	}
}
