package contest100;

import java.util.*;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _B {


	public void solve() {
		String s = in.next();
		HashSet<String> set = new HashSet<String>(); 
		for (int i = 0; i < s.length(); i++) {
			String x = s.charAt(i)+"";
			if(set.add(x)){
				
			}else
				set.remove(x);
		}
//		print(set);
		if(set.size()==0)
			System.out.println("First");
		else
			System.out.println(set.size()%2==1?"First":"Second");
	}

	class node {
		int a, b;

		public node(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
		
			return a+" "+b;
		}
	}

	_B() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}

	public static void close() {
		in.close();
		out.close();
	}

	public static void main(String[] args) throws Exception {
		new _B().solve();
		close();
	}

	static Scanner in;
	static PrintWriter out;

	static int readInt() {
		return in.nextInt();
		// return parseInt(in.nextLine());
	}

	static int[] readIntArray() {
		String l[] = in.nextLine().split(" ");
		int[] r = new int[l.length];
		for (int i = 0; i < l.length; i++) {
			r[i] = parseInt(l[i]);
		}
		return r;
	}


	static void print(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}
