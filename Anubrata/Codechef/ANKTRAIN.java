
import java.io.*;
public class ANKTRAIN 
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i<t ; i++)
		{
			int n = Integer.parseInt(br.readLine());
			int div = n/8 ;
			int rem = n%8 ;
			int ans = 0 ;
			String wd = "";
			switch(rem)
			{
				case 0:
					ans = (div*8)-1 ;
					wd = "SL" ;
					break ;
				case 1 :
					ans = (div*8)+4 ;
					wd = "LB" ;
					break ;
				case 2 :
					ans = (div*8)+5 ;
					wd = "MB" ;
					break ;
				case 3 :
					ans = (div*8)+6 ;
					wd = "UB" ;
					break ;
				case 4 :
					ans = (div*8)+1 ;
					wd = "LB" ;
					break ;
				case 5 :
					ans = (div*8)+2 ;
					wd = "MB" ;
					break;
				case 6 :
					ans = (div*8)+3 ;
					wd = "UB" ;
					break ;	
				case 7 :
					ans = (div*8)+8 ;
					wd = "SU";
					break ;
			}
			System.out.println(ans+wd);
		}
	}
}
