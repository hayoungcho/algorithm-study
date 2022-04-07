package programmers.challenges.dfs_bfs;

//��Ʈ��ũ
public class Search2 {
	
	public static void dfs(int idx, boolean check[], int[][] computers) {
		check[idx] = true;
		
		for(int i = 0; i < computers.length; i++) {
			//�湮�� ���� ���� ����Ǿ� ������ Ž��
			if(check[i] == false && computers[idx][i] == 1)
				dfs(i, check, computers);
		}
	}
	
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        //boolean�� ��� �ʱⰪ > false
        boolean check[] = new boolean[n];
        
        for(int i = 0; i < computers.length; i++) {
        	//�湮�����ʾҴٸ�
        	if(check[i] == false) {
        		answer++;
        		dfs(i, check, computers);
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int n = 3;
//		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		
		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
		System.out.println(solution(n, computers));
	}
}
