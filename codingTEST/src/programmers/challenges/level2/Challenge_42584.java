package programmers.challenges.level2;

//주식가격
public class Challenge_42584 {
	
	 public static int[] solution(int[] prices) {
		 int priceCnt = prices.length;
		 int[] answer = new int[priceCnt];
		 
		 for(int i = 0; i < priceCnt; i++) {
			 int idx = 0;
			 for(int j = i + 1; j < priceCnt; j++) {
				 if(prices[i] > prices[j]) {
					 idx = j;
					 break;
				 }
			 }
			 answer[i] = idx > 0 ? idx - i : priceCnt - i -1;
		 }
		 
		 return answer;
	 }
	
	public static void main(String args[]) throws Exception {
		int[] prices = {1, 2, 3, 2, 3};
//		int[] prices = {1, 2, 3, 2, 3, 1};
		
		for (int i : solution(prices))
			System.out.print(i + " ");

	}
}
