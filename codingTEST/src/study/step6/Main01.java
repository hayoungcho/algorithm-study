package study.step6;

import java.util.Scanner;

public class Main01 {
	//selection sort
	public static int[] solution2(int[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			int idx = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[idx])
					idx = j;
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		return arr;
	}
	public static int[] solution(int[] arr) {
		int[] ans = new int[arr.length];
		
		//min ºÒÇÊ¿ä?
		for(int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int idx = i;
			
			for(int j = i + 1; j < arr.length; j++) {
				if(min > arr[j]) {
					min = arr[j];
					idx = j;
				}
			}
			
			if(idx != i) {
				arr[idx] = arr[i];
				arr[i] = min;
			}
			
		}
		ans = arr;
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) 
			arr[i] = sc.nextInt();
		
		for(int x : solution(arr))
			System.out.print(x + " ");
	}
}
