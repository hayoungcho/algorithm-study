package programmers.challenges.greedy;

import java.util.Arrays;

//체육복
public class Greedy1 {
	public static int solution(int n, int[] lost, int[] reserve) {
		//answer초기화 - 수업을 들을 수 있는 초기 학생 수
		int answer = n - lost.length;

		//작은 학생부터 정렬
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		//여별체육복 학생 = 잃어버린 학생의 경우
		for(int i = 0; i < lost.length; i++) {
			for(int j = 0; j < reserve.length; j++) {
				if(lost[i] == reserve[j]) {
					lost[i] = -1;
					reserve[j] = -1;
					answer++;
					break;
				}
			}
		}
		
		for(int i = 0; i < lost.length; i++) {
			for(int j = 0; j < reserve.length; j++) {
				if(Math.abs(lost[i] - reserve[j]) == 1) {
					answer++;
					//빌려줄 수 없음
					reserve[j] = -1;
					break;
				}
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {3};
		
		System.out.println(solution(n, lost, reserve));
	}
}
