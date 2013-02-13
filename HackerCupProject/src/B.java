
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
		Comparator c = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int r=0;
				for (int i = 0; i < o1.length(); i++) {
					char c1=o1.charAt(i);
					char c2=o2.charAt(i);
					if(c1=='?'||c2=='?'){
						continue;
					}
					if(c1==c2)continue;
					return c1-c2;
				}
				return 0;
			}
		};
		for (int n = 1; n <= r; n++) {
			int m=readInt();
			String k1=in.nextLine().replace('?', 'x');
			String k2=in.nextLine().replace('?', 'x');
			int nn=k1.length()/m;
			print(m);
			l1=new String[m];
			l2=new String[m];
			for (int i = 0; i < k2.length(); i+=nn) {
				l1[i]=k1.substring(i,i+nn);
				l2[i]=k2.substring(i,i+nn);
			}
			sort(l1);
			sort(l2);
			print(l1,l2);
			String res="";
			xx:
			for (int i = 0; i < l1.length; i++) {
				String a = l1[i];
				String b = l2[i];
				for (int j = 0; j < a.length(); j++) {
					char chara=a.charAt(j);
					char charb=b.charAt(j);
					if(chara=='x'&&charb=='x'){
						res+="a";continue;
					}
					if(a.charAt(j)=='x'){
						res+=charb;continue;
					}
					if(b.charAt(j)=='x'){
						res+=chara;continue;
					}
					if(chara!=charb){
						res="IMPOSSIBLE";
						break xx;
					}
					res+=chara;
				}
			}
			
			out.println("Case #"+n+": "+res);
//			System.out.println("Case #"+n+": "+res);
		}
	}
	String[] l1;
	String[] l2;
	int go(int i, Set<Integer> set){
		if(i==l1.length)
			return 1;
		for (int j = 0; j < l2.length; j++) {
			if(set.contains(j))continue;
			if(eq(l1[i], l2[j])){
				set.add(j);
				go(i+1,set);
			}
		}
	}
	
	boolean eq(String a, String b){
		
	}
	
	class node{
		String a;
	}
	B(){
//		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
		try {
			in = new Scanner(new File("B_in.txt"));
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

