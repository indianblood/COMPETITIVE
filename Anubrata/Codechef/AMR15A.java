package codechef;
import java.io.*;

public class AMR15A {

	public static void main(String args[])throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long countEven = 0 , countOdd = 0 ;
		int n = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split(" ");
		for(int i = 0 ; i < n ; i++)
		{
			if(Integer.parseInt(str[i])%2 == 0)
				countEven++;
			else
				countOdd++ ;
		}
		if(countEven > countOdd)
			System.out.println("READY FOR BATTLE");
		else
			System.out.println("NOT READY");
	}
}
