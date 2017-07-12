import java.io.*;
 
public class CHEFSUBA {
	static int a[] , n , k , p ;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static void oneInt(String str)throws IOException
	{
		a[0] = Integer.parseInt(str);
	}
	static void twoInt(String str)throws IOException
	{
		a[0] = Integer.parseInt(str.substring(0,str.indexOf(' ')));
		a[1] = Integer.parseInt(str.substring(str.indexOf(' ')+1));
	}
	static void moreInt(String str ,int n)throws IOException
	{
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
			a[i] = Integer.parseInt(str.substring(x,y)) ;
			//System.out.println(a[i]);
		}
	}
	static void shift()
	{
		int temp = a[(n-1)] , t1 ;
		for(int i = 0 ; i < n ; i++)
		{
				t1 = a[i] ;
				a[i] = temp ;
				temp = t1 ;
		}
	}
	static int max()
	{
		int maxi = 0 , curr=0;
		for(int i = k-1;i<n;i++)
		{
			int x = 0 ;
			if(i==k-1)
			{
				for(int j = 0 ; j < k;j++)
					x+=a[j];
				maxi = x ;
				curr = x ;
			}
			else
			{
				curr = curr + a[i] - a[(i-k)];
				if(curr>maxi)
					maxi = curr ;
			}
				
		}
		return maxi ;
	}
	public static void main(String args[])throws IOException
	{
		PrintWriter pw = new PrintWriter(System.out);
		String str = br.readLine();
		n = Integer.parseInt(str.substring(0,str.indexOf(' ')));
		k = Integer.parseInt(str.substring(str.indexOf(' ')+1 , str.lastIndexOf(' ')));
		p = Integer.parseInt(str.substring(str.lastIndexOf(' ')+1));
		//System.out.println(n+" "+k+" "+p);
		a = new int[n] ; 
		str = br.readLine();
		
		if(n==1)
			oneInt(str);
		else if(n==2)
			twoInt(str);
		else
			moreInt(str,n);
		
		String q = br.readLine();
		//System.out.println("Q="+query);
		for(int i = 0 ; i < p; i++)
		{
			if(q.charAt(i) =='?' )
				pw.println(max());
			else
				shift();
		}
		pw.flush();
		pw.close();
	}
}
