package programmers.codingTest;

import java.util.Scanner;

public class Main02 {
	static int n;
	static int x = 0;
	static int y = 0;
	static int[][] arr;
	static int cnt = 1;
	static boolean endFlag = true;
	
	public int right(int x, int y) {
		this.x++;
		int i = 0;
		int num = arr[x][y];
		endFlag = true;
		for(i = x; i < n - 1; i++) {
			arr[x][i] = ++num; 
			endFlag = false;
		}
		return i;
	}
	public int down(int x, int y) {
		this.y++;
		int i = 0;
		int num = arr[x][y];
		endFlag = true;
		for(i = y; i < n - 1; i++) {
			arr[i][x] = ++num; 
			endFlag = false;
		}
		return i;
	}
	public int left(int x, int y) {
		this.x--;
		int i = 0;
		int num = arr[x][y];
		endFlag = true;
		for(i = x; i > cnt - 1; i--) {
			arr[x][i] = ++num; 
			endFlag = false;
		}
		return i;
	}
	public int top(int x, int y) {
		this.y--;
		int i = 0;
		int num = arr[x][y];
		endFlag = true;
		for(i = y; i > cnt - 1; i--) {
			arr[i][x] = ++num;
			endFlag = false;
		}
		return i;
	}
	
    public int[][] solution(int n, boolean clockwise) {
        int[][] answer = {};
        
        if(clockwise){
            while(Math.ceil((double) n/ 2) > cnt){
                x = right(x, y);
                print();
                if(endFlag)
                    break;
                y = down(x, y);
                print();
                if(endFlag)
                    break;
                x = left(x, y);
                print();
                if(endFlag)
                    break;
                y = top(x, y);
                print();
                if(endFlag)
                    break;
                cnt++;
            }
        }else{
            while(Math.ceil((double) n/ 2) < cnt){
                y = down(x, y);
                if(endFlag)
                    break;
                x = right(x, y);
                if(endFlag)
                    break;
                y = top(x, y);
                if(endFlag)
                    break;
                x = left(x, y);
                if(endFlag)
                    break;
                cnt++;
            }
        }
        answer = arr;
        return answer;
    }
   
    public static void print() {
    	for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
    	System.out.println();
    }
	public static void main(String[] args) {
		Main02 m = new Main02();
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n][n];
		boolean clockwise = sc.nextBoolean();
		
		int[][] arr = m.solution(n, clockwise);
		
		print();
	
		
	}
}
