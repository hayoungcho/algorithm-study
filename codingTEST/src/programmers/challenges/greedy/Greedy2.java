package programmers.challenges.greedy;

//조이스틱
public class Greedy2 {
	public static int solution(String name) {
        int answer = 0;
        
        int minMove = name.length() - 1;
        for(int i = 0; i < name.length(); i++) {
        	//상하 이동 최소 count 수
        	answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        	
        	int next = i + 1;
        	while(next < name.length() && name.charAt(next) == 'A')
        		next++;
        	
        	
        	minMove = Math.min(minMove, i + name.length() - next + i);
        }
        
        answer += minMove;
        return answer;
    }
	
	public static void main(String[] args) {
		String name = "JEROEN";
		
		System.out.println(solution(name));
	}
}
