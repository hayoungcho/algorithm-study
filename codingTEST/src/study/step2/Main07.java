package study.step2;

import java.util.Scanner;

public class Main07 {
	public static int solution(int[] arr) {
		int ans = 0;
		int bonus = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 1) {
				ans++;
				ans += bonus;
				bonus += 1;
			}else {
				bonus = 0;
			}
			
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int[] inputArr = new int[n];
		for(int i = 0; i < n; i++) {
			inputArr[i] = kb.nextInt();
		}
		
		System.out.println(solution(inputArr));
	}
}
