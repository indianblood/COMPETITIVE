//used simple sieve
// https://www.codechef.com/problems/NUMFACT/
import java.io.*;
import java.util.*;
 
class factors
{
	public static ArrayList<Integer> p = new ArrayList<>();
	public static boolean preflag[] = new boolean[1000001]; 
	public static int maxAccessed = 0;
	public static void primes()
	{
		int n = 1000000;
	    for(int i = 0 ; i < n ; i++)
		{
			preflag[i] = true ;
		}
		preflag[0] = false ;
		preflag[1] = false ;
		for (int factor = 2; factor*factor <= n; factor++) 
	     {
	    	 if (preflag[factor]) 
	    	 {
	    		 for (int j = factor; factor*j <= n; j++) 
	             {
	                 preflag[factor*j] = false;
	             }
	         }
	     }
		for (int i = 2; i <= n; i++) 
	     {
	            if (preflag[i])
	            	p.add(i);
	     }
	}
	
	public static void function(int a, int pow[])
	{
		for(int i =0;i<p.size();i++)
		{
			int tmp = p.get(i);
			if(i>maxAccessed)
				maxAccessed = i;
			int count = 0;
			if(tmp>a)
				break;
			while(a%tmp == 0 && a > 0)
			{
				a = a/tmp;
				count++;
			}
			pow[i] += count;
		}
	}
	
	public static void main(String args[]) throws IOException , NumberFormatException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		primes();
		for(int x =0;x<t;x++)
		{
			int m = Integer.parseInt(br.readLine());
			//long prod = 1;
			String str = br.readLine();
			String st[] = str.split(" ");
			int a[] = new int[m];
			for(int j=0;j<m;j++)
				a[j] = Integer.parseInt(st[j]);
			int powers[] = new int[p.size()];
			for(int j=0;j<m;j++)
			{
				function(a[j],powers);
			}
			int res = 1;
			for(int i=0;i<maxAccessed;i++)
			{
				int tmp = powers[i]+1;
				res *= tmp;
			}
			System.out.println(res);
		}
	}
} 
