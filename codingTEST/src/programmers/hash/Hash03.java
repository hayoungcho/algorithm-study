package programmers.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//베스트앨범
public class Hash03 {
	static public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> arrAnswer = new ArrayList<Integer>();

        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < genres.length; i++)
        	map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        
        List<String> rankingList = new ArrayList<String>(map.keySet());
        //순서정렬
        Collections.sort(rankingList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        
        for(String genre : rankingList) {
        	Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
        	for(int i = 0; i < genres.length; i++) {
        		if(genre.contentEquals(genres[i])) {
        			tmp.put(i, plays[i]);
        		}
        	}
        	
        	ArrayList<Integer> keyList = new ArrayList<Integer>(tmp.keySet());
        	keyList.sort((o1, o2) -> tmp.get(o2).compareTo(tmp.get(o1)));
        	for(int j = 0; j < keyList.size(); j++) {
        		if(j > 1)
        			break;
        		arrAnswer.add(keyList.get(j));
        	}
        	
        	answer = new int[arrAnswer.size()];
        	
        	for(int i = 0; i < arrAnswer.size(); i++)
        		answer[i] = arrAnswer.get(i);
        }
        return answer;
    }
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		String[] genrens = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		for(int a : solution(genrens, plays))
			System.out.print(a + " ");
	}
}
