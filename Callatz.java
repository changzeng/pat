import java.util.*;

public class Callatz{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int count = in.nextInt();
		int num;
		Collection<Integer> set = new ArrayList<Integer>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for(int i=0;i<count;i++){
			num = in.nextInt();

			if(!set.contains(num))
				tmp.add(num);

			while(!set.contains(num)){
				set.add(num);
				if(num % 2 == 0)
					num = num/2;
				else
					num = (3*num + 1)/2;
			}
		}

		set.clear();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=tmp.size()-1;i>=0;i--){
			num = tmp.get(i);

			if(!set.contains(num))
				result.add(num);

			while(!set.contains(num)){
				set.add(num);
				if(num % 2 == 0)
					num = num/2;
				else
					num = (3*num + 1)/2;
			}
		}

		Collections.sort(result,Collections.reverseOrder());

		int i;
		for(i=0;i<result.size()-1;i++)
			System.out.print(result.get(i).toString()+" ");
	
		System.out.println(result.get(i));
	}
}