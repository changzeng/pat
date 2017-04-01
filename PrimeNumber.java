import java.util.*;

public class PrimeNumber{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int number = in.nextInt();

		boolean[] sieve = new boolean[number+1];
		for(int i=0;i<number+1;i++)
			sieve[i] = true;

		int tmp;
		for(int i=2;i<number+1;i++){
			if(sieve[i] == true){
				tmp = i + i;
				while(tmp <= number){
					sieve[tmp] = false;
					tmp += i;
				}
			}
		}

		int count = 0;
		for(int i=2;i<=number-2;i++)
			if(sieve[i] == true && sieve[i+2] == true)
				count++;

		System.out.println(count);
	}
}