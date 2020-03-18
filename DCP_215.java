import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * print bottom view of a binary tree
 * 
 * @author xarvis
 *
 */


class Node {
	int data;
	Node left;
	Node right;
	int hd;
	public Node(int data) {
		this.data=data;
	}
	
}

public class DCP_215 {
	
	static Node node;
	
	public static void main(String[] args) {
		
		node = new Node(15);
		node.left = new Node(10);
		node.left.left = new Node(7);
		node.left.right = new Node(12);
		node.left.left.left = new Node(5);
		node.right = new Node(20);
		node.right.left = new Node(18);
		node.right.right = new Node(22);
		node.right.left.right = new Node(19);
		
		bottomView();
		
	}

	private static void bottomView() {
		if (node==null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		int hd=0;
		node.hd=hd;
		q.add(node);
		
		while (!q.isEmpty()) {
			Node qNode = q.remove();
			hd=qNode.hd;
			map.put(hd, qNode.data);
			
			if (qNode.left!=null) {
				qNode.left.hd=hd-1;
				q.add(qNode.left);				
			}
			if (qNode.right!=null) {
				qNode.right.hd=hd+1;
				q.add(qNode.right);
			}			
		}
		
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			System.out.print(entry.getValue()+" ");
		}
		
		
	}
	
	

}
