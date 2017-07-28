package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class roadsLibraries2 {

	static boolean visited[];
	static ArrayList<ArrayList<Integer>> adj;

	static long dfs(int x) {
		/*
		 * if(!visited[x]) { visited[x] = true ; for(int i = 0 ; i <
		 * adj.get(x).size();i++) { dfs(adj.get(x).get(i)); } }
		 */
		long num = 1;
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(new Integer(x));
		while (!stk.isEmpty()) {
			int top = stk.pop();
			visited[top] = true;
			for (int i = 0; i < adj.get(top).size(); i++) {
				int temp = adj.get(top).get(i);

				if (!visited[temp]) {
					num++;
					stk.push(new Integer(temp));
					// adj.get(x).remove(i);
					// adj.get(temp).remove(x);
				}
			}
		}
		return num;

	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int terms = 0; terms < t; terms++) {
			String str[] = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			long clib = Integer.parseInt(str[2]);
			long croad = Integer.parseInt(str[3]);
			long num = 0;
			long cost1 = 0, cost2 = 0, cost = 0;
			visited = new boolean[n];
			adj = new ArrayList<ArrayList<Integer>>();
			for (int i = 0; i < n; i++) {
				adj.add(new ArrayList<Integer>());
			}
			for (int i = 0; i < m; i++) {
				str = br.readLine().split(" ");
				int city1 = Integer.parseInt(str[0]) - 1;
				int city2 = Integer.parseInt(str[1]) - 1;
				ArrayList<Integer> temp = adj.get(city1);
				temp.add(new Integer(city2));
				adj.set(city1, temp);
				ArrayList<Integer> temp2 = adj.get(city2);
				temp2.add(new Integer(city1));
				adj.set(city2, temp2);
			}
			if (clib < croad)
				cost = n * clib;
			else {
				for (int i = 0; i < n; i++) {
					if (!visited[i]) {
						num++;
						long temp = dfs(i);
						//cost += clib + croad*(temp-1);
					}
				}
				cost = (n-num)*croad + num*clib;
			}
			System.out.println(cost);
		}
	}
}
