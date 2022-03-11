package study.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//역순해서 소수인 숫자만 출력
public class Main06 {
	public boolean isPrime(int num) {
		if(num == 1)
			return false;
		for(int i = 2; i < num; i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}
	public static List<Integer> solution(int[] inputArr) {
		List<Integer> returnList = new ArrayList<Integer>();
		for(int i = 0; i < inputArr.length; i ++) {
			int tmp = inputArr[i];
			int tmpNum = 0;
			int pow = 0;
			while(tmp > 0) {
				tmpNum += (tmp % 10) * Math.pow(10, pow);
				pow++;
				tmp = tmp / 10;
			}
			System.out.println(tmpNum);
		}
		return returnList;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();
		int[] inputArr = new int[n];
		for(int i = 0; i < n; i++) {
			inputArr[i] = kb.nextInt();
		}
		for(int x : solution(inputArr))
			System.out.println(x);
	}

}
