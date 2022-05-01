package programmers.challenges.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

//메뉴 리뉴얼
public class Challenge_72411 {
	static HashMap<String, Integer> cntMap = new HashMap<String, Integer>();
	
	public static void combination(String word, int length, int count, int ch[], int index) {
		if(length == count) {
			StringBuilder s = new StringBuilder();
			for(int i = 0; i < ch.length; i++) {
				if(ch[i] == 1)
					s.append(word.charAt(i));
			}
			cntMap.put(s.toString(), cntMap.getOrDefault(s.toString(), 0) + 1);
		}else {
			ch[index] = 1;
			combination(word, length, count + 1, ch, index + 1);
			ch[index] = 0;
			
		}
	}
	public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(String order : orders) {
        	for(int i = 2; i < order.length(); i++) {
        		combination(order, i, 0, new int[order.length()], 0);
        	}
        }
        
        ArrayList<Integer> countList = new ArrayList<Integer>();
        Arrays.asList(course);
        
        ArrayList<String> combiList = new ArrayList<String>();
        for(String combi : cntMap.keySet()) {
        	if(countList.contains(cntMap.get(combi)))
        		combiList.add(combi);
        }
        
        Collections.sort(combiList);
        answer = (String[]) combiList.toArray(new String[0]);
        return answer;
    }
	
	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		
		for(String s : solution(orders, course))
			System.out.print(s + " ");
	}
}
