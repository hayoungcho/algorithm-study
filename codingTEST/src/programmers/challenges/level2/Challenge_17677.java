package programmers.challenges.level2;

import java.util.HashMap;

//뉴스 클러스팅
public class Challenge_17677 {

	public static int solution(String str1, String str2) {
        int answer = 0;
        
        HashMap<String, Integer>  strMap1 = getStrMap(str1);
        HashMap<String, Integer> strMap2 = getStrMap(str2);
        
        int union = 0;
        for(int i : strMap1.values())
        	union += i;
        for(int i : strMap2.values())
        	union += i;
        
        int inter = 0;
        HashMap<String, Integer> smallMap;
        HashMap<String, Integer> largeMap;
        
        if(strMap1.size() >= strMap2.size()) {
        	smallMap = strMap1;
        	largeMap = strMap2;
        }else {
        	smallMap = strMap2;
        	largeMap = strMap1;
        }
        
    	for(String s : smallMap.keySet()) {
        	if(largeMap.containsKey(s))
        		inter += Math.min(largeMap.get(s), smallMap.get(s));
        }
        
    	answer = (int) ((inter / (double)(union - inter)) * 65536);
    	
    	if(str1.toUpperCase().equals(str2.toUpperCase()))
    		answer = 65536;
        
        return answer;
    }
	
	public static HashMap<String, Integer> getStrMap(String str){
		HashMap<String, Integer> strMap = new HashMap<String, Integer>();
		String tmp = "";
        for(char c : str.toCharArray()) {
        	if(tmp.length() == 2) {
        		strMap.put(tmp.toUpperCase(), strMap.getOrDefault(tmp.toUpperCase(), 0) + 1);
        		tmp = tmp.charAt(1) + "";
        	}
        	tmp += c;
        	
        	if(!Character.isAlphabetic(c))
        		tmp = "";
        }
        if(tmp.length() == 2)
        	strMap.put(tmp.toUpperCase(), strMap.getOrDefault(tmp.toUpperCase(), 0) + 1);
		return strMap;
	}
	public static void main(String args[]) {
//		String str1 = "FRANCE";
//		String str2 = "french";
//		String str1 = "aa1+aa2";
//		String str2 = "AAAA12";
//		String str1 = "E=M*C^2";
//		String str2 = "e=m*c^2";
		String str1 = "handshake";
		String str2 = "shake hands";
		
		System.out.println(solution(str1, str2));
	}
}
