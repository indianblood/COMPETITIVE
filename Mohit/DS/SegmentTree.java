//Implementation of Segment tree for "Sum of elements in a range problem"

import java.util.*;

class SegmentTree
{
    public static int a[],tree[],size;
	
	public SegmentTree(int n)
	{
		int pwr = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		size =( 2 * (int) Math.pow(2,pwr)) - 1;
		System.out.println("Size : " + size + " " + pwr);
		tree = new int[size];
		buildSegTree(0,0,n-1);
	}
	
	public static void buildSegTree(int node,int low , int high)
	{
		if(low == high)
		{
			tree[node] = a[low];
		}
		else
		{
			int mid = (low + high)/2;
			//going to the left node
			buildSegTree(2*node+1,low,mid);
			//going to the right tree
			buildSegTree(2*node+2,mid+1,high);
			
			tree[node] = tree[2*node+1] + tree[2*node+2];
		}
	}
	
	
	public static void update(int idx , int val , int low , int high , int node)
	{
		if(low == high)
		{
			a[idx] += val;
			tree[node] += val;
		}
		else
		{
			int mid = (low + high)/2;
			if(low <= idx && idx <= mid)
			{
				//if index lies in the left child
				update(idx,val,low,mid,2*node+1);
			}
			else
			{
				update(idx,val,mid+1,high,2*node+2);
			}
			
			tree[node] = tree[2*node+1] + tree[2*node+2];
		}
	}
	
	public static void updateRange(int node , int low , int high , int start, int end, int val)
	{
		//excluding out of range 
		if( low <= high && low <= end && high >= start)
		{
			// Current node is a leaf node
			if (low == high)
			{
				tree[node] += val;
				return;
			}

			// If not a leaf node
			int mid = (low + high) / 2;
			updateRange(node*2 + 1, low, mid ,start,end, val);
			updateRange(node*2 + 2, mid + 1, high,start,end, val);

			// Use the result of children calls to update this node
			tree[node] = tree[node*2+1] + tree[node*2+2];
		}
		
		
	}
	
	
	public static int query(int node,int low, int high, int start , int end)
	{
		if( low <= high && low <= end && high >= start)
		{
			//range completely outside
			if(high < start || low > end)
				return 0;
			//range completely inside
			if(start <= low && end >= high)
			{
				return tree[node];
			}
			//partially inside and partially outside
			int mid = (low+high)/2;
			int sum1 = query(2*node+1,low,mid,start,end);
			int sum2 = query(2*node+2,mid+1,high,start,end);
			return sum1 + sum2;
		}
		return 0;
	}
	
	
    public static void main(String args[]) //throws IOException , NumberFormatException
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of elements :");
		int n = sc.nextInt();
		//insertion in the array
		a = new int[n];
		System.out.print("Enter the elements : ");
		for(int i = 0 ; i < n ; i++)
		{
			a[i] = sc.nextInt();
		}
		//building the segment tree
		SegmentTree sTree = new SegmentTree(n);
		boolean flag = true;
		while(flag)
		{
			System.out.println("Choose from the options : ");
			System.out.println("1. Update an element. ");
			System.out.println("2. Update a range.");
			System.out.println("3. Query for sum of a range.\n4. Exit \nEnter your choice : ");
			int option = sc.nextInt();
			switch(option)
			{
				case 1 : {
					System.out.print("Enter the index to be updated and value : ");
					int idx = sc.nextInt();
					int val = sc.nextInt();
					update(idx,val,0,n-1,0);
				}
				break;
				case 2 : {
					System.out.print("Enter the start and end index to be updated\nand value by which to be updated : ");
					int l = sc.nextInt();
					int r = sc.nextInt();
					int val = sc.nextInt();
					updateRange(0,0,n-1,l,r,val);
				}
				break;
				case 3 : {
					System.out.print("Enter the start and end index of range whose sum you want : ");
					int l = sc.nextInt();
					int r = sc.nextInt();
					System.out.println("Sum : " + query(0,0,n-1,l,r));
				}
				break;
				case 4 : System.out.println("Exiting ...");
				break;
				default : System.out.println("INVALID OPTION!");
			}
			if(option == 4)
			{
				flag = false;
			}
		}
    }
}