package programmers.challenges.level1;

//없는숫자더하기
public class Challenge_86051 {

	public static int solution(int[] numbers) {
        int answer = 0;
        int[] ch = new int[10];
        
        for(int i = 1; i <= 9; i++)
        	answer += i;
        
        for(int i = 0; i < numbers.length; i++) {
        	if(ch[i] == 0) {
        		answer -= numbers[i];
        		ch[i] = 1;
        	}
        }
        	
        return answer;
    }
	
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,6,7,8,0};
		
		System.out.println(solution(numbers));
	}
}
