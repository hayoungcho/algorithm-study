package study.step3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main03 {

	public static ArrayList<Integer> solution(int k, int[] n) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < k - 1; i++) {
			map.put(n[i], map.getOrDefault(n[i], 0)+1);
		}
		int lt = 0;
		for(int rt = k - 1; rt < n.length; rt++) {
			map.put(n[rt], map.getOrDefault(n[rt],0) + 1);
			ans.add(map.size());
			map.put(n[lt], map.get(n[lt]) - 1);
			if(map.get(n[lt]) == 0) {
				map.remove(n[lt]);
			}
			lt++;
			
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);


		int m = kb.nextInt();
		int k = kb.nextInt();
		int[] n = new int[m];
		for(int i = 0; i < m; i++) {
			n[i] = kb.nextInt();
		}
		
		System.out.println(solution(k, n));
	}
}
