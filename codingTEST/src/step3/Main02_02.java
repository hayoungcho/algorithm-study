package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main02_02 {
	/*
	 * 공통 원소 구하기
	 * 1. 오름 차순 정렬 먼저
	 * 2. 같은 원소 추출 
	 */
	public static ArrayList<Integer> solution(int[] arr1, int[] arr2){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		//오름차순 정렬
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int p1 = 0; 
		int p2 = 0; 
		
		while(p1 < arr1.length&& p2 < arr2.length){
			 if(arr1[p1] == arr2[p2]) {
				 ans.add(arr1[p1++]);
				 p2++;
			 }else if(arr1[p1] < arr2[p2]) {
				 p1++;
			 }else {
				 p2++;
			 }
				 
		}
			
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int a = kb.nextInt();
		int[] arr1 = new int[a];
		for(int i = 0; i < a; i++ )
			arr1[i] = kb.nextInt(); 
		
		int b = kb.nextInt();
		int[] arr2 = new int[b];
		for(int i = 0; i < b; i++ )
			arr2[i] = kb.nextInt(); 
		
		for(int ans : solution(arr1 , arr2))
			System.out.print(ans + " ");
	}

}
