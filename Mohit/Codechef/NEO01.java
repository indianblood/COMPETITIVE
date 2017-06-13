import java.io.*;
import java.util.*;
 
//import java.util.Collections;
 
class Demo
{
	public static void main(String args[]) throws IOException,NumberFormatException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		long a[] = new long[100000];
		while(t-- > 0)
		{
			int n = Integer.parseInt(br.readLine());
			String st = br.readLine();
			String ip[] = st.split(" ");
			for(int i=0;i<n;i++)
				a[i] = Long.parseLong(ip[i]);
			Arrays.sort(a,0,n);
			int first = 0,last = n-1;
			int mid = (first+last)/2;
			while(first<=last)
			{
				if(a[mid] < 0)
					first = mid+1;
				else 
					last = mid-1;
				mid = (first+last)/2;
			}
			
			int pos = first;
			//System.out.println(pos);
			long initialSum = 0;
			//int i = 0;
			long mul =(long) (n-pos);
			long posSum= 0;
			//System.out.println(mul);
			for(int i=pos;i<n;i++)
			{
				initialSum += (a[i]*mul);
				posSum += a[i];
			}
		    long negSum = 0;
		    boolean flag = true;
		   // long sum = initialSum;
		    long currSum = initialSum;
		    long prevSum = initialSum;
		    int i = pos-1;
			for( i=pos-1;i>=0;i--)
			{
			    negSum += a[i];
			    mul++;
			    //System.out.println(currSum);
			    prevSum = currSum;
			    currSum = initialSum + (pos-i)*posSum + negSum*mul;
			    if(prevSum > currSum)
			    {
			        currSum = prevSum;
			        break;
			    }
			}
			while(i>=0)
			{
			    currSum+=a[i];
			    i--;
			}
			System.out.println(currSum);
		}
	}
}   
