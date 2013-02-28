package contest100;


import java.util.*;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _A {
	int []di={0,0,1,-1};
	int []dj={-1,1,0,0};
	public void solve() {
		int n = in.nextInt();
		int k= in.nextInt();
		int r=-Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int f = in.nextInt();
			int t =in.nextInt();
			if(t>k)
				r = max(r,f-(t-k));
			else
				r = max(r,f);
		}
		System.out.println(r);
	}
	_A(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new _A().solve();
		close();
	}

	static Scanner in;
	static PrintWriter out;

	static int readInt(){
		return in.nextInt();
//		return parseInt(in.nextInt());
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
