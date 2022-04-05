package programmers.challenges.sort;

import java.util.Arrays;
import java.util.Comparator;

//가장 큰 수
public class Sort2{
	public static String solution(int[] numbers) {
        String answer = "";
        String[] strArr = new String[numbers.length]; 
        for(int i = 0; i < numbers.length; i++)
        	strArr[i] = Integer.toString(numbers[i]);
        
        //내림차순
        Arrays.sort(strArr, new Comparator<String>(){
        	@Override
        	public int compare(String o1, String o2) {
        		// TODO Auto-generated method stub
        		return (o2 + o1).compareTo(o1 + o2);
        	}
        });
        
//        if(strArr[0] == "0")
        if(strArr[0].equals("0"))
        	answer = "0";
        else
        	answer = String.join("", strArr);
        
        return answer;
    }
	
	public static void main(String[] args) {
//		int[] numbers = {6, 10, 2};
		int[] numbers = {104, 1};
		
		System.out.println(solution(numbers));
	}

	
}
