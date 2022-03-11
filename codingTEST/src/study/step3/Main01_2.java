package study.step3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main01_2 {

	/*
	 * 두 배열 합치기 
	 * ** Two pointers 활용
	 */
	public static ArrayList<Integer> solution(int[] arr1, int[] arr2) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		
		int p1 = 0;
		int p2 = 0;
		
		while(p1 < arr1.length && p2 < arr2.length) {
			if(arr1[p1] < arr2[p2])
				answer.add(arr1[p1++]);
			else
				answer.add(arr2[p2++]);
		}
		
		while(p1 < arr1.length)
			answer.add(arr1[p1++]);

		while(p2 < arr2.length)
			answer.add(arr2[p2++]);
					
		return answer;
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
