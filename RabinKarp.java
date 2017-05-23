import java.util.*;

class RabinKarp
{
	public static String pat;
	public static String word;
	public static int position = 0,wordSize,patSize;
	
	public static boolean rabinKarpSearch()
	{
		wordSize = word.length(); //length of the word
		patSize = pat.length(); //length of the pattern
		//hashing the pattern and the substrings of size = patSize
		double patHashVal = hashGenerate(pat,-1,1);
		//System.out.println("patHash : " + patHashVal);
		double prevHash=0;
		boolean flag = false;
		for(int step=1; step <= wordSize-patSize+1 ;step++)
		{
			double curr = hashGenerate(word,prevHash,step);
			//System.out.println("i :"+(step-1)+" curr :" + curr);
			prevHash = curr;
			//checking when hashValue of current substring is equal to that of the pattern
			if(curr == patHashVal) 
			{
				int j =0;
				position = step - 1;
				for(int i = step-1;i<step-1+patSize;i++)
				{
					if(pat.charAt(j) == word.charAt(i))
						flag = true;
					else
					{
						flag = false;
						break;
					}
					j++;
				}
			}
			if(flag)
				break;
		}
		return flag;	
	}
	
	
	public static double hashGenerate(String p,double prevHash,int step)
	{
		int size = p.length();
		double result = 0;
		if(step == 1)
		{
			if(prevHash != -1)
			{
				//hashGenerate for 1st step
				for(int i = 0;i<patSize;i++)
				{
					int val = p.charAt(i);
					result += val*Math.pow(101,i);
				}
			}
			else
			{
				//hashGenerate for pattern
				for(int i = 0;i<size;i++)
				{
					int val = p.charAt(i);
					result += val*Math.pow(101,i);
				}
			}
		}
		else
		{
			//hashGenerate for steps > 1
			int j = step-1;
			int v = p.charAt(j-1);
			double tmp = prevHash - v;
			tmp = tmp/101;
			int val = p.charAt(j+patSize-1);
			result =  tmp + val*Math.pow(101,patSize-1);
		}
		return result;
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the word : ");
		word = sc.nextLine();
		System.out.print("Enter the pattern to be searched : ");
		pat = sc.nextLine();
		if(rabinKarpSearch())
			System.out.println("The pattern was found at index #"+position);
		else
			System.out.println("Pattern not found.");
	}
}