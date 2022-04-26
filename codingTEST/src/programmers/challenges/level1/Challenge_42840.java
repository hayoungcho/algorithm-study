package programmers.challenges.level1;

import java.util.ArrayList;

//모의고사
public class Challenge_42840 {
	public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] ansA = {1, 2, 3, 4, 5};
        int[] ansB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] ansC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] ans = new int[3]; 
        for(int i = 0; i < answers.length; i++) {
        	if(ansA[i % ansA.length] == answers[i])
        		ans[0] += 1;
        	if(ansB[i % ansB.length] == answers[i])
        		ans[1] += 1;
        	if(ansC[i % ansC.length] == answers[i])
        		ans[2] += 1;
        	
        }
        
        int maxCnt = Math.max(ans[0], Math.max(ans[1], ans[2]));
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < ans.length; i++) {
        	if(ans[i] == maxCnt)
        		list.add(i + 1);
        }
        	
        answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++)
        	answer[i] = list.get(i);
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] answers = {1,1,1,1};
		
		for(int i : solution(answers))
			System.out.print(i+ " ");
	}
}
