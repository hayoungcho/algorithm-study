package programmers.level1;

import java.util.Scanner;

public class newIdRecommend {

	public static String solution(String new_id) {
		String ans = "";
		
		//1단계
		new_id = new_id.toLowerCase();
		
		//2단계
		//소문자, 숫자, 0 , _, . 제외한 모든 문자 제거
		new_id = new_id.replaceAll("[^-_.a-z0-9]", "");
		
		//3단계
		//마침표가 두번 이상 연속됐을 때 . 로 치환
		new_id = new_id.replaceAll("[.]{2,}", ".");
		
		//4단계
		//마침표가 처음에나 끝에 위치하면 제거
		new_id = new_id.replaceAll("^[.]|[.]$", "");
	
		//5단계
		if(new_id.equals(""))
			new_id += "a";
		
		//6단계
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			
			if(new_id.charAt(new_id.length() - 1) == '.')
				new_id = new_id.substring(0, 14);
		}
		
		//7단계
		if(new_id.length() <= 2) {
			while(new_id.length() != 3)
				new_id += new_id.charAt(new_id.length() - 1);
		}
		
		ans = new_id;
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String new_id = sc.next();
		
		System.out.println(solution(new_id));
	}
}
