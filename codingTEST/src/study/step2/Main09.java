package study.step2;

import java.util.Scanner;

public class Main09 {
	public static int solution(int[][] arr) {
		int[][] cntSet = new int[2][arr.length];
		int r = 0;
		int l = 0;
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				cntSet[0][i] += arr[i][j];
				cntSet[1][i] += arr[j][i];
				
				if(i == j)
					r += arr[i][j];
				if(i + j == (arr.length - 1))
					l += arr[i][j];
			}
		}
		
		int max = r;
		if(max < l)
			max = l;
		for(int i = 0; i < arr.length; i++) {
			if(cntSet[0][i] > max)
				max = cntSet[0][i];
			if(cntSet[1][i] > max)
				max = cntSet[1][i];
		}
			
		return max;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int[][] inputArr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				inputArr[i][j] = kb.nextInt();
			}
		}
		
		System.out.println(solution(inputArr));
	}
	
}
