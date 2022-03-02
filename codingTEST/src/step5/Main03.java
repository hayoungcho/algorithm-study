package step5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//카카오 크레인 인형뽑기 
public class Main03 {

	//peek() : stack 가장 상단 item return 
	
	public static int solution2(int[][] board, int[] moves) {
		int ans = 0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int pos : moves) {
			for(int i = 0; i < board.length; i++) {
				if(board[i][pos - 1] != 0) {
					int tmp = board[i][pos - 1];
					board[i][pos - 1] = 0;
					
					if(!stack.isEmpty() && tmp == stack.peek()) {
						ans += 2;
						stack.pop();
					}else
						stack.push(tmp);
					
					break;
				}
			}
		}
		return ans;
	}
	public static int solution(int[][] board, int[] moves) {
		int ans = 0;
		Stack<Integer> basket = new Stack<Integer>();
		List<Stack<Integer>> stackList = new ArrayList<>();
		for(int i = 0 ; i < board.length; i ++) {
			Stack<Integer> boardStack = new Stack<Integer>();
			for(int j = board.length -1 ; j >= 0; j--) {
				if(board[j][i] != 0)
					boardStack.add(board[j][i]);
			}
			stackList.add(boardStack);
		}
		
		for(int i = 0; i < moves.length; i++) {
			Stack<Integer> stack = stackList.get(moves[i] - 1);
			if(!stack.empty()) {
				int lastItem = stack.pop();
				
				if(!basket.empty() && basket.lastElement().equals(lastItem)) {
					ans += 2;
					basket.pop();
				}else
					basket.push(lastItem);
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		int m = sc.nextInt();
		int[] moves = new int[m];
		for(int i = 0; i < m; i++) 
			moves[i] = sc.nextInt();

		System.out.println(solution(board, moves));
	}
	
}
