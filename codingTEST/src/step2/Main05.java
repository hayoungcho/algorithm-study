package step2;

import java.util.Scanner;

//소수찾기
//에라토스테네스 체
public class Main05 {

	public static int solution(int n ) {
		int cnt = 0;
//		for(int i = 2; i <= n; i++) {
//			int quotient = 1;
//			for(int j = 1; j <= i / 2; j++) {
//				if(i % j == 0)
//					quotient = j;
//			}
//			if(quotient == 1) {
//				System.out.print(i + " ");
//				cnt++;
//			}
//		}
		
		//에라토스테네스 체 ? 자기 배수 거름
		int[] ch = new int[n+1];
		for(int i = 2; i <= n; i++) {
			if(ch[i] == 0) {
				cnt++;
				for(int j = 1; j <= n; j+=i)
					ch[j] = i;
			}
				
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int n = kb.nextInt();

		System.out.println(solution(n));
	}
}
