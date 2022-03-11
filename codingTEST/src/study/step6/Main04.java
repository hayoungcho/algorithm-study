package step6;

import java.util.Scanner;
import java.util.Stack;

public class Main04 {
	
	//Least Recently Used(LRU Algorithm)

	//array
	public static int[] solution2(int[] arr, int s) {
		int[] ans = new int[s];
		
		//배열크기전체가 아니라 데이터 개수만큼만 search위해
		int arrSize = 0;
		for(int i = 0; i < arr.length; i++) {
			int idx = -1;
			for(int j = 0; j < arrSize; j++) {
				if(ans[j] == arr[i]) {
					idx = j;
					break;
				}
			}
			if(!(arrSize < s && idx > -1)) 
				idx = ans.length - 1;
			
			for(int j = idx; j > 0; j--) 
				ans[j] = ans[j - 1];
			
			if(arrSize != s && idx == -1)
				arrSize++;
			
			ans[0] = arr[i];
		}
		
		return ans;
	}
	
	//stack
	public static int[] solution(int[] arr, int s) {
		int[] ans = new int[s];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < arr.length; i++) {
			if(stack.size() < s) {
				if(stack.contains(arr[i])) {
					int idx = stack.indexOf(arr[i]);
					
					for(int j = 0; j < idx; j++) {
						if(stack.get(j) > arr[i]) 
							stack.remove(idx);
					}
				}
			}else {
				stack.pop();
			}
			stack.add(0, arr[i]);
		}
		
		for(int i = 0; i < stack.size(); i++)
			ans[i] = stack.get(i);
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) 
			arr[i] = sc.nextInt();
		
		for(int x : solution(arr, s))
			System.out.print(x + " ");
		
		System.out.println();
		
		for(int x : solution2(arr, s))
			System.out.print(x + " ");
	}
}
