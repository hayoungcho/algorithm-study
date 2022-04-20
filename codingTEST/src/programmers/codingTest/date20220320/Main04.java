package programmers.codingTest.date20220320;

import java.util.ArrayList;

class Node{
	String nodeName = "";
	Node parentNode;
	ArrayList<Node> childNodeArr = new ArrayList<>();
	
	Node(String n){
		this.nodeName = n;
	}
	public ArrayList<Node> getChildNodeArr(){
		return childNodeArr;
	}
	public void removeChildNode(String removeName){
		for(int i = 0; i <childNodeArr.size(); i++) {
			if(childNodeArr.get(i).nodeName.contentEquals(removeName)) {
				childNodeArr.remove(i);
			}
		}
	}
	public Node addChild(String nodeName) {
		Node childNode = new Node(nodeName);
		childNode.setParentNode(this);
		childNodeArr.add(childNode);
		
		return childNode;
	}
	
	public void setParentNode(Node parentNode) { 
		this.parentNode = parentNode;
	}
}
public class Main04 {
	  public static String[] solution(String[] directory, String[] command) {
	        String[] answer = {};
	        Node root = new Node("root");
	        
	        for(int i = 1; i < directory.length; i++) {
	        	String[] split = directory[i].split("/");
	        	
	        	ArrayList<Node> array = root.getChildNodeArr();
	        	if(split.length == 2) {
	        		root.addChild(split[1]);
	        	}else {
	        		for(int j = 0; j < array.size(); j++) {
	        			if(split[split.length - 2].contentEquals(array.get(j).nodeName)) {
	        				Node parent = array.get(j);
	        				parent.addChild(split[split.length - 1]);
	        			}
	        		}
	        	}
	        }
	        
	        for(int i = 0; i < command.length; i++) {
	        	String action = command[i].split(" ")[0];
	        	String dir = command[i].split(" ")[1];
	        	String[] folder = dir.split("/");
	        	ArrayList<Node> array = root.getChildNodeArr();
	        	
	        	if(action.equals("mkdir")) {
	        		
	        		if(folder.length == 2)
	        			root.addChild(folder[1]);
	        		else {
	        			for(int j = 0; j < folder.length -2; j++) {
	        				Node node = array.get(j);
	        				if(node.nodeName.equals(folder[folder.length - 2])) {
	        					node.addChild(folder[folder.length - 2]);
	        				}
	        			}
	        		}
	        		
	        	}else if(action.equals("cp")){
	        		for(int j = 1; j < folder.length; j++) {
	        			
	        			
	        		}
	        		
	        	}else if(action.equals("rm")) {
        			for(int j = 1; j < folder.length; j++) {
        				Node n = checkContais(array, folder[j]);
        				if(n != null) {
        					n.removeChildNode(folder[j]);
        				}
        			}
	        				
	        	}
	        }
	        return answer;
	    }
	  
	  public static Node checkContais(ArrayList<Node> array, String nodeName) {
		  Node ans = null;
		  
		  for(int i = 0; i < array.size(); i++) {
			  if(nodeName.equals(array.get(i).nodeName)) {
				  return array.get(i);
			  }
		  }
		  return ans;
	  
	  }
	  public static void main(String[] args) { 
		  String[] directory = {
								"/",
								"/hello",
								"/hello/tmp",
								"/root",
								"/root/abcd",
								"/root/abcd/etc",
								"/root/abcd/hello"
										  };
		  String[] command = {
								"mkdir /root/tmp",
								"cp /hello /root/tmp", 
								"rm /hello"
										  };
		  solution(directory, command);
	  }
}
