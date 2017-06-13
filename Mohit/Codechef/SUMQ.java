import java.util.*;
import java.io.*;
//import java.util.Collections;
 
class Demo
{
	public static long MOD = 1000000007;
	public static int r;
	public static int p;
	
	public static int findIndex(long v[],long val,int l,int h)
	{
		int first = l,last=h-1;
		
		int middle=(first+last)/2;
	    while(first<=last){
 
		if(v[middle]<=val){
 
			first=middle+1;
 
		}
 
		else if(v[middle]>val){
 
			last=middle-1;
 
		}
 
		middle=(first+last)/2;
 
	}
 
	return first;
	}
	public static void main(String args[]) throws IOException,NumberFormatException
	{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(sc.readLine());
		long a[] = new long[100000];
		long sumx[] = new long[100000];
		long b[] = new long[100000];
		long c[] = new long[100000];
		long sumz[] = new long[100000];
		for(int m =0 ; m<t ; m++)
		{
		    String ip = sc.readLine();
		    String ips[] = ip.split(" ");
		    p = Integer.parseInt(ips[0]);
			int q = Integer.parseInt(ips[1]);
			r = Integer.parseInt(ips[2]);
			
			ip = sc.readLine();
			String str[] = ip.split(" ");
			for(int i = 0;i<p;i++)
			{
				a[i] = Long.parseLong(str[i]); 
				
			}
			ip = sc.readLine();
			String ss[] = ip.split(" ");
			for(int g =0;g<q;g++)
			{
				b[g] = Long.parseLong(ss[g]); 
			}
			ip = sc.readLine();
			String st[] = ip.split(" ");
			for(int d=0;d<r;d++)
				c[d] = Long.parseLong(st[d]); 
			Arrays.sort(a,0,p);
			Arrays.sort(c,0,r);
			/*for(int i=0;i<p;i++)
			    System.out.println(a[i]);
			for(int i=0;i<q;i++)
			    System.out.println(b[i]);
			for(int i=0;i<r;i++)
			    System.out.println(c[i]);*/
			long sum = 0;
			for(int i = 0;i<p;i++)
			{
			    sum=(sum+a[i])%MOD;
			    //sum  = sum%MOD;
			    sumx[i] = sum;
			}
			sum = 0;
			for(int g =0;g<r;g++)
			{
			    sum = (sum + c[g])%MOD;
			   // sum  = sum%MOD;
				sumz[g] = sum;
			}
		    sum = 0;
			for(int j=0;j<q;j++)
			{
				long y = b[j];
			    int in1 = findIndex(a,y,0,p);
			    int in2 = findIndex(c,y,0,r);
			    //System.out.println(in1 + "   "+in2 );
				
				if(in1!=0 && in2!=0){
    long i1 =(long) in1,i2 =(long) in2;
				sum=( sum+ (( ((b[j]*b[j])%MOD) * ((i1*i2)%MOD)) %MOD) + (( ((i2*b[j])%MOD) * sumx[in1-1])%MOD) + (( ((i1*b[j])%MOD)  *sumz[in2-1])%MOD) + ((sumx[in1-1]*sumz[in2-1])%MOD) )%MOD;
 
			}
			    
			}
			System.out.println(sum);
		}
	}
}   
