package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AMR15B {

	static int gcd(int x, int y) {
		int a = Math.min(x, y);
		int b = Math.max(x, y);
		while (a != 0) {
			int temp = b % a;
			b = a;
			a = temp;
		}
		return b;
	}

	static int prod;
	static int mod = 1000000007;
	static int arr[];

	static void prod(int pos, int gcd) {
		if ((gcd == -1)) {
			prod = (arr[pos]%mod) ;
			if (pos != arr.length - 1) {
				prod(pos + 1, -1);
				prod(pos + 1, arr[pos]);
			}
		} else if(gcd!=1) {
			
			if (pos != arr.length - 1) {
				prod(pos + 1, gcd);
				prod(pos + 1,gcd(arr[pos], gcd));
			}
			else
			prod = ((prod % mod) * (gcd % mod)) % mod;
		}
	}

	

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[n];
			prod = 1;
			String str[] = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(str[i]);
			}
			prod(0, -1);
			System.out.println(prod);
		}
	}
}
