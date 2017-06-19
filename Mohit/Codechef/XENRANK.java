import java.util.*;
//import java.util.Collections;
 
class Demo
{
	public static void main(String args[]) //throws IOException,NumberFormatException
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int m =0 ; m<t ; m++)
		{
			long u = sc.nextLong();
			long v = sc.nextLong();
			long n = u+v;
			long val =((long) (n*(n+1))/2) + u + 1 ;
			System.out.println(val);
		}
	}
} 
