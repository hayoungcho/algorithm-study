package tmp;

import java.util.ArrayList;

public class main4 {
	static int cnt = 0;
	static int size = 7;
	static ArrayList<ArrayList<Integer>> array ;
	static ArrayList<String> removeArr;
	public static  String[] solution(int[][] macaron) {
		String[] answer = new  String[6];
		array = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < size; i++) {
			ArrayList<Integer> inital = new ArrayList<Integer>();
			for(int j = 0; j < size; j++)
				inital.add(0);
				
			array.add(i, inital);
		}
		
		for(int[] command : macaron) {
			array.get(command[0]).add(command[1]);
			cnt = 0;
			removeArr = new ArrayList<String>();
			checkCnt(command[0], array.get(command[0]).size(), command[1]);
			if(cnt >= 3) {
				for(int i = 0; i < removeArr.size(); i++) {
					remove(removeArr.get(i).charAt(0), removeArr.get(i).charAt(1));
				}
			}
		}
		
		for(int i = 0; i < 6; i++) {
			StringBuilder s = new StringBuilder();
			ArrayList<Integer> vertical = array.get(i);
			for(int j = 0; j < 6; j++) {
				s.append(vertical.get(j));
			}
			answer[i] = s.toString();
		}
		return answer;
	}
	
	public static void remove(int x, int y) {
		array.get(x).remove(y);
	}
	public static void checkCnt(int x, int y, int color) {
		if(y + 1 <= 6 && array.get(x).get(y + 1) == color) {
			cnt++;
			removeArr.add(x + "" + y + 1);
			checkCnt(x, y + 1, color);
		}
		if(y - 1 >= 0 && array.get(x).get(y - 1) == color) {
			cnt++;
			removeArr.add(x + "" + y + 1);
			checkCnt(x, y - 1, color);
		}
		if(x + 1 <= 6 && array.get(x + 1).get(y) == color) {
			cnt++;
			removeArr.add(x + "" + y + 1);
			checkCnt(x + 1, y, color);
		}
		if(x - 1 >= 0 && array.get(x - 1).get(y) == color) {
			cnt++;
			removeArr.add(x + "" + y + 1);
			checkCnt(x - 1, y, color);
		}
	}
	public static void main(String[] args) {
		int[][] macaron = {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
		System.out.println(solution(macaron));
	}
}
