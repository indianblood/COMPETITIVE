//Dijkstra's Algorithm implementation using heap (ADJACENCY LIST)

import java.util.*;

class HeapNode
{
	int v = 0;
	int dis = 0;
	
	public HeapNode(int v,int dis)
	{
		this.v = v;
		this.dis = dis;
	}
}

class Heap
{
	HeapNode heapnode[];
	int endIndex = 0;
	int pos[];
	
	public Heap(int a[])
	{
		//building the heap from the input array
		int size = a.length;
		pos= new int[size];
		heapnode = new HeapNode[size];
		for (int j = 0 ; j < size ; j++)
		{
			heapnode[j] = new HeapNode(j,a[j]);
			pos[j] = j;
		}
		endIndex = a.length-1;
		//Same as the buildHeap function of any Heap data structure
		for (int i = (endIndex/2)-1 ; i >= 0 ; i--)
		{
			minHeapify(i);
		}
	}
	
	public void decreaseKey(int vertex, int val)
	{
		int index = pos[vertex];
		if(heapnode[index].dis <= val)
			return; 
		heapnode[index].dis = val;
		int posi = index;
		int parent = index/2;
		while(posi > 0)
		{
			if(heapnode[parent].dis > heapnode[posi].dis)
			{
				//swapping the parent heapnode with the child
				HeapNode temp = heapnode[parent];
				heapnode[parent] = heapnode[posi];
				heapnode[posi] = temp;
				
				//swapping the positions for vertices
				int tmp = pos[parent];
				pos[parent] = pos[posi];
				pos[posi] = tmp;
				
				posi = parent;
				parent = posi / 2;
			}
			else 
				break;
		}
	}
	
	public void minHeapify(int index)
	{
		int left = 2 * index + 1;
		int right = left + 1;
		int min = index;
		if(heapnode[index].dis > heapnode[left].dis &&  left <= endIndex)
			min = left;
		if(heapnode[min].dis > heapnode[right].dis && right <= endIndex)
			min = right;
		if(min != index)
		{
			
			//swapping the nodes
			HeapNode temp = heapnode[min];
			heapnode[min] = heapnode[index];
			heapnode[index] = temp;
			
			//swapping the positions for vertices
			int tmp = pos[min];
			pos[min] = pos[index];
			pos[index] = tmp;
			
			minHeapify(min);
		}
	}
	
	public int extractMin()
	{
		int v = heapnode[0].v;
		heapnode[0] = heapnode[endIndex];
		pos[0] = pos[endIndex];
		endIndex--;
		minHeapify(0);
		return v;		
	}
	
	public boolean isEmpty()
	{
		if(endIndex == -1)
			return true;
		else
			return false;
	}
}

class Graph
{
	public int mat[][]; //this matrix stores the weight of each edge
	public HashMap<Integer,ArrayList<Integer>> edge= new HashMap<>(); //all the edges
	public int noOfVertices = 0; //total number of vertices in the graph i.e. V
	
	public Graph(int V)
	{
		noOfVertices = V;
		mat = new int[V][V];
		//initializing the weight matrix with each element = -1
		//implying that there is no edge between the two vertices initially
		for(int i = 0 ; i < noOfVertices ; i++)
		{
			for(int j = 0 ; j <	noOfVertices ; j++)
			{
				mat[i][j] = -1;
			}
		}
	}
	
	public void insertEdge(int u,int v,int wt)
	{
		mat[u][v] = wt;
			
		//Insertion in adjacency list
		if(edge.containsKey(u))
		{
			ArrayList<Integer> temp = edge.get(u);
			if(temp.indexOf(v) == -1)
			{
				temp.add(v);
				edge.put(u,temp);
			}
		}
		else
		{
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(v);
			edge.put(u,temp);
		}
			
		//Since this is an undirected graph an edge from u
		// to v also implies an edge from v to u.
		mat[v][u] = mat[u][v];
		if(edge.containsKey(v))
		{
			ArrayList<Integer> temp = edge.get(v);
			if(temp.indexOf(u) == -1)
			{
				temp.add(u);
				edge.put(v,temp);
			}
		}
		else
		{
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(u);
			edge.put(v,temp);
		}
	}
	
}

class DijkstraHeap1
{
	public static boolean sptSet[];
	public static int dist[];
	public static Graph g;
	
	public static void dijkstra(int src)
	{
		//Making the dist value of source 0.
		dist[src] = 0;
		
		//Setting the value of each element(except source node)
		//of dist array to infinity i.e. the maximum
		//value of int.
		for(int i=0 ; i < g.noOfVertices ; i++)
		{
			if(i != src)
				dist[i] = Integer.MAX_VALUE;
		}
		
		//Creating heap from the dist matrix
		Heap h = new Heap(dist);
		
		// Find shortest path for all vertices
		while(!h.isEmpty())
		{
			// Pick the minimum distance, from the heap, vertex from the set of vertices not
			// yet processed.
			int u = h.extractMin();
			// Mark the picked vertex as processed
			sptSet[u] = true;
			
			//Checking for each edge in the graph g from u
			if(g.edge.containsKey(u))
			{
				ArrayList<Integer> temp = g.edge.get(u); 
				// Update distance value of the adjacent vertices of the picked vertex in the heap.
				for (int v : temp)
				{
					//Update the value of dist[v] and that of the dis
					//of vertex v stored in the heap only if 
					// the currently stored value in dist[v] is greater
					//than the distance from the source through the path of vertex u.
					int tmp = dist[u]+g.mat[u][v];
					if((!sptSet[v]) && (g.mat[u][v] != -1) && (dist[u] != Integer.MAX_VALUE)&& (tmp < dist[v]))
					{
						dist[v] = dist[u] + g.mat[u][v];
						h.decreaseKey(v,dist[v]);
					}
				}
			}
		}
	  
		//Print the shortest distance of each node from source
		//as calculated by Dijkstra's algorithm.
		printSolution();
	}
		
	public static void printSolution()
	{
		System.out.println("Vertex\tShortest distance from source");
		for(int i=0 ; i < g.noOfVertices ; i++)
		{
			System.out.println(i+"\t"+dist[i]);
		}
	}
	
	public static void main(String args[])
	{
		//This part of code is for the manual run by the user.
		//Uncomment this part for use.
		/*
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of vertices : ");
		g = new Graph(sc.nextInt());
		dist = new int[g.noOfVertices];
		sptSet = new boolean[g.noOfVertices];
		
		System.out.println("Enter the edges : "); //enter in the following format u v edge_wt flag (to stop entering enter flag component 0)
		
		//insertion done assuming that the vertices start from 0
		int flag = 1;
		while(flag != 0)
		{
			int u = sc.nextInt();
			int v = sc.nextInt(); 
			//weight matrix input
			mat[u][v] = sc.nextInt();
			
			//Insertion in adjacency list
			if(edge.containsKey(u))
			{
				ArrayList<Integer> temp = edge.get(u);
				if(temp.indexOf(v) == -1)
				{
					temp.add(v);
					edge.put(u,temp);
				}
			}
			else
			{
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(v);
				edge.put(u,temp);
			}
			
			//since this is an undirected graph
			mat[v][u] = mat[u][v];
			if(edge.containsKey(v))
			{
				ArrayList<Integer> temp = edge.get(v);
				if(temp.indexOf(u) == -1)
				{
					temp.add(u);
					edge.put(v,temp);
				}
			}
			else
			{
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(u);
				edge.put(v,temp);
			}
			flag = sc.nextInt();
		}
		*/
		
		//Creating a graph according to the graph in example.
		g = new Graph(9);
		g.insertEdge(0, 1, 4);
		g.insertEdge(0, 7, 8);
		g.insertEdge(1, 2, 8);
		g.insertEdge(1, 7, 11);
		g.insertEdge(2, 3, 7);
		g.insertEdge(2, 8, 2);
		g.insertEdge(2, 5, 4);
		g.insertEdge(3, 4, 9);
		g.insertEdge(3, 5, 14);
		g.insertEdge(4, 5, 10);
		g.insertEdge(5, 6, 2);
		g.insertEdge(6, 7, 1);
		g.insertEdge(6, 8, 6);
		g.insertEdge(7, 8, 7);
		

		dist = new int[g.noOfVertices];
		sptSet = new boolean[g.noOfVertices];
		
		//Call to Dijkstra's Algorithm's function
		dijkstra(0);
		
	}
}
