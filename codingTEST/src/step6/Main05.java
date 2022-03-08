package step6;

import java.util.Arrays;
import java.util.Scanner;

public class Main05 {
	//중복확인
	public static String solution(int[] arr) {
		String ans = "U";
		
		//오름차순 정렬 
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] == arr[ i+ 1 ])
				return "D";
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		System.out.println(solution(arr));
	}
}
