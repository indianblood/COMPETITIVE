import java.io.*;
import java.util.*;
public class RESCALC 
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < t ; i++)
		{
			int n = Integer.parseInt(br.readLine());
			int max = 0 , ctr = 0 , player = 0;
			for(int j = 0 ; j < n ; j++)
			{
				String str = br.readLine();
				int strt = str.indexOf(' ');
				int x = Integer.parseInt(str.substring(0,strt));
				int occ[] = new int[6];
				occ[0]=occ[1]=occ[2]=occ[3]=occ[4]=occ[5]=0;
				str = str.substring(strt+1);
				for(int k = 0 ; k < x ; k++)
				{
					occ[Integer.parseInt(""+str.charAt((k*2)))-1]++;
				}
				int count = 0  ;
				while(count<x)
				{
					int uniq = 0 ;
					for(int uctr = 0 ; uctr < 6 ; uctr++)
					{
						if(occ[uctr]!=0)
						{
							uniq++;
							occ[uctr]--;
						}
						count++;
						if(count>=x)
							break;
					}
					if(uniq==6)
						x+=4;
					else if(uniq==5)
						x+=2;
					else if(uniq==4)
						x+=1;
				}
				//System.out.println("player:"+j+" unique:"+y);
				if(x>max)
				{
					max = x ;
					player = j;
					ctr=1;
				}
				else if(x==max)
				{
					ctr++;
				}
			}
			if(ctr==1)
			{
				if(player==0)
					System.out.println("chef");
				else
					System.out.println((player+1));
			}
			else
				System.out.println("tie");
			
		}
	}
}
