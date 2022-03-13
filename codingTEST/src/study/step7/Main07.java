package study.step7;

import java.util.LinkedList;
import java.util.Queue;

//ÀÌÁøÆ®¸® ¼øÈ¸(³ÐÀÌ ¿ì¼± Å½»ö : ·¹º§Å½»ö)
//level 0 -> 1 -> 2 -> ... 
public class Main07 {
	Node root;
	public static void bfs(Node root) {
		Queue<Node> que = new LinkedList<>();
		
		que.offer(root);
		int level = 0;
		
		while(!que.isEmpty()) {
			int length = que.size();
			System.out.print(level + " : " );
			for(int i = 0; i < length; i++) {
				Node currentNode = que.poll();
				System.out.print(currentNode.data + " ");
				
				if(currentNode.lt != null)
					que.offer(currentNode.lt);
				if(currentNode.rt != null)
					que.offer(currentNode.rt);
			}
			level++;
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Main07 tree = new Main07();
		tree.root = new Node(1);
		tree.root.lt = new Node(2);
		tree.root.rt = new Node(3);
		tree.root.lt.lt = new Node(4);
		tree.root.lt.rt = new Node(5);
		tree.root.rt.lt = new Node(6);
		tree.root.rt.rt = new Node(7);
		
		bfs(tree.root);
	}
}
