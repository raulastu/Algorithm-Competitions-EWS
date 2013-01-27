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
		int r = readInt();
		for (int n = 1; n <= r; n++) {
			int[] d= new int[26];
			String line = in.nextLine().toLowerCase();
			for (int i = 0; i < line.length(); i++) {
				char c = line.charAt(i);
				if(c-'a'<0 || c-'a'>26)continue;
				d[c-'a']++;
			}
			sort(d);
			int rc=0;
			int nn=26;
			for (int i = 0; i < d.length; i++) {
				rc+=d[d.length-i-1]*nn--;
			}
			
			print(rc);
			out.println("Case #"+n+": "+rc);
		}
		
	}
	
	A(){
//		in = new Scanner(System.in);
//		out = new PrintWriter(System.out);
		try {
			
			in = new Scanner(new File("A_in.txt"));
//			in = new Scanner(new File("beautiful_stringstxt.txt"));
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
	
	static void print(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

