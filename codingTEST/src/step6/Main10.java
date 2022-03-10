package step6;

import java.util.Arrays;
import java.util.Scanner;

public class Main10 {
	
	public static int count(int[] arr, int distance) {
		int cnt = 1;
		int ep = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] - ep >= distance) {
				cnt++;
				ep = arr[i];
			}
		}
		
		return cnt;
	}
	public static int solution(int[] arr, int c) {
		int ans = 0;
		Arrays.sort(arr);
		
		int lt = 1; 
		int rt = arr[arr.length - 1];
		
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			if(count(arr, mid) >= c) {
				lt = mid + 1;
				ans = mid;
			}else
				rt = mid - 1;
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) 
			arr[i] = sc.nextInt();
		
		System.out.println(solution(arr, c));
	}
}
