package codechef;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class ICPC16B {
	class Writer {
		private final PrintWriter p;

		Writer(OutputStream o) {
			p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(o)));
		}

		void print(Object... o1) {
			for (Object o11 : o1) {
				p.print(o11 + " ");
			}
		}

		void print(String s) {
			p.print(s);
		}

		void println(Object... o1) {
			print(o1);
			p.println();
		}

		void flush() {
			p.flush();
		}

		void close() {
			p.close();
		}
	}

	class Reader {
		private byte buffer[];
		private DataInputStream din;
		// private BufferedInputStream din;
		// private final int size = 1 << 16;
		private final int size = 1024 * 100;
		private int bufferpointer, bytesRead;

		Reader() {
			din = new DataInputStream(new BufferedInputStream(System.in));
			// din = new BufferedInputStream(System.in);
			bufferpointer = bytesRead = 0;
			buffer = new byte[size];
		}

		String readLine() throws IOException {
			byte b[] = new byte[10000]; // possible error here , size of string
										// limited at 10,000 chars
			int cnt = 0, c;
			while ((c = scan()) != -1) {
				if (c == '\n')
					break;
				b[cnt++] = (byte) c;
			}
			return new String(b, 0, cnt);
		}

		int nextInt() throws IOException {
			int num = 0, c = scan();
			boolean neg = false;
			while (c <= ' ')
				c = scan();
			if (c == '-') {
				neg = true;
				c = scan();
			}
			do {
				num = num * 10 + c - '0';
				c = scan();
			} while (c <= '9' && c >= '0');
			if (neg)
				return -1 * num;
			else
				return num;
		}

		long nextLong() throws IOException {
			long num = 0, c = scan();
			boolean neg = false;
			while (c == ' ')
				c = scan();
			if (c <= '-') {
				neg = true;
				c = scan();
			}
			do {
				num = num * 10 + c - '0';
				c = scan();
			} while (c <= '9' && c >= '0');
			if (neg)
				return -1 * num;
			else
				return num;
		}

		private byte scan() throws IOException {
			if (bufferpointer >= bytesRead) {
				fillBuffer();
			}
			return buffer[bufferpointer++];
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferpointer = 0, size);
			if (bytesRead == -1)
				buffer[0] = -1;
		}
	}

	public static void main(String args[]) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ICPC16B x = new ICPC16B();
		//int t = Integer.parseInt(br.readLine());
		Reader r = x.new Reader();
		Writer w = x.new Writer(System.out);
		int t = r.nextInt();
		//int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = r.nextInt();
			//int arr[] = new int[n];
			//HashSet<Integer> hash = new HashSet<>();
			int flagzero = 0;
			int flagone = 0 ;
			int flagminusone = 0 ;
			int flagother = 0;
			for (int i = 0; i < n; i++) {
				int z = r.nextInt();
				if(z==-1)
					flagminusone++;
				else if(z==0)
					flagzero++;
				else if(z==1)
					flagone++;
				else
					flagother++;

			}
			if (n == 1)
				w.println("yes");
			else if(flagother>1)
			{
				w.println("no");
			}
			else if(flagother==1)
			{
				if(flagminusone==0)
				{
					w.println("yes");
				}
				else
					w.println("no");
			}
			else
			{
				if(flagminusone==0)
					w.println("yes");
				else if(flagminusone>=2)
				{
					if(flagone>0)
						w.println("yes");
					else
						w.println("no");
				}
				else if(flagminusone==1)
				{
					w.println("yes");
				}
				
			}
			
		}

		w.flush();
		w.close();
	}
}
