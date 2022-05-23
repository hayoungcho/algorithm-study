package programmers.challenges.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

//Æ©ÇÃ
public class Challenge_64065 {
	public static int[] solution(String s) {
		int[] answer = {};
//        s = s.substring(1, s.length() - 1);
//        String[] sets = s.split("\\},");
//        HashMap<Integer, String> map = new HashMap<Integer, String>();
//        answer = new int[sets.length];
//        
//        for(String set : sets) {
//        	set = set.replace("{", "").replace("}", "");
//        	map.put(set.split(",").length, set);
//        }
//
//        ArrayList<String> chk= new ArrayList<String>();
//        for(int i = 0; i < sets.length; i++) {
//        	String elements = map.get(i + 1);
//        	
//        	if(chk.size() > 0) {
//        		for(String c : chk)
//        			elements = elements.replaceFirst(c, "");
//        	}
//        	elements = elements.replace(",", "");
//        	chk.add(elements);
//        	answer[i] = Integer.parseInt(elements);
//        }
//        
		
		String[] nums = s.replaceAll("[}]"," ").replaceAll("[{]"," ").trim().split(" , ");
        Arrays.sort(nums, (a, b) -> {
            return a.length() - b.length();
        });
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
        	int[] elements = Stream.of(nums[i].split(",")).mapToInt(Integer::parseInt).toArray();

        	for(int j = 0; j < elements.length; j++) {
        		if(!ans.contains(elements[j]))
        			ans.add(elements[j]);
        	}
        }
        answer = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
        	answer[i] = ans.get(i);
        return answer;
    }
	
	public static void main(String[] args) {
//		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String s = "{{2},{2,2},{2,2,2},{2,2,2,2}}";
		for(int i : solution(s))
			System.out.print(i + " ");
	}
}
