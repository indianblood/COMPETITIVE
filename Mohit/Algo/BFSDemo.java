//Following code is the basic implementation of BFS for connected graph
// User can input the graph edges 

import java.util.*;

class BFSDemo
{
	public static int noOfVertices = 0;
	public static HashMap<Integer,ArrayList<Integer>> E = new HashMap<>(); //edges
	
	
	public static void BFS(int s)
	{
		boolean visited[] = new boolean[noOfVertices+1];
		LinkedList<Integer> queue= new LinkedList<>();
		Deque<Integer> q = queue;
		
		//making the source visited and adding it to queue q
		visited[s] =  true;
		q.add(s);
		
		System.out.println("Following is the BFS traversal for source " + s + " : ");
		while(!q.isEmpty())
		{
			int u = q.remove();
			System.out.print(u + " ");
			if(E.containsKey(u))
			{
				ArrayList<Integer> adj = E.get(u);
				for(int v : adj)
				{
					if(!visited[v])
					{
						visited[v] = true;
						q.add(v);
					}
				}
			}
		}
		
	}
	
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		boolean keepEntering = true;
		System.out.println("Enter the total number of vertices");
		noOfVertices = sc.nextInt();
		
		//comment this insertion part if you want to insert the edges without user's interference
		while(keepEntering)
		{
			System.out.print("Want to add more edges?\nEnter 1 or 0 for yes or no resp\t");
			int c = sc.nextInt();
			if(c == 0)
			{
				keepEntering = false;
			}
			else
			{
				
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(E.containsKey(a))
				{
					ArrayList<Integer> tmp = E.get(a);
					boolean flag = true;
					for(int x : tmp)
					{
						if(x == b)
						{
							flag = false;
							break;
						}
					}
					if(flag)
					{
						tmp.add(b);
					}
					E.put(a,tmp);
				}
				else
				{
					ArrayList<Integer> tmp = new ArrayList<>();
					tmp.add(b);
					E.put(a,tmp);
				}
			}
		}
		
		//BFS starts from here
		System.out.println("Enter the source node for BFS : ");
		BFS(sc.nextInt());
	}
}