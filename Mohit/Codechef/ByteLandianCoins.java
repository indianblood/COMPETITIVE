//Dynamic programming implementation

import java.io.*;
class coins_2
{
	long a[];
	public coins_2(int x)
	{
		int k = (int)Math.min(x+1,1000000) ;
		a = new long[k];
		a[0] = 0 ;
		a[1] = 1 ;
		for(int i = 0 ; i < k ; i++)
		{
			a[i] = Math.max(i, a[(int)(i/2)]+a[(int)(i/3)]+a[(int)(i/4)]);
		}
		
	}
	long recBreak(int n)
	{
		if(n<1000000)
			return ( a[(int)n] ) ;
		else
			return Math.max(n , recBreak((int)(n/2))+recBreak((int)(n/3))+recBreak((int)(n/4)))	;
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str ; 
		int ctr=0 ,max=0; 
		int b[] = new int[10] ;
		while(((str=br.readLine())!=null)&&(ctr<=9))
		{
			b[ctr] =Integer.parseInt(str);
			if(b[ctr] > max)
				max = b[ctr] ;	
			ctr++;
			
		}
		coins_2 obj = new coins_2(max);
		for(int i = 0 ; i < ctr ; i++)
		{
			long y = obj.recBreak((int)b[i]);
			System.out.println(y);
		}
	}
}
