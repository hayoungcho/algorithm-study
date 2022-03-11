package step2;

import java.util.ArrayList;
import java.util.Scanner;


public class Main01 {
	public static ArrayList<Integer> solution(int[] inputArr) {
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		
//		for(int i = (inputArr.length -1); i > 0; i--) {
//			if(inputArr[i] > inputArr[i-1])
//				returnList.add(inputArr[i]);
//		}
		returnList.add(inputArr[0]);
		for(int i = 1; i < (inputArr.length); i++) {
			if(inputArr[i] > inputArr[i - 1]) 
				returnList.add(inputArr[i]);
		}
		return returnList;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int inputArr[] = new int[n];
		for(int i = 0; i < n; i++) {
			inputArr[i] = kb.nextInt();
		}
		
		System.out.println(solution(inputArr));
	}
}
