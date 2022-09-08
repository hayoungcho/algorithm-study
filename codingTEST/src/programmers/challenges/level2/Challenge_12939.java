package programmers.challenges.level2;

import java.util.Arrays;

//�ִ񰪰� �ּڰ�
public class Challenge_12939 {

	//java11���� String class�� isBlank() �߰���
	//isBlank()�� 6�� �߰�
	
	public static String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int[] values = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        
        for(int i : values) {
        	if(i > max)
        		max = i;
        	if(i < min)
        		min = i;
        }
        
        return  min + " " + max;
    }
	
	public static void main(String args[]) throws Exception {
//		String s = "1 2 3 4";
//		String s = "-1 -2 -3 -4";
		String s = "-1 -1";

		System.out.println(solution(s));
	}
}
