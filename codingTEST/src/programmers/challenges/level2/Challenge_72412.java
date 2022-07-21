package programmers.challenges.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//순위 검색

public class Challenge_72412 {
	static HashMap<String, List<Integer>> map;
	public static int[] solution(String[] info, String[] query) {
       int[] answer = new int[query.length];
       
       map = new HashMap<String, List<Integer>>();
       
       for(int i = 0; i < info.length; i++) {
    	   String[] strings = info[i].split(" ");
    	   getAllCaseString(strings, "", 0);
       }
       
       //점수에 대해 오름차순 > 이분탐색을 하기 위함
       for(String key : map.keySet())
    	   Collections.sort(map.get(key));
       
       for(int i = 0; i < query.length; i++) {
    	   query[i] = query[i].replaceAll(" and ", "");
    	   String[] s = query[i].split(" ");
    	   if(map.containsKey(s[0]))
    		   answer[i] = search(s[0], Integer.parseInt(s[1]));
    	   else
    		   answer[i] = 0;
       }
       
       return answer;
	}
	
	public static int search(String query, int score) {
		List<Integer> list = map.get(query);
		int start = 0;
		int end = list.size() - 1;
		
		while(start <= end) {
			int mid = (start + end)/ 2;
			if(list.get(mid) < score)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return list.size() - start;
	}
	
	public static void getAllCaseString(String[] strings, String key, int cnt) {
		if(cnt == 4) {
			if(!map.containsKey(key)) {
				List<Integer> list = new ArrayList<Integer>();
				map.put(key, list);
			}
			map.get(key).add(Integer.parseInt(strings[4]));
		}else {
			getAllCaseString(strings, key + "-", cnt + 1);
			getAllCaseString(strings, key + strings[cnt], cnt + 1);
		}
	}
	 
	public static void main(String args[]) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
	
		for(int i : solution(info, query))
			System.out.print(i + " ");
	}
}
