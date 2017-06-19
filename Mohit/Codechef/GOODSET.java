import java.util.*;
//import java.util.Collections;
 
class Demo
{    
	public static int nums[] = new int[100];
	public static HashMap<Integer,Integer> sums = new HashMap<>();
	public Demo()
	{
		nums[0] = 1;
		nums[1] = 2;
		sums.put((nums[0] + nums[1]),(nums[0] + nums[1]));
		int k = 2;
		for(int i = 3;i<=500 && k < nums.length;i++)
		{
			if(!sums.containsKey(i))
			{
				nums[k] = i;
				int l = k-1;
				while(l>=0)
				{
					int sum = i+nums[l];
					sums.put(sum,sum);
					l--;
				}
				k++;
			}	
		}
	}
	public static void main(String args[]) //throws IOException,NumberFormatException
	{
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		Demo d = new Demo();
		for(int m =0 ; m<t ; m++)
		{
			int n = Integer.parseInt(sc.nextLine());
			for(int i = 0;i<n;i++)
			{
				System.out.print(nums[i]+"\t");
			}
			System.out.println();
		}
	}
} 
