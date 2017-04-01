import java.util.*;

public class NQueueProblem{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int row_count = in.nextInt();
		String[] result = new String[row_count];

		Collection<Integer> row = new ArrayList<Integer>();
		Collection<Integer> diagonal1 = new ArrayList<Integer>();
		Collection<Integer> diagonal2 = new ArrayList<Integer>();

		int d1,d2,j,r,N;
		for(int i=0;i<row_count;i++){
			N = in.nextInt();

			row.clear();
			diagonal1.clear();
			diagonal2.clear();

			result[i] = "YES";

			for(j=0;j<N;j++){
				r = in.nextInt();

				if(result[i].equals("NO"))
					continue;

				d1 = j+1 - r;
				d2 = r - (j+1);
				if(!diagonal1.contains(d1) && !row.contains(r) && !diagonal2.contains(d2)){
					diagonal1.add(d1);
					diagonal2.add(d2);
					row.add(r);
				}else
					result[i] = "NO";
			}
		}

		for(int i=0;i<row_count;i++)
			System.out.println(result[i]);
	}
}