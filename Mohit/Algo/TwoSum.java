import java.util.*;
import java.io.*;


class TwoSum
{
	public static void main(String args[]) throws IOException	, Exception	
	{
		BufferedReader in = new BufferedReader(new FileReader("sum.txt"));
		//Scanner in = new Scanner (System.in);
		long a[] = new long[1000000];
		HashMap<Long,Long> m = new HashMap<>();
		//int i = 0;
		for(int i = 0;i<1000000;i++)
		{
			a[i] = Long.parseLong(in.readLine());
			m.put(a[i],a[i]);
		}
		//Arrays.sort(a);
		int ctr = 0;
		HashMap<Long,ArrayList<Long>> pairs = new HashMap<>();
		for(long t = -10000; t<=10000 ; t++)
		{
			for(int i = 0;i<1000000;i++)
			{
				long y = t - a[i];
				if(m.containsKey(y))
				{
					ctr++;
					System.out.println(t+"  "+ctr);
					break;
				}
			}
		}
		System.out.println(ctr);
	}
}