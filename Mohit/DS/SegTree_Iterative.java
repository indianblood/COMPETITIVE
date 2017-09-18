/** 
**  Iterative Implementation of Segment Tree
** 	Author : MOHIT SNEHAL
**  Time Complexities mentioned with the function definition
**/


import java.io.*;
import java.util.*;

class SegTree_Iterative
{
	public static int size,n;
	public static int t[];
	
	public static void build() // Time Complexity : O(n)
	{
		for(int i = n-1 ; i >= 0 ; i--)
			t[i] = t[2*i] + t[2*i + 1];
	}
	
	public static void modify(int p , int value)
	{
		t[p+n] += value; 	
		for(int i = p+n ; i > 1 ; i >>= 1)
		{
			/*if((i&1)  == 1) //i is the right child
			{
				t[i >> 1] = t[i] + t[i-1];
			}
			else //i is the left child
			{
				t[i >> 1] = t[i] +  t[i+1];
			}*/
			t[i >> 1] = t[i] + t[i^1];
		}
	}
	
	public static int query(int l , int r)
	{
		int res = 0;
		for( l += n ,r += n ; l < r ; l >>= 1 , r >>= 1)
		{
			if(l % 2 != 0)
				res += t[l++];
			if(r % 2 != 0)
				res += t[--r];
		}
		
		return res;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array : ");
		n = sc.nextInt();
		size = 2*n + 1;
		t = new int[2*n];
		System.out.println("Enter the elements of the array : ");
		for(int i = 0 ; i < n ; i++)
		{
			t[i+n] = sc.nextInt();
		}
		build();
		boolean flag = true;
		while(flag)
		{
			System.out.println("Enter 1,2,3 for query, modify(Single element) and exit respectively.");
			int choice = sc.nextInt();
			switch(choice)
			{
				case 1 : {
					System.out.println("Enter l and r : ");
					int l = sc.nextInt();
					int r = sc.nextInt();
					System.out.println("Result : " + query(l,r+1));
				}
				break;
				case 2 : {
					System.out.println("Enter position and value by which it has to be incremented respectively : ");
					int pos = sc.nextInt();
					int value = sc.nextInt();
					modify(pos,value);
				}
				break;
				case 3 : {
					System.exit(0);
				}
				default : System.out.println("Enter a valid choice.");
			}
		}
	}
}
