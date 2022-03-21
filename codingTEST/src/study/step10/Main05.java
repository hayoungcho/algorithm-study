package study.step10;

import java.util.Arrays;
import java.util.Scanner;

//동적  프로그래밍 동전교환(냅색 알고리즘)
public class Main05 {
	static int dy[];
	public static int solution(int[] arr, int m) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = arr[i]; j <= m; j++) {
				dy[j] = Math.min(dy[j], dy[j - arr[i]] + 1);
			}			
		}
		return dy[m];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		int m = sc.nextInt();
		
		dy = new int[m + 1];
		Arrays.fill(dy,  Integer.MAX_VALUE);
		dy[0] = 0;
		
		System.out.println(solution(arr, m));
	}
}
