package programmers.challenges.level2;

//행렬 테두리 회전하기
public class Challenge_77485 {
	static int[][] graph;
	
	public static int[] solution(int rows, int columns, int[][] queries) {
	       int[] answer = new int[queries.length];
	       
	       graph = new int[rows + 1][columns + 1];
	       int numCnt = 1;
	       for(int i = 1; i <= rows; i++) {
	       	for(int j = 1; j <= columns; j++)
	       		graph[i][j] = numCnt++;
	       }

	       for(int i = 0; i < queries.length; i++){
	    	   answer[i] = rotation(queries[i]);
	    	   print();
			}	       
	       
	       return answer;
	 }
	 
	public static int rotation(int[] query) {
		int minValue = Integer.MAX_VALUE;
		
		int startX = query[1];
		int startY = query[0];
		int endX = query[3];
		int endY = query[2];
		
		//시작점 값 바꾸기 위해 tmp로 저장
		int tmpValue = graph[startY + 1][startX];
		int x = startX;
		int y = startY;
		
		// 왼 -> 오
		for(int i = startX; i <= endX; i++) {
			int tmp = graph[y][i];
			minValue = Math.min(minValue, tmp);
			graph[y][i] = tmpValue;
			tmpValue = tmp;
			x = i;
		}
		
		// 상 -> 하
		for(int i = startY + 1; i <= endY; i++) {
			int tmp = graph[i][x];
			minValue = Math.min(minValue, tmp);
			graph[i][x] = tmpValue;
			tmpValue = tmp;
			y = i;
		}
		
		// 오 -> 왼
		for(int i = x - 1; i >= startX; i--) {
			int tmp = graph[y][i]; 
			minValue = Math.min(minValue, tmp);
			graph[y][i] = tmpValue;
			tmpValue = tmp;
			x = i;
		}
		
		//하 -> 상
		for(int i = y - 1; i >= startY; i--) {
			int tmp = graph[i][x]; 
			minValue = Math.min(minValue, tmp);
			graph[i][x] = tmpValue;
			tmpValue = tmp;
			y = i;
		}
		
		return minValue;
	}
	
	//test출력용
	public static void print(){
		for(int i = 1; i < graph.length; i++){
			for(int j = 1; j < graph[0].length; j++){
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	 public static void main(String[] args) {
//		 int rows = 6;
//		 int columns = 6;
//		 int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};

		 int rows = 100;
		 int columns = 97;
		 int[][] queries = {{1,1,100,97}};
		 
		 for(int i : solution(rows, columns, queries))
			 System.out.print(i + " ");
	 }
}
