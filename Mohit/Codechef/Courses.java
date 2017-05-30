import java.util.*;
 
class courses
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int x = 0 ; x<t ;x++)
		{
			int n = sc.nextInt();
			if(n==1)
			{
				System.out.println(1);
				continue;
			}
			int a[] = new int[n];
			int max = 0;
			for (int i=0;i<n;i++)
			{
				a[i] = sc.nextInt();
				if (max<=a[i])
				    max = a[i];
			}
			System.out.println(n-max);
		}
		
	}
} 
