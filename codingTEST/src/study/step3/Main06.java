package step3;

import java.util.Scanner;

public class Main06 {

	/*
	 * 최대 길이 연속 부분 수열
	 * 주어진 수열에서 0->1 k번 변경하여
	 * 1로 이루어진 최대 길이 수열 만들기
	 */
	public static int solution(int[] seq, int k) {
		int ans = 0;
		int lt = 0;
		int change = 0;
		for(int rt = 0; rt < seq.length; rt++) {
			if(seq[rt] == 0)
				change++;
			
			if(change > k) {
				change--;
				
				while(seq[lt++] == 0)
					lt++;
				
				ans = Math.max(rt - lt + 1, ans);
			}
			
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int k = kb.nextInt();
		
		int[] seq = new int[n];
		for(int i = 0; i < n; i++)
			seq[i] = kb.nextInt();
		
		
		
		System.out.print(solution(seq, k));
	}
}
