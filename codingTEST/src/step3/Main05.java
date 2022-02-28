package step3;

import java.util.Scanner;

public class Main05 {

	/*
	 * ���� �κ� ����
	 * ���ӵ� ������ ���� n�� �Ǵ� ��
	 */
	public static int solution(int tot) {
		int ans = 0;
		int sum = 0; 
		
		int[] arr = new int[tot/2 + 1];
		
		for(int i = 0; i < tot/2 + 1; i++)
			arr[i] = i + 1;
		
		int lt = 0;
		for(int rt = 0; rt < (tot / 2) + 1; rt++) {
			sum += arr[rt];
			
				if(sum == tot)
					ans++;
				
				while(sum >= tot) {
					sum -= arr[lt++];
				}
		}
		
		
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		int tot = kb.nextInt();
		
		System.out.print(solution(tot));
	}
}
