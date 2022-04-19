package programmers.challenges.level1;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

//키패드 누르기
public class Challenge_67256 {

	
	public static String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder ans = new StringBuilder();
        
        int right = 10;
        int left = 12;
        for(int i = 0; i < numbers.length; i++) {
        	int now = numbers[i];
          	
        	if(now == 0)
        		now = 11;
        	
        	if(now % 3 == 0) {
        		ans.append("R");
        		right = now;
        	}else if(now % 3 == 1) {
        		ans.append("L");
        		left = now;
        	}else {
        		int disL = getDistance(left, now);
        		int disR = getDistance(right, now);
        		
    			if(disL > disR) {
    				ans.append("R");
    				right = now;
    			}else if(disL < disR) {
    				ans.append("L");
    				left = now;
    			}else {
    				if(hand.equals("right")) {
    					ans.append("R");
    					right = now;
    				}else {
    					ans.append("L");
    					left = now;
    				}
    			}
        	}
        }
        answer = ans.toString();
        return answer;
    }
	
	public static int getDistance(int now, int before) {
		//각 위치 좌표값
		int nowX = (now - 1) % 3;
		int nowY = (now - 1) / 3;
		
		int beforeX = (before - 1) % 3;
		int beforeY = (before - 1) / 3;
		
		return Math.abs(nowX - beforeX) +  Math.abs(nowY - beforeY);
	}
	
	public static void main(String[] args) {
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		
		System.out.println(solution(numbers, hand));
	}
	
	@Test 
	public void unitTest() {
		Assert.assertEquals(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"), "LRLLLRLLRRL");
		Assert.assertEquals(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"), "LRLLRRLLLRR");
		Assert.assertEquals(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"), "LLRLLRLLRL");
	}
}
