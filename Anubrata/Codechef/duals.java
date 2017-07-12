import java.io.* ;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class duals 
{
	
	public static void main(String args[])throws IOException
	{
		int k = 2000;
		boolean[] isPrime = new boolean[k+1];
	     for (int i = 2; i <= k; i++) 
	     {
	            isPrime[i] = true;
	     }
	     isPrime[0]=false;
	     isPrime[1]=false;
	     for (int factor = 2; factor*factor <= k; factor++) 
	     {
	    	 if (isPrime[factor]) 
	    	 {
	    		 for (int j = factor; factor*j <= k; j++) 
	             {
	                 isPrime[factor*j] = false;
	             }
	         }
	     }
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter pw = new PrintWriter(System.out);
	    int t  = Integer.parseInt(br.readLine());
	    for(int out = 0 ; out < t ; out++)
	    {
	    	int n = Integer.parseInt(br.readLine());
	    	ArrayList<Integer> a = new ArrayList<Integer>(n);
			String str = br.readLine();
			int x=0 , y=0 ;
			for(int i = 0 ; i < n ; i++)
			{
				if(i==0)
				{
					x = 0 ;
					y = str.indexOf(' ');
				}
				else if(i == (n-1))
				{
					x = str.lastIndexOf(' ')+1;
					y = str.length();
				}
				else
				{
					x = y+1 ;
					y = str.indexOf(' ' , x) ;
				}
				float temp = Float.parseFloat(str.substring(x,y));
				a.add((int)temp) ;
			}
			Collections.sort(a);
			int flag = 0 ;
			for(int i = n-1 ; i>= 0 ; i--)
			{
				if(a.get(i)>0)
				{
				if(isPrime[a.get(i)])
				{
					long prime = a.get(i)*a.get(i);
					pw.println(prime);
					flag++;
					break;
				}
				}
			}
			if(flag==0)
				pw.println("-1");
			
	    }
	   pw.flush();
	   pw.close();
	}
}
