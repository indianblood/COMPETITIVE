//Dijkstra's Algorithm implementation using heap (ADJACENCY MATRIX)
// Assuming the maximum number of vertices to be 200

import java.util.*;

class Heap
{
	private static int v[] = new int[201];
	private static int dis[] = new int[201];
	private static int endIndex = 0;
	
	public Heap(int a[],boolean flag[])
	{
		int j = 1;
		System.out.println("\nHeap creation...");
		for(int i=1;i<a.length;i++)
		{
			if(!flag[i])
			{
				System.out.println(i + "  " + a[i] );
				v[j] = i;
				dis[j] = a[i];
				j++;
			}
		}
		endIndex = j-1;
		for(int i = endIndex/2 ; i >= 1 ; i--)
		{
			heapify(i);
		}
	}
	
	public void heapify(int i)
	{
		int l = 2*i;
		int r = l+1;
		int min = i;
		if(dis[i] > dis[l] &&  l <=endIndex)
			min = l;
		if(dis[min] > dis[r] && r<=endIndex)
			min = r;
		if(min != i)
		{
			int tmp = v[min];
			v[min] = v[i];
			v[i] = tmp;
			
			tmp = dis[min];
			dis[min] = dis[i];
			dis[i] = tmp; 
			heapify(min);
		}
	}
	
	public int extractMin()
	{
		return v[1];		
	}
}


class DijkstraHeap
{
	public static int mat[][] = new int[201][201];
	public static boolean sptSet[];
	public static int noOfVertices = 0;
	public static int dist[];
	
	public static void dijkstra(int src)
	{
		dist[src] = 0;
		for(int i=1 ; i<=noOfVertices ; i++)
		{
			if(i != src)
				dist[i] = Integer.MAX_VALUE;
		}
		// Find shortest path for all vertices
		for (int count = 1; count <= noOfVertices ; count++)
		{
			Heap h = new Heap(dist,sptSet);
			/*for(int i=1;i<=noOfVertices;i++)
			{
				System.out.print(dist[i]+",");
			}*/
			//System.out.println();
			// Pick the minimum distance vertex from the set of vertices not
			// yet processed. u is always equal to src in first iteration.
			int u = h.extractMin();
			//System.out.println("\nu : " + u);
			// Mark the picked vertex as processed
			sptSet[u] = true;
	  
			// Update dist value of the adjacent vertices of the picked vertex.
			for (int v = 1; v <= noOfVertices; v++)
			{
				// Update dist[v] only if is not in sptSet, there is an edge from 
				// u to v, and total weight of path from src to  v through u is 
				// smaller than current value of dist[v]
				int tmp = dist[u]+mat[u][v];
				//System.out.println("tmp" + v + " = " + tmp + " " + dist[v]);
				if( (!sptSet[v]) && ( mat[u][v] != -1 ) && ( dist[u] != Integer.MAX_VALUE )&& ( tmp < dist[v] ) )
				{
					dist[v] = dist[u] + mat[u][v];
					//System.out.println("v : " + v + " dist : " + dist[v]);
				}
			}
		}
  
		// print the constructed distance array
		printSolution();
	}
	
	public static void printSolution()
	{
		for(int i=1;i<=noOfVertices;i++)
		{
			System.out.print(dist[i]+",");
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of vertices : ");
		noOfVertices = sc.nextInt();
		dist = new int[noOfVertices+1];
		sptSet = new boolean[noOfVertices+1];
		System.out.println("Enter the edges : "); //enter in the following format u v edge_wt flag (to stop entering enter 0)
		int flag = 1;
		int k = 1;
		for(int i = 0;i<201;i++)
		{
			for(int j=0;j<201;j++)
			{
				mat[i][j] = -1;
			}
		}
		//insertion done assuming that the vertices start from 1
		while(flag != 0)
		{
			int u = sc.nextInt();
			int v = sc.nextInt(); 
			mat[u][v] = sc.nextInt();
			mat[v][u] = mat[u][v]; //since this is an undirected graph
			flag = sc.nextInt();
		}
		//Dijkstra's Algorithm
		System.out.println("Enter the src : ");
		dijkstra(sc.nextInt());
		
	}
}