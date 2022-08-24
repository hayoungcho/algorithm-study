package programmers.challenges.level3;

//등산 코스 정하기 
public class Challenge_118669 {

	static int intensity = Integer.MAX_VALUE;
	static int peak = Integer.MAX_VALUE;
	static int[][] graph;
	
	public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        
        graph = new int[n + 1][n + 1];
        
        for(int[] path : paths) {
        	graph[path[0]][path[1]] = path[2];
        	graph[path[1]][path[0]] = path[2];
        }
        
        for(int i = 1; i < graph.length; i++) {
        	for(int j = 1; j < graph.length; j++) {
        		if(graph[i][j] > 0)
        			graph[i][0]++;
        	}
        }
        
        for(int gate : gates)
        	bfs(gate, gate, 0, Integer.MIN_VALUE, gates, summits, 0);
        
        answer[0] = peak;
        answer[1] = intensity;
        
        return answer;
    }
	
	//산봉우리는 하나만
	public static void bfs(int start, int now, int before, int distance, int[] gates, int[] summits, int p) {
		if(p > 0) {
			if(intensity >= distance) {
				if(intensity == distance)
					peak = Math.min(peak, p);
				else
					peak = p;
				
				intensity = distance;
			}
		}else {
			for(int i = 1; i < graph.length; i++) {
				if(i != p && containsChk(gates, i) && before != i) {
					if(!containsChk(summits, i))
						p = i;
					
					if(graph[now][i] != 0)
						bfs(start, i, now, Math.max(graph[now][i], distance), gates, summits, p);
					p = 0;
				}
			}
		}
	}
	
	//포함하면 false, 포함하지 않으면  true
	public static boolean containsChk(int[] arrays, int compare) {
		for(int i : arrays) {
			if(i == compare)
				return false;
		}
		return true;
	}

	public static void main(String args[]) throws Exception {
//		int n = 6;
//		int[][] paths = {{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}};
//		int[] gates = {1, 3};
//		int[] summits = {5};
		
//		int n = 7;
//		int[][] paths = {{1, 4, 4}, {1, 6, 1}, {1, 7, 3}, {2, 5, 2}, {3, 7, 4}, {5, 6, 6}};
//		int[] gates = {1};
//		int[] summits = {2, 3, 4};
		
//		int n = 7;
//		int[][] paths = {{1, 2, 45}, {1, 4, 1}, {2, 3, 1}, {2, 6, 7}, {4, 5, 1}, {5, 6, 1}, {6, 7, 1}};
//		int[] gates = {3, 7};
//		int[] summits = {1, 5};

		int n = 5;
		int[][] paths = {{1, 3, 10}, {1, 4, 20}, {2, 3, 4}, {2, 4, 6}, {3, 5, 20}, {4, 5, 6}};
		int[] gates = {1, 2};
		int[] summits = {5};
		
		for(int i : solution(n, paths, gates, summits))
			System.out.print(i + " ");

	}

}
