package programmers.challenges.sort;

import java.util.Arrays;
//k¹øÂ° ¼ö
public class Sort1 {
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length] ;
        
        for(int i = 0; i < commands.length; i++) {
        	int[] command = commands[i];
        	
        	int[] tmp = new int[command[1] - command[0] + 1];
        	int idx = 0;
        	for(int j = command[0] - 1; j < command[1]; j++) {
        		//int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
        		
        		tmp[idx] = array[j];
        		idx++;
        	}
        	Arrays.sort(tmp);
        	answer[i] = tmp[command[2] - 1];
        } 
        return answer;
    }
	
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		for(int i : solution(array, commands))
			System.out.print(i + " ");
	}
}
