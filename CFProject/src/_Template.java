

import java.util.*;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _Template {

	public void solve() {
		int N = readInt();
		if (N <= 2) {
			out.println(N);
			return;
		}
		int r = 0;

		int memo[] = new int[1000002];

		int[] seq2 = new int[N];
		int c = 1;
		
		int[]seq=readIntArray();
		
		for (int i = 0; i < N; i++) {
			int number = seq[i];
			if (memo[number] != 0) {
				seq2[i] = memo[number];
			} else {
				memo[number] = c++;
				seq2[i] = memo[number];
			}
		}

		// print(seq2);
		int memo2[][] = new int[4002][4002];
		int memo3[] = new int[4001];
		for (int i = 0; i < seq2.length; i++) {
			// if(seq2[i]==0)break;
			if (memo3[seq2[i]] == 1)
				continue;
			memo3[seq2[i]] = 1;
			for (int j = i + 1; j < seq2.length; j++) {
				int a = seq2[i];
				int b = seq2[j];
				if (memo2[a][b] == 1)
					continue;
				// set.add(a+" "+b);
				memo2[a][b] = 1;
				boolean ab = true;
				int rr = 2;
				// print(a,b);
				for (int k = j + 1; k < seq2.length; k++) {
					if (ab && seq2[k] == a) {
						ab = !ab;
						rr++;
					} else if (!ab && seq2[k] == b) {
						ab = !ab;
						rr++;
					}
				}
				r = Math.max(r, rr);
			}
		}
		out.println(r);
	}
	_Template(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new _Template().solve();
		close();
	}

	static Scanner in;
	static PrintWriter out;

	static int readInt(){
		return parseInt(in.nextLine());
	}
	static int[] readIntArray(){
		String l[] = in.nextLine().split(" ");
		int[] r=new int[l.length];
		for (int i = 0; i < l.length; i++) {
			r[i]=parseInt(l[i]);
		}
		return r;
	}
	
	static void print(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}
