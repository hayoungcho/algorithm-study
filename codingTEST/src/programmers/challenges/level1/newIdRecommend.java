package programmers.challenges.level1;

import java.util.Scanner;

public class newIdRecommend {

	public static String solution(String new_id) {
		String ans = "";
		
		//1�ܰ�
		new_id = new_id.toLowerCase();
		
		//2�ܰ�
		//�ҹ���, ����, 0 , _, . ������ ��� ���� ����
		new_id = new_id.replaceAll("[^-_.a-z0-9]", "");
		
		//3�ܰ�
		//��ħǥ�� �ι� �̻� ���ӵ��� �� . �� ġȯ
		new_id = new_id.replaceAll("[.]{2,}", ".");
		
		//4�ܰ�
		//��ħǥ�� ó������ ���� ��ġ�ϸ� ����
		new_id = new_id.replaceAll("^[.]|[.]$", "");
	
		//5�ܰ�
		if(new_id.equals(""))
			new_id += "a";
		
		//6�ܰ�
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			
			if(new_id.charAt(new_id.length() - 1) == '.')
				new_id = new_id.substring(0, 14);
		}
		
		//7�ܰ�
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
