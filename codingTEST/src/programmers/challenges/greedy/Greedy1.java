package programmers.challenges.greedy;

import java.util.Arrays;

//ü����
public class Greedy1 {
	public static int solution(int n, int[] lost, int[] reserve) {
		//answer�ʱ�ȭ - ������ ���� �� �ִ� �ʱ� �л� ��
		int answer = n - lost.length;

		//���� �л����� ����
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		//����ü���� �л� = �Ҿ���� �л��� ���
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
					//������ �� ����
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
