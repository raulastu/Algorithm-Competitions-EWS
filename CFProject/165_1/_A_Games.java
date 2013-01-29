

import java.util.*;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _A_Games {

	public void solve() {
		int N = readInt();
		int team[][] = new int[N][2];
		
		
		for (int i = 0; i < N; i++) {
			team[i][0]=readInt();
			team[i][1]=readInt();
		}
		int r=0;
		for (int i = 0; i < team.length; i++) {
			for (int j = 0; j < team.length; j++) {
				if(i!=j)
					if(team[i][0]==team[j][1])
						r++;
			}
		}
		out.println(r);
	}
	_A_Games(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new _A_Games().solve();
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
