package step2;

import java.util.Scanner;

public class Main11 {

	public static int solution(int[][] arr) {
		int ans = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i = 1; i < arr.length; i++) {
			int cnt = 0;
			for(int j = 1; j <= arr.length; j++) {
				for(int k = 1; k <= 5; k++) {
					if(arr[i][k] == arr[j][k]) {
						cnt ++;
						break;
					}
				}
			}
			if(cnt > max) {
				max = cnt;
				ans = i;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int[][] inputArr = new int[n+1][6];
		
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j <= 5; j++) {
				inputArr[i][j] = kb.nextInt();
			}
		}
		
		System.out.println(solution(inputArr));
	}
}
