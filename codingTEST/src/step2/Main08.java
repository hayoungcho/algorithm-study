package step2;

import java.util.Scanner;

public class Main08 {
	public static int[] solution(int[] arr) {
		int[] ans = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			int rnk = arr.length;
			for(int j = 0; j < arr.length; j++) {
				if(i != j && arr[i] >= arr[j])
					rnk--;
			}
			ans[i] = rnk;
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
		
		for(int x : solution(inputArr))
			System.out.println(x);
	}
}
