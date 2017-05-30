import java.util.*;
import java.math.*;
 
class MXMEDIAN
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int x = 0; x<t ; x++)
		{
		    int n = sc.nextInt();
		    int a[] = new int[2*n];
		    for(int i=0;i<2*n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
			Arrays.sort(a);
		    int tmp[] = new int[2*n];
		    int j = 0;
		    for(int i=0;i<2*n;i+=2)
		    {    tmp[i] = a[j]; j++;}
		    for(int i=1;i<2*n;i+=2)
		    {    tmp[i] = a[j]; j++;}
		    //int b[] = new int[n];
		    System.out.println(tmp[n]);
		    for(int i=0;i<2*n;i++)
		        System.out.print(tmp[i]+" ");
		    System.out.println();
		}
	}
}
