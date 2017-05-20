//https://www.hackerrank.com/challenges/ctci-contacts

import java.io.* ;
import java.util.HashMap;


public class contacts {

	static class node
	{
		public HashMap<Character,node> children ;
 		public boolean isEnd ;
 		public int usedFor;
		public node()
		{
			children=new HashMap<Character,node>();
			isEnd = false ;
			usedFor = 0 ;
		}
		public node insert(char ch)
		{
			children.put(ch,new node());
			return children.get(ch);
		}
		public node getChild(char ch)
		{
			return children.get(ch);
		}
		public int size()
		{
			return children.size();
		}
		public void End()
		{
			isEnd = true ;
		}
		
	}
	static class TrieUtil
	{
		static node root ;
		static int count ;
		public TrieUtil()
		{
			root=new node();
			count = 0 ;
		}
		static void insert(String str)
		{
			node temp = root ;
			for(int i = 0 ; i< str.length();i++)
			{
				char ch = str.charAt(i);
				temp.usedFor++;
				if(temp.getChild(ch)!=null)
				{
					temp = temp.getChild(ch);
				}
				else
					temp = temp.insert(ch);
			}
			temp.End();
			//System.out.println(str+" Inserted");
		}
		static int searchWord(String str)
		{
			node temp = root ;
			boolean flag = true ;
			for(int i = 0 ; i< str.length();i++)
			{
				char ch = str.charAt(i);
				if(temp.getChild(ch)!=null)
					temp = temp.getChild(ch);
				else
				{
					flag = false ;
					break ;
				}
			}
			if((flag)&&(temp.isEnd))
				return 1 ;
			else
				return 0 ;
		}
		static int searchPrefix(String str)
		{
			node temp = root ;
			boolean flag = true ;
			for(int i = 0 ; i< str.length();i++)
			{
				char ch = str.charAt(i);
				//System.out.println(ch);
				if(temp.children.containsKey(ch))
					temp = temp.getChild(ch);
				else
				{
					//System.out.println("HERE");
					flag=false ;
					break ;
				}
			}
			//System.out.println("SIZE1 : "+temp.isEnd);
			if(flag)
			{
				return temp.usedFor; 
			}
			else
			{
				//System.out.println("HERE");
				return 0 ;
		
			}
		}
		static void traverse(node root)
		{
			if(root.isEnd)
			{
				//System.out.println("SIZE : "+root.size());
				count++;
			}
			for(char i = 'a' ; i<='z';i++)
			{
				if(root.getChild(i) != null)
				{
					traverse(root.getChild(i));
				}
			}
		}
		
	}
	
	public static void main(String args[]) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TrieUtil obj = new TrieUtil();
		for(int i = 0 ; i < n ; i++)
		{
			String str = br.readLine();
			String in[] = str.split(" ");
			if(in[0].equals("find"))
			{
				System.out.println(obj.searchPrefix(in[1]) + obj.searchWord(in[1]));
			}
			else
			{
				obj.insert(in[1]);
			}
		}
		
	}

}
