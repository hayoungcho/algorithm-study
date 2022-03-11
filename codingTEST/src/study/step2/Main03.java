package study.step2;

import java.util.Scanner;

public class Main03 {
	//가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보
	public static String[] solution(int[] a, int[] b){
		String[] returnStr = new String[a.length];
		for(int i = 0; i < a.length; i++) {
			if(Math.abs(a[i] - b[i]) == 1) {
				if(a[i] > b[i])
					returnStr[i] = "A";
				else
					returnStr[i] = "B";
			}else if(Math.abs(a[i] - b[i]) == 0) {
				returnStr[i] = "D";
			}else {
				if(a[i] > b[i])
					returnStr[i] = "B";
				else
					returnStr[i] = "A";
			}
				
		}
		return returnStr;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int inputA[] = new int[n];
		int inputB[] = new int[n];
		for(int i = 0; i < n; i++) {
			inputA[i] = kb.nextInt();
		}
		for(int i = 0; i < n; i++) {
			inputB[i] = kb.nextInt();
		}
		
		for(String res : solution(inputA, inputB)) {
			System.out.println(res);
		}
//		System.out.println(solution(inputA, inputB));
	}

}
