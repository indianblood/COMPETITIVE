// A simple MinHeap Implemenation with all the functions
import java.util.*;
class Heap
{
	private static int values[] = new int[201];
	private static int endIndex = 0;
	
	public Heap(int a[])
	{
		if(a.length > 200)
		{
			System.out.println(" Array size greater than permissible!");
		}
		else
			buildHeap(a);
	}
	
	public void insert(int x)
	{
		endIndex++;
		if(endIndex == 201)
		{
			endIndex--;
			System.out.println("Heap Full!");
		}
		values[endIndex] = x;
		
		int tmp = values[1];
		values[1] = values[endIndex];
		values[endIndex] = tmp;
		
		heapify(1);
	}
	
	public void buildHeap(int a[])
	{
		for(int i = endIndex/2 ; i >= 1 ; i--)
		{
			heapify(i);
		}
		for(int i =0 ; i<a.length ; i++)
		{
			values[i+1] = a[i];
		}
	}
	
	public int extractMin()
	{
		if(endIndex == 0)
			return -1;
		int val = values[0];
		values[0] = values[endIndex];
		endIndex--;
		heapify(1);
	}
	
	public void heapify(int i)
	{
		int l = 2*i;
		int r = l+1;
		int min = i;
		if(values[i] > values[l] &&  l <201)
			min = l;
		if(values[min] > values[r] && r<201)
			min = r;
		if(min != i)
		{
			int tmp = values[min];
			values[min] = values[i];
			values[i] = tmp;
			heapify(min);
		}
	}
	
	public int size()
	{
		return endIndex;
	}
}
