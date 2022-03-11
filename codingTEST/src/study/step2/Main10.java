package study.step2;

import java.util.Scanner;

public class Main10 {
	public static int solution(int[][] arr) {
		int cnt = 0;
		
		for(int i = 1; i < arr.length - 1; i++) {
			for(int j = 1; j < arr.length - 1; j++) {
				int citeraia = arr[i][j];
				if(citeraia > arr[i][j-1] && citeraia > arr[i][j+1] &&
						citeraia > arr[i-1][j] && citeraia > arr[i+1][j]) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int[][] inputArr = new int[n + 2][n + 2];
		
		for(int i = 0; i < n + 2; i++) {
			for(int j = 0; j < n + 2; j++) {
				if(!(i == 0 || i == n + 1 || j == 0 ||j == n + 1))
					inputArr[i][j] = kb.nextInt();
			}
		}
		
		System.out.println(solution(inputArr));
	}

}
