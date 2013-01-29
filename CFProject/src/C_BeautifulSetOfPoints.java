

import java.util.*;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class C_BeautifulSetOfPoints {

	public void solve() {
		int N = readInt();
		int M = readInt();
		int n = min(N,M);
		out.println(n+1);
		for (int i = 0; i <= n; i++) {
			out.println(i+" "+(n-i));
		}
	}
	C_BeautifulSetOfPoints(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new C_BeautifulSetOfPoints().solve();
		close();
	}

	static Scanner in;
	static PrintWriter out;

	static int readInt(){
		return in.nextInt();
//		return parseInt(in.nextLine());
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
