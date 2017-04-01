import java.util.*;

public class GradeRank{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int count = in.nextInt();
		int min_grade=100,max_grade=0,grade;
		String min_name="",max_name="",min_number="",max_number="",name,number;
		for(int i=0;i<count;i++){
			name = in.next();
			number = in.next();
			grade = in.nextInt();

			if(grade > max_grade){
				max_grade = grade;
				max_name = name;
				max_number = number;
			}
			if(grade < min_grade){
				min_grade = grade;
				min_name = name;
				min_number = number;
			}
		}

		System.out.println(max_name+" "+max_number);
		System.out.println(min_name+" "+min_number);
	}
}