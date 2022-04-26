package programmers.challenges.level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//신고결과받기
public class Challenge_92334 {
	public static int[] solution(String[] id_list, String[] report, int k) {
       int[] answer = new int[id_list.length];
       Map<String, Integer> reportCnt = new HashMap<String, Integer>();
       Map<String, String> reportMap = new HashMap<String, String>();
       
       for(int i = 0; i < report.length; i++) {
    	   String[] arr = report[i].split(" ");
    	   String tmp = reportMap.getOrDefault(arr[0], "");
    	   
    	   if(tmp.equals("") || !tmp.contains(arr[1]) && !arr[0].equals(arr[1])) {
    		   reportMap.put(arr[0], reportMap.getOrDefault(arr[0], "") + " " + arr[1]);
    		   reportCnt.put(arr[1], reportCnt.getOrDefault(arr[1], 0) + 1);
    	   }
       }
       
       ArrayList<String> sb = new ArrayList<String>();
       for(String key : reportCnt.keySet()) {
    	  if(reportCnt.get(key) >= k) {
    		  sb.add(key);
    	  }
       }
       
       if(sb.size() > 0) {
    	   for(int i = 0; i < id_list.length; i++) {
    		   int cnt = 0;
    		   String tmp = reportMap.get(id_list[i]);
    		   if(tmp != null && !tmp.equals("")) {
    			   String[] who = tmp.trim().split(" ");
    			   for(String w : who) {
    				   if(sb.contains(w))
    					   cnt++;
    			   }
    				   
    		   }
    		   answer[i] = cnt;
    	   }
       }
       
       return answer;
    }
	 
	public static void main(String[] args) {
//		String[] id_list = {"con", "ryan"};
//		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		String[] id_list = {"1", "2", "3", "4", "5"};
		String[] report = {"1 1", "1 4", "1 4", "1 5", "2 4", "3 4", "2 2", "4 2", "3 5", "5 2"};
		int k = 2;
		
		for(int i : solution(id_list, report, k))
			System.out.print(i + " ");
	}
	 
	 
}
