package tmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Question{
	String stu_num;
	HashMap<String, String> question = new HashMap<String, String>();
	
	public Question(String stu_num, String index, String score) {
		this.stu_num = stu_num;
		this.question.put(index, score);
	}
	
	public void setQuestion(String index, String score) {
		question.put(index, score);
	}
}
public class main2 {
	public static String[] solution(String[] logs) {
		String[] answer = {};
		ArrayList<String> ans = new ArrayList<String>();
		HashMap<String, Question> map = new HashMap<String, Question>(); 
		for(String log : logs) {
			String[] row = log.split(" ");
			if(map.containsKey(row[0])) {
				Question ques = map.get(row[0]);
				ques.setQuestion(row[1], row[2]);
				
				map.put(row[0], ques);
			}else
				map.put(row[0], new Question(row[0], row[1], row[2]));
		}

		HashMap<Integer, ArrayList<String>> cntMap = new HashMap<Integer, ArrayList<String>>();
		for(String stuNum : map.keySet()) {
			int cnt = map.get(stuNum).question.size();
			if(cntMap.containsKey(cnt)) {
				ArrayList<String> list = cntMap.get(cnt);
				list.add(stuNum);
				cntMap.put(cnt, list);
			}else {
				cntMap.put(cnt, new ArrayList<String>(Arrays.asList(stuNum)));
			}
		}
		
		for(int cnt : cntMap.keySet()) {
			if(cnt > 1) {
				ArrayList<String> stuArr = cntMap.get(cnt);
				
				for(int i = 0; i < stuArr.size(); i++) {
					Question comp1 = map.get(stuArr.get(i));
					for(int j = i + 1; j < stuArr.size(); j++) {
						Question comp2 = map.get(stuArr.get(j));
						if(comp1.question.equals(comp2.question)) {
							if(!ans.contains(stuArr.get(i)))
								ans.add(stuArr.get(i));
							if(!ans.contains(stuArr.get(j)))
								ans.add(stuArr.get(j));
						}
					}
				}
			}
		}
		if(ans.size() > 0) {
			Collections.sort(ans);
			answer = ans.toArray(new String[ans.size()]);
		}else {
			answer = new String[1];
			answer[0] = "None";
		}
		
		return answer;
	}
	public static void main(String[] args) {
		String[] logs = {"0001 1 0", "0001 2 0", "0001 3 0", "0001 4 0", "0001 5 0", "0456 1 0", "0456 2 0", "0456 3 0", "0456 4 0", "0456 5 0"};
		for(String s : solution(logs))
			System.out.println(s);;
	}
}
