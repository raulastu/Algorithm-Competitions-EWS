import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class B {

	public void solve() {
		int r = readInt();
		for (int n = 1; n <= r; n++) {
			l=in.nextLine();
//			print(l);
			boolean go = go(0,0);
			String rc=go?"YES":"NO";
			out.println("Case #"+(n)+": "+rc);
//			out.println(r);
		}
	}
	String l;
	boolean go(int i, int pts){
		if(i==l.length()){
			return pts==0;
		}	
		char c = l.charAt(i);
		boolean r = false;
		if(c==':'){
			if(i<l.length()-1){
				char cn=l.charAt(i+1);
				if(cn=='(' || cn==')'){
					r = r || go(i+2,pts);
				}
			}
			r = r || go(i+1,pts);
		}
		else if(c=='('){
//			print(c);
			r = r || go(i+1,pts>=0?pts+1:pts);
		}else if(c==')'){
			r = r || go(i+1,pts-1);
		}else{
			r = r || go(i+1,pts);
		}
		return r;
	}
	B(){
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		try {
//			in = new Scanner(new File("B_in.txt"));
//			in = new Scanner(new File("balanced_smileystxt.txt"));
			
//			out = new PrintWriter(new File("B_out.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	public static void close(){
		in.close();
		out.close();
	}
	public static void main(String[] args) throws Exception {
		new B().solve();
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

