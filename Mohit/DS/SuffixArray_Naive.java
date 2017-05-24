import java.util.*;


class LexicographicComparator implements Comparator<String> 
{
    public int compare(String a, String b) {
        return a.compareToIgnoreCase(b);
    }
}

class SuffixArray_Naive
{
	public static String s;
	public static ArrayList<String> a = new ArrayList<>();
	public static Map<String,Integer> m = new HashMap<>();
	
	public static void  createSuffixArray()
	{
		int j = s.length();
		for(int i=0;i<s.length();i++)
		{
			String tmp = s.substring(i);
			a.add(tmp);
			m.put(tmp,i);
		}
		Collections.sort(a,new LexicographicComparator());
	}
	public static void display()
	{
		for(int i=0;i<s.length();i++)
		{
			String tmp = a.get(i);
			System.out.println("substring : " + tmp + " index : " + m.get(tmp)); 	
		}
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string : ");
		s = sc.nextLine();
		createSuffixArray();
		System.out.println("The substrings and indices are as follows  : ");
		display();
	}
}
