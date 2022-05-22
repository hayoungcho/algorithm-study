package programmers.challenges.level1;

//거리두기 확인하기
public class Challenge_81302 {
	static int boardSize = 5; 
	
	//응시자 p, 빈 테이블 o, 파티션 x
	public static  int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i = 0; i < places.length; i++) {
        	boolean flag = true;
        	String[] board = places[i];
        	for(int j = 0; j < places.length; j++) {
        		String row = board[j];
        		for(int k = 0; k < boardSize; k++) {
        			if(row.charAt(k) == 'P') {
        				//거리두기 만족하지 않으면
        				if(!getDistance(k, j, board)) {
        					flag = false;
        					break;
        				}
        			}
        		}
        	}
        	answer[i] = flag ? 1 : 0;
        }
        
        return answer;
    }
	
	//거리두기 만족하면 true return 아니면 false
	public static boolean getDistance(int x, int y, String[] board) {
		boolean flag = true;
		
		//상하좌우 check
		int[] rangeX = {2, 1, -2, -1};
		int[] rangeY = {2, 1, -2, -1};
		
		for(int i = 0; i < rangeX.length; i++) {
			int dx = x + rangeX[i]; 
			int dy = y + rangeY[i]; 
			if(dy >= 0 && dy <= boardSize - 1) {
				if(board[dy].charAt(x) == 'P') {
					if(!(Math.abs(rangeY[i]) == 2 && board[y + rangeY[i + 1]].charAt(x) == 'X'))
						return false;
				}
			}
			if(dx >= 0 && dx <= boardSize - 1) {
				if(board[y].charAt(dx) == 'P') {
					if(!(Math.abs(rangeX[i]) == 2 && board[y].charAt(x + rangeX[i + 1]) == 'X')) 
						return false;
				}

			}
		}
		
		//대각선 check
		rangeX = new int[]{1, 1, -1, -1};
		rangeY = new int[]{1, -1, 1, -1};
		for(int i = 0; i < rangeX.length; i++) {
			int dx = x + rangeX[i]; 
			int dy = y + rangeY[i]; 
			if(dy >= 0 && dy <= boardSize - 1 && dx >= 0 && dx <= boardSize - 1) {
				if(board[dy].charAt(dx) == 'P') {
					 if(!(board[y].charAt(dx) == 'X' && board[dy].charAt(x) == 'X'))
						 return false;
				}
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
//		String[][] places = {{"OOPOO", "OPOOO", "OOOOO", "OOOOO", "OOOOO"}};
		
		for(int i : solution(places))
			System.out.print(i);
	}
}
