package study.step10;

import java.util.Scanner;

//최대부분 증가수열
public class Main03 {
	static int dy[];
	public static int solution(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int max = 1;
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] > arr[i])
					max = Math.max(max, dy[i - j] + 1); 
			}
			dy[i] = max;
		}
		
		int max = Integer.MIN_VALUE;
		for(int x : dy) {
			if(max < x)
				max = x;
		}

		return max;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		dy = new int[n];
		for(int i = 0; i < n; i ++)
			arr[i] = sc.nextInt();
		
		dy[0] = 1;
		System.out.println(solution(arr));
	}
}
