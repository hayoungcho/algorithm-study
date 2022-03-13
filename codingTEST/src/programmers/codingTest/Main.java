package programmers.codingTest;

import java.util.Scanner;

public class Main {

	static int[] value = {1, 5, 10, 50, 100, 500};
	
	public static int solution(int money, int[] costs) {
		int answer = 0;
		int[] cntArr = new int[costs.length];
		
		for(int i = costs.length - 1; i > 0; i--) {
			if(((double)costs[i] / value[i]) < ((double)costs[i - 1] / value[i - 1])) {
				cntArr[i] = money / value[i];
				money = money % value[i];
			}
		}
		cntArr[0] = money;
		
		for(int i = 0; i < value.length; i++) {
			if(cntArr[i] != 0)
				answer += cntArr[i] * costs[i];
		}
		return answer;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt();
		int[] costs = new int[6];
		
		for(int i = 0; i < costs.length; i++)
			costs[i] = sc.nextInt();
		
		System.out.println(solution(money, costs)); 
	}
}
