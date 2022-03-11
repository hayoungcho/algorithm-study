package study.step6;

import java.util.Scanner;

class Main03 {

	//Insertion sort
	public static int[] solution(int[] arr) {
		// target
		for(int i = 1; i < arr.length; i++) {
			for(int j = i; j > 0; j--) {
				if(arr[j - 1] > arr[j]) {
					int tmp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = tmp;
				}else
					break;
			}
		}
		return arr;
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
