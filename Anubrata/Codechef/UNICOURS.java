import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UNICOURS {

	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int cases = 0 ;cases<t;cases++)
		{
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
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
				a[i] = Integer.parseInt(str.substring(x,y)) ;
			}
			int max = 0 , ctr=0; 
			for(int i=0;i<n;i++)
				if(a[i]>max)
					max=a[i] ;
			/*for(int i=0;i<n;i++)
				if(a[i]==max)
					ctr++;*/
			ctr = n-max ;
			System.out.println(ctr);
		}
	}
}
