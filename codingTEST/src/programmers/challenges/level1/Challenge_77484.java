package programmers.challenges.level1;

import java.util.HashMap;

//로또의 최고 순위와 최저 순위
public class Challenge_77484 {
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        HashMap<Integer, Integer> lottoMap = new HashMap<Integer, Integer>();
        for(int num : win_nums)
        	lottoMap.put(num, lottoMap.getOrDefault(num, 0) + 1);
        
        int low = 7;
        int high = 7;
        for(int lotto : lottos) {
        	if(lotto == 0)
    			high--;
        	else {
        		if(lottoMap.containsKey(lotto)) {
        			high--;
        			low--;
        			if(lottoMap.get(lotto) > 1)
        				lottoMap.put(lotto, lottoMap.get(lotto) - 1);
        			else
        				lottoMap.remove(lotto);
        		}
        	}
        }
        low = (low == 7) ? 6 : low;
        high = (high == 7) ? 6 : high;
        
        answer[0] = high;
        answer[1] = low;
        
        return answer;
	}
	
	public static void main(String[] args) {
//		int[] lottos = {44, 1, 0, 0, 31, 25};
//		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] lottos = {0, 0, 0, 0, 0, 0};
		int[] win_nums = {38, 19, 20, 40, 15, 25};
//		int[] lottos = {97, 96, 99, 98, 95, 94};
//		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		for(int i : solution(lottos, win_nums))
			System.out.print(i + " ");
	}
}
