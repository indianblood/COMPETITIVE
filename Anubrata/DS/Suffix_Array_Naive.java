import java.util.Scanner; 
public class Suffix_Array_Naive 
{
	static class Suffix_Array
	{
		public String str ;
		public String suff[] ;
		public int pos[] ;
		public int n ;
		public Suffix_Array(String s)
		{
			str = s ;
			n = s.length();
			suff = new String[n];
			pos = new int[n];
			for(int i = (n-1) ; i>= 0 ; i--)
			{
				if(i==(n-1))
				{
					suff[i] = str.charAt(i)+"";
				}
				else
				{
					suff[i] = str.charAt(i)+suff[(i+1)];
				}
				pos[i] = i ;
			}
			sort(0,n-1);
		}
		int partition(int low, int high)
	    {
	        int pivot = pos[high]; 
	        int i = (low-1); // index of smaller element
	        for (int j=low; j<=high; j++)
	        {
	            if (suff[pos[j]].compareTo(suff[pivot])<0)
	            {
	                i++;
	                int temp = pos[i];
	                pos[i] = pos[j];
	                pos[j] = temp;
	            }
	        }
	        int temp = pos[i+1];
	        pos[i+1] = pos[high];
	        pos[high] = temp;
	 
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
				System.out.println("Pos = "+pos[i]+" suffix : "+suff[pos[i]]);
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
