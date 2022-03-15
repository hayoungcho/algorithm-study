package study.step7;

import java.util.LinkedList;
import java.util.Queue;

public class Main10 {
	//bfs : level Ž��
	
	Node root;
	
	public static int bfs(Node root) {
		Queue<Node> que = new LinkedList<Node>();
		que.offer(root);
		int level = 0;
		
		while(!que.isEmpty()) {
			//length ���� �����������
			//for�� �������� que.offer�� ���� size�� ������ 
			int queSize = que.size();
			for(int i = 0; i < queSize; i++) {
				Node tmp = que.poll();
				if(tmp.lt == null && tmp.rt == null)
					return level;
				
				if(tmp.lt != null)
					que.offer(tmp.lt);
				if(tmp.rt != null)
					que.offer(tmp.rt);
			}
			level++;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		Main10 tree = new Main10();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		
		System.out.println(bfs(tree.root));
	}
}
