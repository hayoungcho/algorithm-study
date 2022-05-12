package baekJoon;

import java.util.ArrayList;
import java.util.Scanner;

//문자열 집합
public class Challenge_14425 {
	public static int solution(ArrayList<String> str, ArrayList<String> chk) {
		int answer = 0;
		
		for(String word : chk) {
			if(str.contains(word))
				answer++;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<String> str = new ArrayList<String>();
		ArrayList<String> chk = new ArrayList<String>();
		
		for(int i = 0; i < n; i++)
			str.add(sc.next());
		for(int i = 0; i < m; i++)
			chk.add(sc.next());
		
		System.out.println(solution(str, chk));
	}
	
}
