import java.util.*;

public class SpeakReversely{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		String text = in.nextLine();

		String[] list = text.split(" ");
		String tmp;

		int left=0,right=list.length-1;
		while(right > left){
			tmp = list[left];
			list[left] = list[right];
			list[right] = tmp;

			left++;
			right--;
		}

		String result = "";
		for(int i=0;i<list.length-1;i++)
			result += list[i] + " ";
		result += list[list.length-1];
		System.out.println(result);
	}
}