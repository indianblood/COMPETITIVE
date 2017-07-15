import java.io.*;
public class LEXOPAL 
{
	static StringBuffer convert(StringBuffer str)
	{
		for(int i = 0 ; i < str.length() ; i++)
		{
			char ch = str.charAt(i);
			char ch2 = str.charAt(Math.abs(str.length()-i-1));
			if(ch!=ch2)
			{
				if(ch=='.')
					str.setCharAt(i,ch2);
				else if(ch2=='.')
					str.setCharAt(Math.abs(str.length()-i-1), ch);
				else if(ch2!='.')
				{
					str=new StringBuffer("-1");
					break;
				}
			}
			else
			{
				if(ch=='.')
				{
					str.setCharAt(i,'a');
					str.setCharAt(Math.abs(str.length()-i-1), 'a');
				}
				
			}
		}
		return str ;
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < t ; i++)
		{
			String str = br.readLine();
			StringBuffer in = new StringBuffer(str);
			System.out.println(convert(in));
		}
	}
}
