package programmers.challenges.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//순위 검색
class Applicant{
	String language = "";
	String type = "";
	String level = "";
	String food = "";
	int score = 0;
	int idx = 0;
	
	@Override
    public boolean equals(Object o) {
		Applicant compare = (Applicant)o;
		
		if(!compare.language.equals("-") && !language.equals(compare.language)) 
			return false;
		if(!compare.type.equals("-") && !type.equals(compare.type))
			return false;
		if(!compare.level.equals("-") && !level.equals(compare.level)) 
			return false;
		if(!compare.food.equals("-") && !food.equals(compare.food))
			return false;
		if(score < compare.score) 
			return false;
		
        return true;
    }

	public Applicant(String language, String type, String level, String food, int score, int idx) {
		this.language = language;
		this.type = type;
		this.level = level;
		this.food = food;
		this.score = score;
		this.idx = idx;
	}
}

public class Challenge_72412 {

	 public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[info.length];
        List<Applicant> applicantList = new ArrayList<Applicant>();
        
        for(int i = 0; i < info.length; i++) {
        	String[] data = info[i].split(" ");
        	applicantList.add(new Applicant(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]), i));
        }
        Collections.sort(applicantList, (o1, o2) -> o1.score - o2.score);

        List<Applicant> queryList = new ArrayList<Applicant>();
        for(int i = 0; i < query.length; i++) {
        	String[] condition = query[i].replace("and", "").replace("  ", " ").split(" ");
        	queryList.add(new Applicant(condition[0], condition[1], condition[2], condition[3], Integer.parseInt(condition[4]), i));
        }
        Collections.sort(queryList, (o1, o2) -> o1.score - o2.score);

//        for(Applicant a : applicantList) 
//        	System.out.println(a.language + " , " + a.type + " , " + a.level + " , " + a.food + " , " + a.score);
//        System.out.println("\n\n");
//        for(Applicant a : queryList) 
//        	System.out.println(a.language + " , " + a.type + " , " + a.level + " , " + a.food + " , " + a.score);
//        System.out.println("\n\n");

        
        int idx = 0;
    	for(int i = 0; i < queryList.size(); i++) {
    		Applicant compare = queryList.get(i);
        	int cnt = 0;
        	for(int j = idx; j < applicantList.size(); j++) {
        		if(applicantList.get(j).score >= compare.score) {
        			if(applicantList.get(j).equals(compare)){
        				cnt++;
        			}
        		}
        	}
        	answer[compare.idx] = cnt;
        	cnt = 0;
    	}
        return answer;
    }
	 
	public static void main(String args[]) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
	
		for(int i : solution(info, query))
			System.out.print(i + " ");
	}
}
