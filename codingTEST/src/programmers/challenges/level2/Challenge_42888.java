package programmers.challenges.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//오픈채팅방
public class Challenge_42888 {

	public static String[] solution(String[] record) {
        String[] answer = {};
        
        ArrayList<String> subjectList = new ArrayList<String>();
        ArrayList<String> verbList = new ArrayList<String>();
        Map<String, String> userMap = new HashMap<String, String>();
        
        for(String r : record) {
        	String[] command = r.split(" ");
        	String userId = command[1];
        	
        	if(command[0].equals("Enter")) {
        		subjectList.add(userId);
        		verbList.add("들어왔습니다.");
        		userMap.put(command[1], command[2]);
        	}else if (command[0].equals("Leave")) {
        		subjectList.add(userId);
        		verbList.add("나갔습니다.");
        	}else
    			userMap.put(command[1], command[2]);
        }
        
        answer = new String[subjectList.size()];
        for(int i = 0; i < subjectList.size(); i++) {
        	String userName = userMap.get(subjectList.get(i));
        	answer[i] = userName + "님이 " + verbList.get(i);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		for(String s : solution(record))
			System.out.println(s);
	}
}
