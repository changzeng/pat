import java.util.*;

public class RecommendationSystem{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int q_number = in.nextInt();
		int r_number = in.nextInt();
		int[][] result = new int[q_number-1][r_number+2];

		SortedSet<Node> set = new TreeSet<Node>();
		HashMap<Integer,Node> map = new HashMap<Integer,Node>();

		int input = in.nextInt();
		Node tmp = new Node(input);

		map.put(input,tmp);
		set.add(tmp);

		Iterator it;

		for(int i=0;i<q_number-1;i++){
			input = in.nextInt();

			it = set.iterator();
			int j;
			for(j=1;j<=r_number&&it.hasNext();j++){
				tmp = (Node)it.next();
				result[i][j] = tmp.value;
			}
			result[i][0] = j-1;
			result[i][r_number+1] = input;

			tmp = map.get(input);
			if(tmp == null){
				tmp = new Node(input);
				map.put(input,tmp);
			}else{
				set.remove(tmp);
				tmp.count += 1;
			}

			set.add(tmp);
		}

		for(int i=0;i<q_number-1;i++){
			System.out.print(Integer.toString(result[i][r_number+1])+":");
			for(int j=1;j<=result[i][0];j++){
				System.out.print(" "+Integer.toString(result[i][j]));
			}
			System.out.println();
		}
	}
}

class Node implements Comparable{
	public int value;
	public int count;

	public Node(int value){
		this.value = value;
		this.count = 1;
	}

	@Override
	public int compareTo(Object o){
		Node d = (Node)o;

		if(this.count != d.count){
			return d.count - this.count;
		}else{
			return this.value - d.value;
		}
	}
}