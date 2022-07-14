package programmers.challenges.level2;

import java.util.ArrayList;
import java.util.List;

//빛의 경로 사이클
public class Challenge_86052 {
	//상, 우, 하, 좌(시계방향)
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0,-1, 0};
	static boolean[][][] board;
	
	public static int[] solution(String[] grid) {
        int[] answer = {};
        int boardSize = grid.length;
        List<Integer> ansList = new ArrayList<Integer>();
        
        //방향성 때문에 3차원 배열로 선언
        board = new boolean[grid[0].length()][boardSize][4];

        for(int i = 0; i < grid[0].length(); i++) {
        	for(int j = 0; j < boardSize; j++) {
        		for(int d = 0; d < 4; d++) {
        			//방문한 적이 없다면
        			if(!board[i][j][d]) {
        				int cnt = countDistance(grid, i, j, d);
        				ansList.add(cnt);
        			}
        		}
        	}
        }

        //ArrayList to integer array
        //역순정렬일 경우 sorted parameter에 Comparator.reverseOrder()
        answer = ansList.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
	
	public static int countDistance(String[] grid, int i, int j, int d) {
		int cnt = 0;
		
		//처음 점으로 돌아올 때까지
		while(true) {
			if(board[i][j][d])
				break;
			
			//방문처리
			board[i][j][d] = true;
			
			if(grid[j].charAt(i) == 'R') {
				if(d == 3)
					d = 0;
				else
					d += 1;
			}

			//좌회전일때
			if(grid[j].charAt(i) == 'L') {
				if(d == 0)
					d = 3;
				else
					d -= 1;
			}
			
			//투과하기때문에 칸 개수만큼 더한 후 나머지로 index설정
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
