import java.util.*;

class Node
{
		private char val;
		private HashMap<Character,Node> children;
		private boolean isLeaf;
		
		public Node(char val)
		{
			this.val = val;
			children = new HashMap<>();
		}
		
		public HashMap<Character,Node> getChildren(){ return children;}
		public char getValue(){ return val; }
		public boolean checkLeaf(){ return isLeaf; }
		public void setIsLeaf(boolean v){ isLeaf = v;}
}

class Trie
{
	Node root;
	public Trie()
	{
		root = new Node('0');
	}
	
	void insert(String s)
	{
		int len = s.length();
		Node p = root;
		
		for(int i=0;i<len;i++)// i represents each level
		{
			HashMap<Character,Node> child = p.getChildren();
			char curr = s.charAt(i);
			if(child.containsKey(curr))
				p = child.get(curr);
			else
			{
				Node tmp = new Node(curr);
				child.put(curr,tmp);
				p = tmp;
			}
		}
		
		p.setIsLeaf(true);
	}
	
	void deleteHelper(Node p,char val,int level,int len,String s)
	{
		HashMap<Character,Node> child = p.getChildren();
		if(child.containsKey(val))
		{
			level++;
			Node tmp = child.get(val);
			if(level == len)
			{	
				if(tmp.checkLeaf())
				{	child.remove(val);	return; }
				else
				{
					tmp.setIsLeaf(false);
					return;
				}
			}
			deleteHelper(tmp,s.charAt(level),level,len,s);
			
		}
		else
		{
			System.out.println("String/prefix not present");
			return;
		}
	}
	
	public void delete(String s)
	{
		int len = s.length();
		if(len>0)
			deleteHelper(root,s.charAt(0),0,len,s);
	}
	
	public void search(String str)
	{
		int len = str.length();
		Node p = root;
		
		for(int i=0;i<len;i++)// i represents each level
		{
			
			HashMap<Character,Node> child = p.getChildren();
			char ch = str.charAt(i);
			if(child.containsKey(ch))
				p = child.get(ch);
			else
			{
				System.out.println("String is niether a prefix or word in the trie.");
				return;
			}
		}
		if(p.checkLeaf())
			System.out.println("String is a word in the trie.");
		else
			System.out.println("String is a prefix in the trie.");
	}
	public static void main(String args[])
	{
		boolean keepRunning = true;
		Scanner sc = new Scanner(System.in);
		Trie t = new Trie();
		while(keepRunning)
		{
			String inp;
			System.out.println("Enter 1 for insert\nEnter 2 for delete\nEnter 3 for prefix/word searching\nEnter 4 to exit");
			inp  = sc.nextLine();
			int select  = Integer.parseInt(inp);
			switch(select)
			{
				case 1 : 
				{
					System.out.print("Enter the string to insert : ");
					String str = sc.nextLine();
					t.insert(str);
				}
					break;
				case 2 : 
				{
					System.out.print("Enter the string to delete : ");
					String str = sc.nextLine();
					t.delete(str);
				}
					break;
				case 3 :
				{
					System.out.print("Enter the string to search : ");
					String str = sc.nextLine();
					t.search(str);
				}
					break;
				case 4 :
					keepRunning = false;
					break;
				default : System.out.println("Bubye old friend.");
			}
		}
	}
}
