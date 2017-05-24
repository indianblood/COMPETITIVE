import java.util.HashMap;
import java.util.Scanner;

public class Suffix_Array_Optimized 
{
	static class Suffix_Array
	{
		public String str ;
		public String suff[] ;
		public int sortPos[] ;
		//public int rank[] ;
		//public HashMap<String,Integer> sortIdx; 
		public int tuple[][];
		public int n ;
		public Suffix_Array(String s)
		{
			str = s ;
			n = s.length();
			suff = new String[n];
			sortPos = new int[n];
			//rank = new int[n];
			//sortIdx = new HashMap<String,Integer>(); 
			tuple = new int[n][2];
			for(int i = (n-1) ; i>= 0 ; i--)
			{
				tuple[i][0] = str.charAt(i)-'a' ;
				if(i==(n-1))
				{
					suff[i] = str.charAt(i)+"";
					tuple[i][1] = -1 ;
				}
				else
				{
					suff[i] = str.charAt(i)+suff[(i+1)];
					tuple[i][1] = str.charAt(i+1)-'a' ;
				}
				sortPos[i] = i ;
			}
			create(1);
		}
		void create(int level)
		{
			int len = (int)Math.pow(2, level);
			if(len<n)
			{
				sort(0,n-1);
				int temp = 0 ;
				for(int i = 0 ;i<n;i++)
				{
					if(i==0)
					{
						temp = tuple[sortPos[i]][0]*100 + tuple[sortPos[i]][1];
						tuple[sortPos[i]][0] = 0 ;
					}
					else
					{
						int temp1 = tuple[sortPos[i]][0]*100 + tuple[sortPos[i]][1];
						if(temp1==temp)
						{
							tuple[sortPos[i]][0] = tuple[sortPos[i-1]][0];
						}
						else
						{
							tuple[sortPos[i]][0] = tuple[sortPos[i-1]][0]+1;
						}
						temp=temp1 ;
					}
				}
				for(int i = 0 ;i<n;i++)
				{
					if(sortPos[i]+len<n)
						tuple[sortPos[i]][1] = tuple[sortPos[i]+len][0];
					else
						tuple[i][1] = -1 ;
				}
				/*System.out.println("LEN = "+len);
				for(int i = 0 ; i<n ;i++)
				{
					System.out.println("sortPos[ "+i+" ] = "+suff[sortPos[i]]+" hash : "+tuple[sortPos[i]][0]+" next = "+tuple[sortPos[i]][1]);
				}*/
				
				create(level+1);
			}
		}
		int partition(int low, int high)
	    {
	        int pivot = sortPos[high]; 
	        int i = (low-1); // index of smaller element
	        for (int j=low; j<=high; j++)
	        {
	            if (tuple[sortPos[j]][0]*100+tuple[sortPos[j]][1] < tuple[pivot][0]*100+tuple[pivot][1])
	        	//if (suff[sortPos[j]].compareTo(suff[pivot])<0)
	            {
	                i++;
	                int temp = sortPos[i];
	                sortPos[i] = sortPos[j];
	                sortPos[j] = temp;
	            }
	        }
	        int temp = sortPos[i+1];
	        sortPos[i+1] = sortPos[high];
	        sortPos[high] = temp;
	 
	        return i+1;
	    }
		void sort(int low, int high)
	    {
	        if (low < high)
	        {
	            int pi = partition(low, high);
	            sort(low, pi-1);
	            sort(pi+1, high);
	        }
	    }
		void display()
		{
			for(int i = 0 ; i<n ;i++)
			{
				System.out.println("StartPos = "+sortPos[i]+" SortIdx = "+tuple[sortPos[i]][0]+" Suffix : "+suff[sortPos[i]]);
			}
		}
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string : ");
		String str = sc.nextLine();
		Suffix_Array obj = new Suffix_Array(str);
		obj.display();
	}
}
