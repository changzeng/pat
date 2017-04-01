import java.util.*;

public class ArrayShift{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int length=in.nextInt();
		int offset = in.nextInt() % length;

		int[] array = new int[length];
		for(int i=0;i<length;i++)
			array[i] = in.nextInt();

		if(length > 1){
			reverse(array,0,length-1-offset);
			reverse(array,length-offset,length-1);
			reverse(array,0,length-1);
		}

		for(int i=0;i<length-1;i++)
			System.out.print(Integer.toString(array[i])+" ");
		System.out.println(array[length-1]);
	}

	public static void reverse(int[] array,int left,int right){
		int tmp;
		while(right > left){
			tmp = array[right];
			array[right] = array[left];
			array[left] = tmp;

			left++;
			right--;
		}
	}
}