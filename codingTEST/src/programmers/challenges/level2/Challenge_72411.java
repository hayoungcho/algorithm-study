package programmers.challenges.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//메뉴 리뉴얼
public class Challenge_72411 {
	static HashMap<String, Integer> cntMap = new HashMap<String, Integer>();
	
	public static void combination(char[] order, int[] ch, int idx, int r) {
		if (r == 0) {
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < order.length; i++) {
				if (ch[i] == 1)
					str.append(order[i]);
			}
			cntMap.put(str.toString(), cntMap.getOrDefault(str.toString(), 0) + 1);
		} else {
			for (int i = idx; i < order.length; i++) {
				ch[i] = 1;
				combination(order, ch, i + 1, r - 1);
				ch[i] = 0;
			}
		}
	}
	
	public static String[] solution(String[] orders, int[] course) {
		List<String> answer = new ArrayList<>();
		
		for(int i = 0; i< course.length; i++){
			for(int j = 0; j < orders.length; j++){
				int[] check = new int[orders[j].length()];
				char[] order = orders[j].toCharArray();
				Arrays.sort(order);
				combination(order, check, 0, course[i]);
			}

			List<Map.Entry<String, Integer>> mapToList = new ArrayList<>(cntMap.entrySet());

			//내림차순
			mapToList.sort((key1, key2) -> key2.getValue().compareTo(key1.getValue()));

			int max = 0;
			for(Map.Entry<String, Integer> entry : mapToList) {
				if(entry.getValue() >= 2 && max <= entry.getValue()) {
					max = entry.getValue();
					answer.add(entry.getKey());
				}
			}
			cntMap.clear();
		}

		String[] answerArr = answer.toArray(new String[1]);
		Arrays.sort(answerArr);

		return answerArr;
    }
	
	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		
		for(String s : solution(orders, course))
			System.out.print(s + " ");
	}
}
