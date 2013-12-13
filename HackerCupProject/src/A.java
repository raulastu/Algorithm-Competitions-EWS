
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

import javax.swing.text.AbstractDocument.LeafElement;

public class A {

	long mod=1000000007;
	long[]fact;
	public void solve() {
		int N  = parseInt(in.nextLine());
		for (int i = 0; i < N; i++) {
			int C = parseInt(in.nextLine());
			int a[][]=new int[C*3][C*3];
			char ax[][]=new char[C][C];
			int start=-1, rows=0, row=-1;
			for (int j = 0; j < C; j++) {
				ax[j] = in.nextLine().toCharArray();
				if(start!=-1 && rows!=-1){
					continue;
				}
				for (int k = 0; k < ax.length; k++) {
					if(ax[j][k]=='#' && start==-1){
						row=j;
						start=k;
						rows=1;
					}else if(ax[j][k]=='#'){
						rows++;
					}else{
						
					}
				}

			}
//			if(rows>C-j){
//				out.print("NO");
//			}
			pr(start,rows,row);
			for (int j = row; j < rows; j++) {
				for (int ix = start; ix < start+rows; ix++) {
					a[j][ix]=1;
				}
			}
			for (int j = 0; j < ax.length; j++) {
				for (int k = 0; k < ax.length; k++) {
					if(ax[j][k]=='#'){
						a[j][k]=a[j][k]==1?0:1;
					}
				}
			}
			boolean no=false;
			for (int j = 0; j < a.length; j++) {
				for (int j2 = 0; j2 < ax.length; j2++) {
					if(a[j][j2]==1){
						no=true;
				
						j=a.length;
						break;
					}
				}
			}
			if(no){
				out.format("Case #%d: %s\n",(i+1),"NO");
			}else{
				out.format("Case #%d: %s\n",(i+1),"YES");
			}
//			pr(0^1)
			pr(a);
			
		}
	}
	
	A(){
		try {
			
//			in = new Scanner(new File("a_in.txt"));
			in = new Scanner(new File("square_detector.txt"));
			
			out = new PrintWriter(new File("A_out.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		
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
	static int[] readIntArray2(){
//		String l[] = in.nextLine().split(" ");
		int[] r=new int[10000];
		fill(r,2000000000);
		return r;
	}
	
	static void pr(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

