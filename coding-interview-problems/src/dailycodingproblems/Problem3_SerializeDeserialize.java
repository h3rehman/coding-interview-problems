package dailycodingproblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.prefs.NodeChangeEvent;

/**
 * This problem was asked by Google.
 * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), 
 * which deserializes the string back into the tree.
 * 
 * @author RehmanH
 *
 */

public class Problem3_SerializeDeserialize {
	
	static Node head;
	
	static class Node {
		int val;
		Node left;
		Node right;
		
		Node (int v){
			this.val = v;
			left = null;
			right = null;
		}
	}
	
	/**
	 * Option 1: Level order traversal - (BFS) 
	 */
	
	static String levelOrderSerializer(Node node) {
		if (node == null) return null;
		
		Queue<Node> qu = new LinkedList<>();
		qu.add(node);
		Node top;
		Queue<Integer> quE = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
	
		while (!qu.isEmpty()) {
			if (!quE.isEmpty() && sb.length() == quE.peek()) {
				quE.poll();
				sb.append("#,");
			}
			else {
					top = qu.poll();
					sb.append(top.val);
					sb.append(",");
					if (top.left != null)
						qu.add(top.left);
					else quE.add((sb.length()-1)*2 + 1);
					if (top.right != null)
						qu.add(top.right);
					else quE.add((sb.length()-1)*2 + 2);
			}
		}
		return sb.toString();
	}
	
	static String serialize(Node node) {
		return levelOrderSerializer(node);
	}
	
	static Node deSerialize(String str) {
		if (str == null) return null;
		Node parent = new Node(Integer.parseInt("" + str.charAt(0)));
		Node node = parent;
		String[] strgs = str.split(",");
		int size = strgs.length;
		deSerializeHelper(node, 0, size, strgs);
		
		return parent;
	}
	
	static void deSerializeHelper(Node node, int i, int size, String[] strgs) {
		if (i*2 + 1 < size) {
			if (!strgs[i*2+1].equals("#")) {
			node.left = new Node(Integer.parseInt(strgs[i*2+1]));
			deSerializeHelper(node.left, i*2+1, size, strgs);
			}
		}
		if (i*2 + 2 < size) {
			if (!strgs[i*2+2].equals("#")) {
			node.right = new Node(Integer.parseInt(strgs[i*2+2]));
			deSerializeHelper(node.right, i*2+2, size, strgs);
			}
		}	
	}
	
	static void levelOrderTraversal(Node node) {
		Queue<Node> qu = new LinkedList<>();
		qu.add(node);
		Node curr;
		while (!qu.isEmpty()) {
			curr = qu.poll();
			System.out.print(curr.val + " ");
			if (curr.left != null)
				qu.add(curr.left);
			if (curr.right != null)
				qu.add(curr.right);
		}
		System.out.println();
	}

	
	/**
	 * Option 2: Pre-order traversal (DFS)
	 */
	
	static String serializePreOrder(Node head) {
		if (head != null) {
			Node node = head;
			StringBuffer sb = new StringBuffer();
			return preOrderSerializer(node, sb);
		}
		return null;
	}
	
	static String preOrderSerializer(Node node, StringBuffer sb) {
		if (node != null) {
			sb.append(node.val);
			sb.append(',');
			preOrderSerializer(node.left, sb);
			preOrderSerializer(node.right, sb);
		}
		else sb.append("#,");
		return sb.toString();
	}
	
	static Node deserializePreOrder(String str) {
		if (str != null) {
			Node parent = new Node(Integer.parseInt("" + str.charAt(0)));
			Node node = parent;
			String[] strgs = str.split(",");
			int size = strgs.length;
			preOrderDeserializer(node, strgs, size, 1);
			return parent;
		}
		return null;
	}
	
	static void preOrderDeserializer(Node node, String[] strgs, int size, int i) {
		if (i < size) {
				if (!strgs[i].equals("#")) {
				node.left = new Node(Integer.parseInt(strgs[i]));
				preOrderDeserializer(node.left, strgs, size, ++i);
				}
			else {
				while(i < size && strgs[i].equals("#")) 
					++i;
				if (i < size) {
					node.right = new Node(Integer.parseInt(strgs[i]));
					preOrderDeserializer(node.right, strgs, size, ++i);
				}
			}
		}
	}

	static void preOrderTraversal(Node node) {
		 if (node != null) {
			 System.out.print(node.val + " ");
			 preOrderTraversal(node.left);
			 preOrderTraversal(node.right);
		 }
	 }
	

	public static void main(String[] args) {
		/**
		 * Example binary tree, where '#' represents null values:
		 * 		7
		 * 	   / \
		 * 	  4   8
		 *   / \  / \
		 *  2  #  #  12
		 * / \		/ \
		 *#   #	   #   18
		 *			  /  \
		 *			 #    #
		 */
		
		Node node = new Node(7);
		node.left = new Node(4);
		node.left.left = new Node(2);
//		node.left.right = new Node(5);
		node.right = new Node(8);
//		node.right.left = new Node(6);
		node.right.right = new Node(12);
		node.right.right.right = new Node(18);
		head = node;
		
		System.out.println("Given tree in level order:");
		levelOrderTraversal(node);
		String serialized = serialize(node);
		System.out.println("Serialized String in level-order: " + serialized);
		Node nodeDeserialized = deSerialize(serialized);
		System.out.println("Deserialized tree in level order:");
		levelOrderTraversal(nodeDeserialized);		

		System.out.println();
		System.out.println("Given tree in pre-order:");
		preOrderTraversal(node);
		System.out.println();
		String serializedPO = serializePreOrder(node);
		System.out.println("Serialized String in pre-order: " + serializedPO);
		Node nodeDeserPreOrder = deserializePreOrder(serializedPO);
		System.out.println("Deserialized tree in pre-order:");
		preOrderTraversal(nodeDeserPreOrder);
				
	}

}
