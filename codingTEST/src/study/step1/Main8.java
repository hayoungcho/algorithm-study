package study.step1;

import java.util.Scanner;

//���ĺ��� ȸ���˻�
//�̿��� ���� ���� ? 
public class Main8 {
	public static String solution(String str) {
		String returnStr = "NO";
		//A-Z�� �ƴϸ� ~ ^A-Z
		str = str.toUpperCase().replaceAll("[^A-Z]", "");
		
		String tmp = new StringBuffer(str).reverse().toString();
		
		if(str.equals(tmp))
			returnStr = "YES";
				
		return returnStr;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String test = kb.nextLine();
		
		System.out.println(solution(test));
	}

}
