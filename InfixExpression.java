import java.util.*;

public class InfixExpression{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int count = in.nextInt();
		int left,right;
		String value;

		Node[] nodes = new Node[count+1];
		boolean[] is_root = new boolean[count+1];

		for(int i=1;i<=count;i++)
			is_root[i] = true;

		for(int i=1;i<=count;i++){
			value = in.next();
			left = in.nextInt();
			right = in.nextInt();

			nodes[i] = new Node(value,left,right);

			if(left != -1)
				is_root[left] = false;

			if(right != -1)
				is_root[right] = false;
		}

		int root=1;
		while(!is_root[root++]);

		root--;

		System.out.println(output(nodes,root));
	}

	public static String output(Node[] nodes,int i){
		if(i == -1)
			return "";

		Node node = nodes[i];

		String left = output(nodes,nodes[i].left);
		String right = output(nodes,nodes[i].right);

		if(node.hasLeftGrandSon(nodes))
			left = "(" + left + ")";

		if(node.hasRightGrandSon(nodes))
			right = "(" + right + ")";

		return left + node.value + right;
	}
}

class Node{
	public int left,right;
	String value;

	public Node(String value,int left,int right){
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public boolean hasSon(){
		return this.left != -1 || this.right != -1;
	}

	public boolean hasLeftGrandSon(Node[] nodes){
		if(this.left != -1)
			if(nodes[this.left].hasSon())
				return true;

		return false;
	}

	public boolean hasRightGrandSon(Node[] nodes){
		if(this.right != -1)
			if(nodes[this.right].hasSon())
				return true;

		return false;
	}
}