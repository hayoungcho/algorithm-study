package study.step7;

import java.util.Scanner;

public class Main02 {

	public static void bfs(int n) {
		if(n < 1)
			return;
		else {
			bfs(n / 2);
			System.out.print(n % 2);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		bfs(n);
	}
}

