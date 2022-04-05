package programmers.challenges.stackQue;

import java.util.LinkedList;
import java.util.Queue;

//�ٸ��� ������ Ʈ��
public class StackQue03 {
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> que = new LinkedList<Integer>();
        
        int totWeight = 0;
        for(int truck : truck_weights) {
        	while(true) {
        		//������� Ʈ���� ����
        		if(que.isEmpty()) {
        			que.add(truck);
        			totWeight += truck;
        			answer++;
        			//ž��
        			break;
        		}else if(que.size() == bridge_length) {
        			totWeight -= que.poll();
        		}else {
        			//�ö� �� �ִ� ���Ը�
        			if(totWeight + truck <= weight) {
        				que.add(truck);
            			totWeight += truck;
            			answer++;
            			//ž��
            			break;
        			}else {
        				que.add(0);
        				answer++;
        			}
        		}
        	}
        }
        return answer + bridge_length;
    }
	
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};

//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
}
