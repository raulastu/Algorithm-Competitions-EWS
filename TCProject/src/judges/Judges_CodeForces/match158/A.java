package Judges_CodeForces.match158;

import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class A {

	public void solve() {
		out.print(10%10);
		int a = in.nextInt();
		int b = in.nextInt();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				int r = parseInt((""+a+j));
				if(r%b==0){
					a=r;
					break;
				}
				if(j==9){
					out.println(-1);
					return;
				}	
			}
		}
		out.print(a);
//		System.out.println("YES");
	}
	
	A(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new A().solve();
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
