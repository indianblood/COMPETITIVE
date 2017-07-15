import java.io.* ;
public class KIRLAB 
{
	int n , a[] , touch[] , max ;
	int GCD(int a , int b)//used Euclid
	{
		if(b==0)
			return a ;
		else
			return GCD(b,a%b);
	}
	void inp()throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()) ;
		a = new int [n];
		touch = new int[n];
		String str = br.readLine();
		int x=0 , y=0 ;
		for(int i = 0 ; i < n ; i++)
		{
			touch[i]=0 ;
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
		}
		max=1 ;
	}
	void calc(int current , int len)
	{
		if(len>max)
		{
			max=len ;
		}			
		for(int i = (current+1);i<n;i++)
		{
			if(GCD(a[current],a[i]) >1)
			{
				touch[i]=1 ;
				calc(i,len+1);
			}
		}
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int j = 0; j< t ; j++)
		{
			KIRLAB obj = new KIRLAB();
			obj.inp();
			for(int i = 0 ; i< (obj.n-1) ; i++)
			{
				if(obj.touch[i]==0)
					obj.calc(i,1);
			}
			System.out.println(obj.max);			
		}
		
	}
	
}
