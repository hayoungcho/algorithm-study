package step6;

import java.util.Arrays;
import java.util.Scanner;

public class Main08 {
	
	//뮤직비디오(결정알고리즘)
	
	//capacity : 저장 용량
	public static int count(int[] arr, int capacity) {
		//DVD 개수 
		int cnt = 0;
		int sum = 0;
		
		for(int x : arr) {
			if(sum + x > capacity) {
				cnt++;
				sum = x;
			}else
				sum += x;
		}
		
		return cnt;
	}
	
	public static int solution(int[] arr, int m) {
		int ans = 0;
		
		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();
		
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			
			if(count(arr, mid) <= m) {
				ans = mid;
				rt = mid - 1;
			}else {
				lt = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		System.out.println(solution(arr, m));
		
	}
}
