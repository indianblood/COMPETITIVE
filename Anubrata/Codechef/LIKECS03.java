package codechef;
import java.io.*;
import java.util.HashSet;
public class LIKECS03 {

	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int ctr = 0 ;
			HashSet<Integer> powers = new HashSet<Integer>();
			String str[] = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			str = br.readLine().split(" ");
			for(int i = 0 ; i < n ; i++)
			{
				int x = Integer.parseInt(str[i]);
				if((x!=0)&&((x&x-1)==0)&&(!powers.contains(x)))
				{
					powers.add(x);
					ctr++ ;
				}
			}
			System.out.println(k-ctr);
		}
	}
}
