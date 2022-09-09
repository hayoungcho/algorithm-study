package programmers.challenges.level2;

//JadenCase 문자열 만들기
public class Challenge_12951 {

	public static String solution(String s) {
		boolean firstFlag = true;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			int ascii = (int)c;
			if(c == ' ') {
				firstFlag = true;
			}else if(Character.isAlphabetic( c)) {
				//첫글자이고
				if(firstFlag) {
					//소문자면
					if(ascii >= 97 && ascii <= 122)
						c = (char)(c - 32);
					
					firstFlag = false;
				}else {
					//대문자면
					if(ascii >= 65 && ascii <= 90)
						c = (char)(c + 32);
				}
			}else 
				firstFlag = false;
		
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String args[]) throws Exception {
		String s = "3people unFollowed me";
//		String s = "for the last week";

		System.out.println(solution(s));
	}
}
