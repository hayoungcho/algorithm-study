package programmers.challenges.dfs_bfs;

//Å¸°Ù³Ñ¹ö
public class Search1 {
	static int answer = 0;
	
	//maybe dfs
	public static void dfs(int[] numbers, int idx, int now, int target) {
		if(idx == numbers.length) {
			if(now == target)
				answer++;
			
			return;
		}else {
			dfs(numbers, idx + 1, now + numbers[idx], target);
			dfs(numbers, idx + 1, now - numbers[idx], target);
		}
		
	}
	
	public static int solution(int[] numbers, int target) {
		dfs(numbers, 0, 0, target);
		
		return answer;
	}
	
	public static void main(String[] args) {
//		int[] numbers = {1, 1, 1, 1, 1};
//		int target = 3;

		int[] numbers = {4, 1, 2, 1};
		int target = 4;
		
		
		
		System.out.println(solution(numbers, target));
	}
}
