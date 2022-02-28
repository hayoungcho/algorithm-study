package step2;

import java.util.Scanner;

public class Main12 {
	public static int solution(int[][] arr) {
		int cnt = 0;
	      int tetCnt = arr.length;
	      int left = 0;
	      int right = 0;
	      for(int i = 0; i < arr[0].length; i++) {
	         for(int j = i + 1; j < arr[0].length; j++) {
	            for(int k = 0; k < tetCnt; k++) {
	               if(arr[k][i] > arr[k][j]) 
	                  left++;

	               if(arr[k][i] < arr[k][j])
	                  right++;
	            }
	            if(left == tetCnt || right == tetCnt)
	               cnt++;
	            left = 0;
	            right = 0;
	         }
	      }
	      return cnt;

	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int m = kb.nextInt();
		int[][] inputArr = new int[m][n];
		
		for(int i = 0; i < m ; i++) {
			for(int j = 0; j < n; j++) {
				inputArr[i][j] = kb.nextInt();
			}
		}
		
		System.out.println(solution(inputArr));
	}
	
}
