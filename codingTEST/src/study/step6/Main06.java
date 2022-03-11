package step6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main06 {

	public static ArrayList<Integer> solution(int[] arr) {
		//0 : Ã¶¼ö , 1 : Â¦²á
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		//±íÀº º¹»ç
		int[] beforeArr = arr.clone();
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length; i++) {
			if(beforeArr[i] != arr[i])
				ans.add(i + 1);
 		}
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		for(int a : solution(arr))
			System.out.print(a + " ");
	}

}
