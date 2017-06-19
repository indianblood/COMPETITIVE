//Algo course week 2 Programing Assignment
//Implementation of Dijkstra

import java.util.*;
import java.io.*;

class Dijkstra
{	
	public static int mat[][] = new int[201][201];
	public static int dist[] = new int[201];
	public static boolean sptSet[] = new boolean[201];
	
	public static int minDistance()	
	{
	   // Initialize min value
		int min = Integer.MAX_VALUE, min_index = 1;
	  
	    for (int v = 1; v < 201	; v++)
		{
			if(sptSet[v] == false && dist[v] < min)
			{	min = dist[v]; min_index = v; }
		}
	   return min_index;
	}
	
	public static void dijsktra(int src)
	{
		dist[src] = 0;
		sptSet[src] = true;
		// Find shortest path for all vertices
		for (int count = 1; count < 200; count++)
		{
			// Pick the minimum distance vertex from the set of vertices not
			// yet processed. u is always equal to src in first iteration.
			int u = minDistance();
			System.out.println("u : " + u);
			// Mark the picked vertex as processed
			sptSet[u] = true;
	  
			// Update dist value of the adjacent vertices of the picked vertex.
			for (int v = 1; v <= 200; v++)
			{
				// Update dist[v] only if is not in sptSet, there is an edge from 
				// u to v, and total weight of path from src to  v through u is 
				// smaller than current value of dist[v]
				if (!sptSet[v] && mat[u][v] != -1 && dist[u] != Integer.MAX_VALUE && dist[u]+mat[u][v] < dist[v])
					dist[v] = dist[u] + mat[u][v];
			}
     }
  
     // print the constructed distance array
     printSolution();
	}
	
	
	public static void printSolution()
	{
    //vertices of which you want to print shortest distance from src(here 1) 
		int p[] = {7,37,59,82,99,115,133,165,188,197};
		for(int i = 1;i<=200;i++)
			System.out.println(sptSet[i]);
		for(int i : p)
		{
			if(sptSet[i] == false)
				System.out.print("1000000,");
			else
				System.out.print(dist[i]+",");
		}
	}
	
	public static void main(String args[]) throws IOException	, Exception	
	{
		BufferedReader br = new BufferedReader(new FileReader("abc.txt"));
		String line;
		for(int i = 1; i<201;i++)
		{
			for(int j=1;j<201;j++)
			{
				mat[i][j] = -1;
			}
		}
		while( ( line = br.readLine() ) != null )
		{
			String ip[] = line.split("	");
			int i = Integer.parseInt(ip[0]);
			for(int x=1;x<ip.length;x++)
			{
				String ips[] = ip[x].split(",");
				int j = Integer.parseInt(ips[0]);
				int val = Integer.parseInt(ips[1]);
				mat[i][j] = val;
			}
		}
		
		/*//for printing the adjacency matrix
		for(int i = 1; i<=30;i++)
		{
			for(int j=1;j<=30;j++)
			{
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("\n");
		} */
		for(int i = 0; i<=200;i++)
		{
			dist[i] = Integer.MAX_VALUE;
		}
		dijsktra(1);
	}
}
