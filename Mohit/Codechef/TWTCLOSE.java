import java.util.*;
import java.math.*;
 
class Demo
{
    
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String ip[] = str.split(" ");
		int n = Integer.parseInt(ip[0]);
		int q = Integer.parseInt(ip[1]);
		int total = 0;
		boolean f[] = new boolean[n];
		for(int x = 0;x<q;x++)
		{
		    String s = sc.nextLine();
		    String inp[] = s.split(" ");
		    if(inp[0].equals("CLICK"))
		    {
		       // System.out.println("if");
		        int i = Integer.parseInt(inp[1]);
		        if(f[i-1]){
		            total--;}
		        else{
		           total++;}
		        f[i-1] = !f[i-1];
		        //for(int j = 0;j<n;j++)
		        //System.out.println(f[j]?1:0);
		    }
		    else
		    {
		        f = new boolean[n];
		        total = 0;
		    }
		    System.out.println(total);
		}
	}
} 
