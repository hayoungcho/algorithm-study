package study.step9;

import java.util.Scanner;

//친구인가? ( Disjoint-Set : Union & Find)
public class Main06 {
	static int unf[];
	
	public static int find(int a) {
		if(a == unf[a])
			return unf[a];
		else
			return unf[a]= find(unf[a]);
	}
	public static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if(fa != fb)
			unf[fa] = fb;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//n : 학생수, m : 숫자쌍 
		int n = sc.nextInt();
		int m = sc.nextInt();
		unf = new int[n + 1];
		
		for(int i = 1; i <= n; i++)
			unf[i] = i;
		
		for(int i = 1; i <= m; i++) 
			union(sc.nextInt(), sc.nextInt());
		
		int a = sc.nextInt(); 
		int b = sc.nextInt();
		int fa = find(a);
		int fb = find(b);
		if(fa == fb)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
