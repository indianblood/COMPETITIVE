import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class DIVMAC 
{
	boolean isPrime[] ;
	int lpd[] ;
	public DIVMAC()
	{
		 int n = (int)Math.pow(10, 6);
		 isPrime = new boolean[n+1];
		 lpd = new int[n+1];
	     for (int i = 0; i <= n; i++) 
	     {
	            isPrime[i] = true;
	            lpd[i] = i ;
	     }
	     for (int factor = 2; factor*factor <= n; factor++) 
	     {
	    	 if (isPrime[factor]) 
	    	 {
	    		 for (int j = factor; factor*j <= n; j++) 
	             {
	                 isPrime[factor*j] = false;
	                 if(lpd[factor*j]==(factor*j))
	                		 lpd[factor*j] = factor;
	             }
	         }
	     }
	}
	int LeastPrimeDivisor(int x)
	{
		return lpd[x];
	}
	
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		PrintWriter pw = new PrintWriter(System.out);
		DIVMAC obj = new DIVMAC();
		int t = Integer.parseInt(br.readLine());
		for(int out = 0 ; out < t ; out++)
		{
			String str = br.readLine();
			int n = Integer.parseInt(str.substring(0,str.indexOf(' ')));
			int m = Integer.parseInt(str.substring(str.indexOf(' ')+1));
			int a[] = new int[n];
			str = br.readLine();
			int ctr=0 ;
			for(int i = 0 ; i < str.length() ; i++)
			{
				char ch = str.charAt(i);
				if(ch==' ')
					ctr++;
				else
				{
					int x = Integer.parseInt(""+ch);
					a[ctr] = a[ctr]*10 + x ;
				}
			}
			for(int i = 0 ; i < m ; i++)
			{
				str = br.readLine();
				int type = Integer.parseInt(""+str.charAt(0));
				str = str.substring(2);
				int l = Integer.parseInt(str.substring(0,str.indexOf(' '))) - 1;
				int r = Integer.parseInt(str.substring(str.indexOf(' ')+1)) - 1;
				if(type==0)
				{
					for(int j = l ; j <=r ;j++)
					{
						a[j] = a[j] / obj.LeastPrimeDivisor(a[j]);
					}
				}
				else
				{
					int result = 1 ;
					for(int j = l ; j <= r ; j++)
					{
						result = Math.max(result , obj.LeastPrimeDivisor(a[j]));
					}
					pw.print(result+" ");
				}
			}
			pw.println();
		}
		pw.flush();
		pw.close();
	}
}

		

