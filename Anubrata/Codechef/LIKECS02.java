package codechef;
import java.io.* ;
public class LIKECS02 {

	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
			int ctr = 0 ;
			int n = Integer.parseInt(br.readLine());
			
			double mean=0 , sum=0 ;
			for(int i = 1 ; i<= n ; i++)
			{
				for(int j = i ; j<= n ; j++)
				{
					sum+= (i+j)/2.0 ;
					
					ctr++ ;
				}
			}
			//System.out.println(sum);
			mean = sum/ctr ;
			//System.out.println(mean);
			if(mean > (n+1))
			{
				System.out.println(-1);
			}
			else if((mean >((n-1)*1.0))||((n-1)-mean < 0.01))
			{
				String str = "" ;
				for(int i = 1 ; i<= n ; i++)
				{
					str+=(i+" ");
				}
				System.out.println(str.trim());
			}
			else
			{
				int x = (int)(Math.ceil((n-1)-mean));
				String str = "" ;
				for(int i = 1 ; i<= n ; i++)
				{
					str+=((i+x)+" ");
				}
				System.out.println(str.trim());
			}
			
		}
	}

}
