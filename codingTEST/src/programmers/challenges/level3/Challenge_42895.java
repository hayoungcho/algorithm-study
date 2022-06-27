package programmers.challenges.level3;

//n으로 표현
public class Challenge_42895 {

	//1 dfs 
	//2 dp(dynamic programming)
	
	static int min = Integer.MAX_VALUE; 
	
	public static int solution(int N, int num) {
        dfs(0, N, num, 0);
        
        if(min == Integer.MAX_VALUE)
        	return -1;
        
        return min;
    }
	
	public static void dfs(int cnt, int N, int num, int now) {
		//횟수
		if(cnt > 8)
			return;
		
		if(num == now)
			min = Math.min(cnt, min);
		
		int tmp = 0;
		for(int i = 0; i < 8; i++) {
			if(cnt + i < 8) {
				tmp = tmp * 10 + N;
                dfs(cnt + i + 1, N, num, now + tmp);
                dfs(cnt + i + 1, N, num, now - tmp);
                dfs(cnt + i + 1, N, num, now / tmp);
                dfs(cnt + i + 1, N, num, now * tmp);   
			}
		}
	}
	
	public static void main(String args[]) {
		int N = 5;
		int num = 12;
		
		System.out.println(solution(N, num));
	}
}
