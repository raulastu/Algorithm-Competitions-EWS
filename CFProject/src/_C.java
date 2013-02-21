

import java.util.*;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

import javax.xml.stream.events.StartDocument;

public class _C {

	public void solve() {
		int N = readInt();
		int[] stairs = new int[N];
		for (int i = 0; i < stairs.length; i++) {
			stairs[i]=readInt();
		}
		int B = readInt();
//		int [][] boxes = new int[B][2];
		int max=-1;
		long res=0;
		for (int i = 0; i < B; i++) {
			int w = readInt();
			int h = readInt();
			max=max(max,w);
//			long h = max(stairs[max-1],res);
			res=max(res,stairs[max-1]);
			System.out.println(res);
			res+=h;
		}
	}
	_C(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new _C().solve();
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
