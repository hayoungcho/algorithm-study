package step4;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Main05 {

	//K��° ū ��
	public static int solution(int[] arr, int k) {
		int ans = 0;
		// Default�� ���� ���� 
		// Collections.reverseOrder() : �������� ����
		TreeSet<Integer> tSet = new TreeSet<Integer>(Collections.reverseOrder());
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				for(int l = j + 1; l < arr.length; l++) {
					tSet.add(arr[i] + arr[j] + arr[l]);
				}
			}
		}
		
//		tSet.remove(143);
//		System.out.println(tSet.size());
//		System.out.println(tSet.first()); //�������� > �ּڰ�, �������� > �ִ� return
//		System.out.println(tSet.last()); //�������� > �ִ�, �������� > �ּڰ� return
		
		int cnt = 0;
		//hashcode�� �����
		for(int x : tSet) {
			cnt++;
			if(cnt == k)
				return x;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(solution(arr, k));
	}
	
}
