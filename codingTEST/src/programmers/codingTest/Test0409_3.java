package programmers.codingTest;

import java.util.HashMap;

public class Test0409_3 {
	public static String solution(String tstring, String[][] variables) {
		String result = "";
		HashMap<String, String> varMap = new HashMap<String, String>();
		
		for(int i = 0; i < variables.length; i++) 
			varMap.put(variables[i][0], variables[i][1]);
		
		for(String key :varMap.keySet()) {
			if(tstring.indexOf(key) > -1) {
				String changeVal = varMap.get(key);
				
				while(changeVal.indexOf("{") > -1) {
					String tmp = changeVal.substring(changeVal.indexOf("${") + 2, changeVal.indexOf("}"));
					if(varMap.containsKey(tmp)) {
						changeVal = varMap.get(tmp);
						
						if(varMap.get(key).equals(changeVal)) {
							changeVal = varMap.get(key);
							break;
						}
						if(changeVal.indexOf(key) > -1) 
							break;
						
					}else
						break;
				}
				key = key.trim();
				tstring = tstring.replaceAll("\\{" + key + "\\}", changeVal);
			}
		}
		
		result = tstring;
		return result;
	}
	
	public static void main(String[] args) {
		String tstring = "this is {template} {template} is {state}";
//		String tstring = "{a} {b} {c} {d} {i}";
//		String[][] variables = {{"template", "string"}, {"state", "changed"}};
//		String[][] variables = {{"template", "string"}, {"state", "{template}"}};
		String[][] variables = {{"template", "{state}"}, {"state", "{template}"}};
//		String[][] variables = {{"b", "{c}"}, {"a", "{b}"}, {"e", "{f}"}, {"h", "i"}, {"d", "{e}"}, {"f", "{d}"}, {"c", "d"}};
		
		System.out.println(solution(tstring, variables));
	}
}
