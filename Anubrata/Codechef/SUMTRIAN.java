
import java.io.* ;
public class SUMTRIAN 
{
	/*int  sum(int a[][] , int x , int y)
	{
		
		if(x == (a[0].length-1))
		{
			return a[x][y] ;
		}
		else
		{
			return a[x][y]+Math.max(sum(a,x+1,y),sum(a,x+1,y+1));
		}
	}*/
	static int sum(int a[][] , int n)
	{
		int b[][] = new int[n][n];
		for(int i = n-1 ; i >=0 ; i--)
		{
			for(int j = 0 ; j <= i ; j++)
			{
				if(i==(n-1))
				{
					b[i][j] = a[i][j];
				}
				else
				{
					b[i][j] = a[i][j] + Math.max(b[i+1][j] , b[i+1][j+1]);
				}
				//System.out.println("i = "+i+" j = "+j+"val = "+b[i][j]+"\t");
			}
			//System.out.println();
		}
		return b[0][0] ;
	}
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int out = 0 ; out < t ; out++)
		{
			int n = Integer.parseInt(br.readLine());
			int arr[][] = new int[n][n] ;
			for(int i =  0 ; i < n ; i++)
			{
				String str = br.readLine()+' ';
				int x=0 , y=0 ;
				for(int j = 0 ; j <= i ; j++)
				{
					if(j==0)
					{
						x = 0 ;
						y = str.indexOf(' ');
					}
					else
					{
						x = y+1 ;
						y = str.indexOf(' ' , x) ;
					}
					arr[i][j] = Integer.parseInt(str.substring(x,y)) ;
					//System.out.print(arr[i][j]+"\t");
				}
				//System.out.println();
			}
			int ans = sum(arr,n);
			System.out.println(ans);
		}
	}
}
