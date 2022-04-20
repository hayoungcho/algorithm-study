package programmers.codingTest.date20220320;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

class Bank{
	Date date;
	int rate;
	int price;
	
	Bank(Date d, int r, int p){
		this.date = d;
		this.rate = r;
		this.price = p;
	}
}
public class Main01 {
	static String year = "2022/"; 
	public static int solution(String[] ledgers) {
		int answer = 0;
		Stack<Bank> stack = new Stack<Bank>();
		
		for(int i = 0; i < ledgers.length; i++) {
			String[] tmp = ledgers[i].split(" ");
			
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy/MM/dd").parse(year + tmp[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			int rate = Integer.parseInt(tmp[1]);
			int price = Integer.parseInt(tmp[2]);
			
			//저축일경우
			if(price > 0) {
				stack.add(new Bank(date, rate, price));
			}else {
				price = Math.abs(price);
				while(price > 0) {
					Bank bank = stack.pop();
					int reDeposit = bank.price - price;
					int out = 0; 
					if(price > bank.price) {
						price = price - bank.price;
						out = bank.price;
					}else {
						out = price;
						price = 0;
					}
					
					//나간금액만큼 이자 계산
					int days = (int) ((date.getTime() - bank.date.getTime()) / 1000 / (24*60*60));
					answer += (out * ((double)bank.rate / 100)* days ) / 365;
					
					if(reDeposit > 0) {
						stack.add(new Bank(bank.date, bank.rate, reDeposit));
					}
				}
				
			}
		}
		
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse(year + "12/31");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		while(!stack.isEmpty()) {
			Bank bank = stack.pop();
			
			int days = (int) ((date.getTime() - bank.date.getTime()) / 1000 / (24*60*60));
			answer += (bank.price * ((double)bank.rate / 100) * days) / 365;
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		String[] txt = {"01/01 4 50000","01/11 6 3555","02/01 0 -23555","02/25 5 5000","03/25 0 -15000","06/09 8 43951","12/30 9 99999"};
		String[] txt = {"04/01 1 40000","05/01 5 20000","08/31 4 10000","11/11 0 -45000"};
		
		System.out.println(solution(txt));
	}
	 
	 
}
