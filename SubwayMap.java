import java.util.*;

public class SubwayMap{

	public static HashMap<Integer,ArrayList<Integer>> adjacence = new HashMap<Integer,ArrayList<Integer>>();;
	public static HashMap<Integer,Boolean> visited = new HashMap<Integer,Boolean>();
	public static ArrayList<Integer> path = new ArrayList<Integer>();
	public static HashMap<Edge,Integer> lines = new HashMap<Edge,Integer>();

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int line_count = in.nextInt();
		int stop_count,pre_node,cur_node;

		Edge edge;
		ArrayList<Integer> list;

		for(int i=1;i<=line_count;i++){
			stop_count = in.nextInt();
			pre_node = -1;
			list = new ArrayList<Integer>();
			for(int j=0;j<stop_count;j++){
				cur_node = in.nextInt();

				list = adjacence.get(cur_node);
				if(list == null){
					list = new ArrayList<Integer>();
					adjacence.put(cur_node,list);
				}

				if(pre_node == -1){
					pre_node = cur_node;
					continue;
				}

				list.add(pre_node);
				list = adjacence.get(pre_node);
				list.add(cur_node);

				edge = new Edge(pre_node,cur_node);
				lines.put(edge,i);
			}
		}
	}

	public static void DFS(int start,int end,int depth){
		ArrayList<Integer> tmp = adjacence.get(start);
		Integer next;

		for(int i=0;i<tmp.size();i++){
			next = tmp.get(i);
			path.add(next);

		}
	}
}

class Edge{
	public Integer start,end;

	public Edge(int start,int end){
		this.start = start;
		this.end = end;
	}

	@Override
	public int hashCode(){
		return this.start.hashCode() + this.end.hashCode();
	}
}