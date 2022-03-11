package study.step6;

import java.util.Arrays;
import java.util.Scanner;

public class Main09 {

	//이분검색, 이분 알고리즘 (Binary Algorithm)
	public static int solution(int[] arr, int m) {
		int ans = 0; 
		int lt = 0; 
		int rt = arr.length - 1; 
		
		Arrays.sort(arr);

		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			
			if(arr[mid] == m) {
				ans = mid + 1;
				break;
			}else if(arr[mid] > m)
				rt = mid - 1;
			else
				lt = mid + 1;
		}
			
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr= new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		System.out.println(solution(arr, m));
	}
	
}
