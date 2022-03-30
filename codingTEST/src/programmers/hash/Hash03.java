package programmers.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//º£½ºÆ®¾Ù¹ü
public class Hash03 {
	static public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
    
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < genres.length; i++)
        	map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        
        while(!map.isEmpty()) {
        	String maxGere = "";
        }
        
        
        return answer;
    }
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		String[] genrens = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		for(int a : solution(genrens, plays))
			System.out.println(a + " ");
	}
}
