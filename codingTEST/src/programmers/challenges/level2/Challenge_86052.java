package programmers.challenges.level2;

import java.util.ArrayList;
import java.util.List;

//���� ��� ����Ŭ
public class Challenge_86052 {
	//��, ��, ��, ��(�ð����)
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0,-1, 0};
	static boolean[][][] board;
	
	public static int[] solution(String[] grid) {
        int[] answer = {};
        int boardSize = grid.length;
        List<Integer> ansList = new ArrayList<Integer>();
        
        //���⼺ ������ 3���� �迭�� ����
        board = new boolean[grid[0].length()][boardSize][4];

        for(int i = 0; i < grid[0].length(); i++) {
        	for(int j = 0; j < boardSize; j++) {
        		for(int d = 0; d < 4; d++) {
        			//�湮�� ���� ���ٸ�
        			if(!board[i][j][d]) {
        				int cnt = countDistance(grid, i, j, d);
        				ansList.add(cnt);
        			}
        		}
        	}
        }

        //ArrayList to integer array
        //���������� ��� sorted parameter�� Comparator.reverseOrder()
        answer = ansList.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
	
	public static int countDistance(String[] grid, int i, int j, int d) {
		int cnt = 0;
		
		//ó�� ������ ���ƿ� ������
		while(true) {
			if(board[i][j][d])
				break;
			
			//�湮ó��
			board[i][j][d] = true;
			
			if(grid[j].charAt(i) == 'R') {
				if(d == 3)
					d = 0;
				else
					d += 1;
			}

			//��ȸ���϶�
			if(grid[j].charAt(i) == 'L') {
				if(d == 0)
					d = 3;
				else
					d -= 1;
			}
			
			//�����ϱ⶧���� ĭ ������ŭ ���� �� �������� index����
			i = (i + dx[d] + grid[0].length()) % grid[0].length();
            j = (j + dy[d] + grid.length) % grid.length;
            
            cnt++;
		}
		
		return cnt;
	}
	public static void main(String args[]) {
		String[] grid = {"SL","LR"};
//			String[] grid = {"R","R"};
		
		for(int i : solution(grid))
			System.out.print(i + " ");
	}
}
