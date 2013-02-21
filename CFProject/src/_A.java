

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
//		int N = readInt();
		
		int [][]a=new int[3][3];
		int [][]b=new int[3][3];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				a[i][j]=readInt();
				b[i][j]=1;
			}
		}
//		print(a);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				for (int j2 = 0; j2 < a[i][j]; j2++) {
					b[i][j]=b[i][j]==1?0:1;
					for (int k = 0; k < 4; k++) {
						int X = i+di[k];
						int Y = j+dj[k];
						if(X>=0 && X<3 && Y>=0 && Y<3){
							b[X][Y]=b[X][Y]==1?0:1;
						}
					}
				}
			}
		}
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
//		print(b);
//		System.out.println(r);
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
