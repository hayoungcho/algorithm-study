package programmers.challenges.level1;

//음양더하기
public class Challenge_76501 {
	 public static int solution(int[] absolutes, boolean[] signs) {
	        int answer = 0;
	        
	        for(int i = 0; i < absolutes.length; i++) {
	        	if(signs[i])
	        		answer += absolutes[i];
	        	else
	        		answer -= absolutes[i];
	        	
//	        	answer += absolutes[i] * (signs[i]? 1 : -1);
	        }
	        
	        return answer;
    }
	 
	 public static void main(String[] args) {
		 int[] absolutes = {4,7,12};
		 boolean[] signs = {true,false,true};
		 
		 System.out.println(solution(absolutes, signs));
	 }
}
