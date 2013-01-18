package Judges_CodeForces.match158;
//package Judges_CodeForces.match157;

import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class C {

	public void solve() {
		String line = in.nextLine();
//		char[]xx=new char[10];
//		fill(xx,'1');
//		String line = new String(xx);
		String res = "";
		boolean found=false;
		for (int i = 0; i < line.length(); i++) {
			char c =line.charAt(i);
			if(c=='0' && !found){
				found=true;
			}else{
				if(i==line.length()-1&&!found){
					
				}else{
					res+=line.charAt(i);
				}
			}
		}
		System.out.println(res);
	}
	C(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new C().solve();
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
