package study.step7;


//Tree 말단 노드까지 가장 짧은 경로
public class Main09 {
	Node root;
	
	public static int dfs(int level, Node root){
		if(root.lt == null && root.rt == null)
			return level;
		else {
			return Math.min(dfs(level + 1, root.rt), dfs(level + 1, root.lt));
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
		
		dfs(0, tree.root);
	}
}
