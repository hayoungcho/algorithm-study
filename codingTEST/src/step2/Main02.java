package step2;

import java.util.Scanner;

public class Main02 {
	public static int solution(int[] inputArr) {
		int returnInt = 1;
		int maxLength = inputArr[0];
		for(int i = 1; i < inputArr.length; i++) {
			if(maxLength < inputArr[i]) {
				returnInt++;
				maxLength = inputArr[i];
			}
			System.out.println(i  + " maxLength >" + maxLength);
		}
		return returnInt;
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
