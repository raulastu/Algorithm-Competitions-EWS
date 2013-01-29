

import java.util.*;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _B_Buttons {

	public void solve() {
		int N = readInt();
		long n [] = new long[2001];
		n[1]=1;
		n[2]=3;
		long r=N;
		for (int i = N-1,j=1; i >=1; i--,j++) {
			r+=i+(i-1)*(j);
//			print(r);
		}
		out.println(r);
	}
	_B_Buttons(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new _B_Buttons().solve();
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
