package programmers.challenges.level2;

import org.junit.Test;

import junit.framework.Assert;

//문자열 압축 
//2020 kakao blind recruitment
public class Challenge_60057 {
	
	public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        if(s.length() <= 1)
        	return s.length();
        
        for(int i = 1; i <= s.length() / 2; i++) {
        	String patternStr = s.substring(0, i);
        	int cnt = 1;
        	String tmpStr = "";	
        	for(int j = i; j <= s.length() - i; j += i) {
        		if(patternStr.equals(s.substring(j, j + i))) {
        			cnt++;
        		}else {
        			if(cnt > 1)
        				tmpStr += cnt + "";
        			
        			tmpStr += patternStr;
        			patternStr = s.substring(j, j + i);
        			cnt = 1;
        		}
        	}
        	
        	if(cnt > 1)
        		tmpStr += "" + cnt;
        	
        	tmpStr += patternStr;
        	answer = Math.min(answer, tmpStr.length() + s.length() % i);
        }
        return answer;
    }
	
	@Test
	public void unitTest(){
		Assert.assertEquals(7,  solution("aabbaccc"));
		Assert.assertEquals(9, solution("ababcdcdababcdcd"));
		Assert.assertEquals(8, solution("abcabcdede"));
		Assert.assertEquals(14, solution("abcabcabcabcdededededede"));
		Assert.assertEquals(17, solution("xababcdcdababcdcd"));
	}
	
	public static void main(String[] args) {
//		String s = "aabbaccc";
		String s = "abcabcdede";
//		String s = "xababcdcdababcdcd";
		
		System.out.println(solution(s));
	}
}

