package codechef;
import java.io.*;
import java.util.HashSet;
public class LIKECS01 {
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			String str = br.readLine();
			HashSet<Character> ch = new HashSet<Character>();
			boolean flag = true ;
			for(int i = 0 ; i< str.length(); i++)
			{
				char x = str.charAt(i);
				if(ch.contains(x))
				{
					flag = false ;
					break ;
				}
				else
				{
					ch.add(x);
				}
			}
			if(!flag)
			{
				System.out.println("yes");
			}
			else
			{
				System.out.println("no");
			}
		}
	}
}