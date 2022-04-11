package programmers.challenges.stackQue;

//단어변환
public class Search3 {
	static boolean[] visited;
	static int answer;
	
	public static void dfs(String begin, String target, String[] words, int count) {
		if(begin.equals(target)) {
			answer = count;
			return;
		}
		
		for(int i = 0; i < words.length; i++) {
			if(visited[i]) {
				continue;
			}
			
			//변경 대상이 된다면
			if(checkWords(begin, words[i])) {
				visited[i] = true;
				dfs(words[i], target, words, count + 1);
				visited[i] = false;
			}	
		}
	}
	
	public static boolean checkWords(String word, String target) {
		int cnt = 0;
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == target.charAt(i))
				cnt++;
		}
		
		
		if(cnt == word.length() - 1)
			return true;
		else 
			return false;
	}
	
	public static int solution(String begin, String target, String[] words) {
       answer = 0;
       visited = new boolean[words.length];
       
       dfs(begin, target, words, 0);
       
       return answer;
    }
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(solution(begin, target, words));
	}
}
