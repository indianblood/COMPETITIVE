
//https://www.codechef.com/problems/LEPERMUT
import java.io.*;
import java.util.Scanner ;
public class LEPERMUT {
	static void check(int a[] , int n)
	{
		int inv=0 , locInv=0 ;
		for(int i = 0 ; i < (n-1) ; i++)
		{
			if(a[i] > a[(i+1)])
			{
				locInv++ ; 		//Checking local inversion
			}
			for(int j = i+1 ; j < n ; j++)		
			{
				if(a[i]>a[j])
				{
					inv++ ;		//Checking inversions
				}
			}
		}
		if(inv==locInv)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	public static void main(String args[])throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0 ; i < t ; i++)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int j = 0 ; j < n ; j++)
			{
				a[j]=sc.nextInt();
			}
			check(a,n);
		}
	}

}
