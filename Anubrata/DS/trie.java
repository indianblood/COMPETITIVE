import java.util.HashMap;
import java.util.Scanner ;
public class trie {

	static class node
	{
		public HashMap<Character,node> children ;
 		public boolean isEnd ;
		public node()
		{
			children=new HashMap<Character,node>();
			isEnd = false ;
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
		public TrieUtil()
		{
			root=new node();
		}
		static void insert(String str)
		{
			node temp = root ;
			for(int i = 0 ; i< str.length();i++)
			{
				char ch = str.charAt(i);
				if(temp.getChild(ch)!=null)
					temp = temp.getChild(ch);
				else
					temp = temp.insert(ch);
			}
			temp.End();
			//System.out.println(str+" Inserted");
		}
		static boolean searchWord(String str)
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
				return true ;
			else
				return false ;
		}
		static boolean searchPrefix(String str)
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
			return flag ;
		}
		
	}
	
	public static void main(String args[])
	{
		TrieUtil obj = new TrieUtil();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the dictionary string");
		String str = sc.nextLine();
		String words[] = str.trim().split("\\s+");
		for(String word: words)
		{
			obj.insert(word);
		}
		System.out.println("Enter the string to search");
		String sch = sc.nextLine();
		if(obj.searchWord(sch))
			System.out.println(sch+" is present as a complete word");
		else
			System.out.println(sch+" is not present as a complete word");
		if(obj.searchPrefix(sch))
			System.out.println(sch+" is present as a prefix");
		else
			System.out.println(sch+" is not present as a prefix");
	}

}
