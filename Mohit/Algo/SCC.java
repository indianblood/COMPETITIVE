// Program to find strongly connected components of a given directed graph

import java.io.*;
import java.util.*;

class SCC
{
	public static ArrayList<Integer> sizes = new ArrayList<>();
	//public static int flag[][] = new int[875715][875715];
	public static HashMap<Integer,ArrayList<Integer>> edges = new HashMap<>();
	public static HashMap<Integer,ArrayList<Integer>> rev = new HashMap<>();
	public static boolean flag[] = new boolean[875715];
	//public static int leader[] = new int[875715];
	public static int currLeader = 0;
	public static HashMap<Integer,Integer> fTime = new HashMap<>();
	public static int t = 0;
	public static int currSize = 0;
	
	
	
	
	
	
	public static void DFS_loop(int pass)
	{
		if(pass == 1)
			t = 0;
		currLeader = 0;
		if(pass == 1)
		{
			for(int k = 1 ; k <=875714  ; k++)
			{
				if(flag[k] == false)
					DFS(pass,k);
			}
		}
		if(pass == 2)
		{
			for(int k = t; k>=1 ; k--)
			{
				int currLeader = fTime.get(k);
				//System.out.println("cLeader : "+currLeader);
				currSize = 0;
				if(flag[currLeader] == false)
					DFS(pass,currLeader);
				sizes.add(currSize);
			}
						
		}
	}
	
	
	
	
	
	
	public static void DFS(int pass,int i)
	{
		flag[i] = true;
		//leader[i] = currLeader;
		
		if(pass == 1)
		{
			//System.out.println("DFS node " + i );
			if(rev.containsKey(i))
			{
				ArrayList<Integer> tmp = rev.get(i);
				for(int x : tmp)
				{
					if(flag[x] == false)
					{
						//System.out.println("DFS next " + x + " from " + i );
						DFS(pass,x);
					}
				}
			}
			
			t++;
			fTime.put(t,i);
			
		}
		if(pass == 2)
		{
			if(edges.containsKey(i))
			{
				currSize++;
				ArrayList<Integer> tmp = edges.get(i);
				for(int x : tmp)
				{
					if(flag[x] == false)
					{
						DFS(pass,x);
					}
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	public static void main(String args[]) throws IOException	, Exception	
	{
		Scanner in = new Scanner(new File("SCC.txt"));
		while( in.hasNextInt() )
		{
			int c = in.nextInt();
			int tmp = in.nextInt();
				//System.out.println(c + "  " + tmp);
			if(edges.containsKey(c))
			{
				ArrayList<Integer> temp = edges.get(c);
				temp.add(tmp);
				edges.put(c,temp);
			}
			else
			{
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(tmp);
				edges.put(c,temp);
			}
			if(rev.containsKey(tmp))
			{
				ArrayList<Integer> temp = rev.get(tmp);
				temp.add(c);
				rev.put(tmp,temp);
			}
			else
			{
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(c);
				rev.put(tmp,temp);
			}
		}
/*
		for(int i=1;i<=500  ;i++)
		{
			if(edges.containsKey(i))
			{
				ArrayList<Integer> a = edges.get(i);
				System.out.print(i + " -> ");	
				for(int j : a)
				{
					System.out.print(j +" , ");
				}
				System.out.println();
			}
		}
		System.out.println("\n");
		for(int i=1;i<=500 ;i++)
		{
			if(rev.containsKey(i))
			{
				ArrayList<Integer> a = rev.get(i);
				System.out.print(i + " -> ");	
				for(int j : a)
				{
					//System.out.print(j +" , ");
				}
				//System.out.println();
			}
		}
		System.out.println("\n");
*/
		DFS_loop(1);
/*		for(int i = 1;i<=10;i++)
		{
			System.out.println(i+"->"+fTime.get(i));
		}*/
		for(int i = 0;i<flag.length;i++)
			flag[i] = false;
		DFS_loop(2);
		System.out.println("Sizes : ");
		Collections.sort(sizes);
		int k =0;
		int result[] = new int[5];
		int l = sizes.size() - 1;
		for(int i=l;i>=0;i--)
		{
			if(k>4)
				break;
			int x = sizes.get(i);
			result[k] = x;
			k++;
		}
		for(int res : result)
			System.out.println(res);
	}
}
