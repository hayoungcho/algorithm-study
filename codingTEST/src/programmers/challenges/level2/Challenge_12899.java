package programmers.challenges.level2;

//124������ ���� 
public class Challenge_12899 {

	public static String solution(int n) {
		//int array�� ��� ȿ�������� ��� �� ��.
//		int nums[] = new int[]{4, 1, 2};
		
		String[] nums = {"4", "1", "2"};
        String answer = "";
        
        while(n > 0){
            answer = nums[n % 3] + answer;
            n = (n - 1) / 3;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 4;
		
		System.out.println(solution(n));
	}
}
