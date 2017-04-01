import java.util.*;

public class ConvertFormat{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int number = in.nextInt();
		Stack<Integer> stack = new Stack<Integer>();
		String result = "";

		while(number != 0){
			stack.push(number % 10);
			number /= 10;
		}

		int tmp;
		while(stack.size() > 1){
			tmp = stack.pop();

			result += toString(stack.size()+1,tmp);
		}

		tmp = stack.pop();
		for(int i=1;i<=tmp;i++)
			result += Integer.toString(i);

		System.out.println(result);
	}

	public static String toString(int a,int times){
		if(a == 2)
			return extendString("S",times);

		return extendString("B",times);
	}

	public static String extendString(String str,int times){
		String result = "";
		for(int i=0;i<times;i++)
			result += str;

		return result;
	}
}