import java.io.*;
public class CHEFROUT {

	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < t ; i++)
		{
			String str = br.readLine();
			if((str.indexOf('E')!=-1)&&(str.indexOf('C')!=-1)&&(str.indexOf('E')<str.lastIndexOf('C')))
				System.out.println("no");
			else
			{
				boolean sflag = true ;
				int x = str.indexOf('S');
				if(x!=-1)
				{	
					for(int j = x ; j<str.length() ; j++)
					{
						if(str.charAt(j)!='S')
						{
							sflag = false ;
							break ;
						}
					}
				}
				if(sflag)
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
	}

}
