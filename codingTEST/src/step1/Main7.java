package step1;

import java.util.Scanner;

public class Main7 {
	public static boolean solution(String str) {
		boolean returnStr = true;
		int lt = 0;
		int rt = str.length() - 1;
		str = str.toUpperCase();
//		while(lt < rt) {
//			if(str.charAt(lt) == str.charAt(rt)) {
//				lt++;
//				rt--;
//				continue;
//			}else {
//				returnStr = false;
//				break;
//			}
//		}
		
		//equals - > ��ҹ��� ������
		//equalsIgnoreCase -> ��ҹ��� ���� �����ϰ� equals ����
		String tmp = new StringBuilder(str).reverse().toString();
		if(!str.equalsIgnoreCase(tmp))
			returnStr = false;
			
		return returnStr;
	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String test = kb.nextLine();
		
		System.out.println(solution(test));
	}
}

