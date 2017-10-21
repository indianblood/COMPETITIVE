import java.io.*;
public class LONGSEQ 
{
	static boolean check(String str)
	{
		int one=0 , zero=0 ;
		for(int i = 0 ; i < str.length() ; i++)
		{
			if(str.charAt(i)=='1')
			{
				one++;
			}
			else 
			{
				zero++;
			}
			if((one>1)&&(zero>1))
			{
				break;
			}
		}
		if((zero==1)||(one==1))
			return true ;
		else
			return false ;
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < t ; i++)
		{
			String str = br.readLine();
			if(check(str))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
