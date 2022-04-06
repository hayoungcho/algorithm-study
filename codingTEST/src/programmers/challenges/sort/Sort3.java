package programmers.challenges.sort;

import java.util.Arrays;

//h-index
public class Sort3 {

	public static int solution(int[] citations) {
		int answer = 0;
		//오름차순
		Arrays.sort(citations);
		
		for(int i = 0; i < citations.length; i++) {
			//i라고 할 때 가장 큰 h 값
			int h = citations.length - i;
			
			if(citations[i] >= h) {
				answer = h;
				break;
			}
		}
        return answer;
    }
	 
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		 
		System.out.println(solution(citations));
	 }
}
