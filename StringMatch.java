import java.util.*;
import java.util.regex.*;

public class StringMatch{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		Pattern pattern = Pattern.compile("(A*)P(A+)T(A*)");

		int count = in.nextInt();
		String[] strs = new String[count];
		for(int i=0;i<count;i++)
			strs[i] = in.next();

		boolean tmp;
		Matcher matcher;
		int s_1,e_1,s_2,e_2,s_3,e_3;
		for(int i=0;i<count;i++){
			matcher = pattern.matcher(strs[i]);

			if(matcher.matches()){
				s_1 = matcher.start(1);
				s_2 = matcher.start(2);
				s_3 = matcher.start(3);

				e_1 = matcher.end(1);
				e_2 = matcher.end(2);
				e_3 = matcher.end(3);

				if(e_1 - s_1 == e_3 - s_3 && e_2 - s_2 == 1)
					System.out.println("YES");
				else if(e_2 - s_2 != 1 && (e_2 - s_2)*(e_1 - s_1) == (e_3 - s_3))
					System.out.println("YES");
				else
					System.out.println("NO");
			}else
				System.out.println("NO");
		}
	}
}