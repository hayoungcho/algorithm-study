package step5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person{
	int id;
	int priority;
	
	public Person(int id, int prority) {
		this.id = id;
		this.priority = prority;
	}
}

public class Main08 {

	public static int solution(int[] arr, int m) {
		int ans = 0;
		Queue<Person> que = new LinkedList<Person>();
		
		for(int i = 0; i < arr.length; i++) {
			Person p = new Person(i , arr[i]);
			que.add(p);
		}
		
		while(!que.isEmpty()) {
			Person tmp = que.poll(); //delete
			
			for(Person p : que) {
				if(p.priority > tmp.priority) {
					que.offer(tmp);
					tmp = null;
					break;
				}
			}
			
			if(tmp != null) {
				ans++;
				
				if(tmp.id == m)
					return ans;
			}
		}
		
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		System.out.println(solution(arr, m));
	}
}
