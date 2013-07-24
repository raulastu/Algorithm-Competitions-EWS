package _332;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _332_C_Students_Revenge {
	//->solution screencast http://youtu.be/oHg5SJYRHA0
	public void solve() {
		int n = ni(), p=ni(),k=ni();
//		int []s= na(n);
//		pr(s);
		node [] totals = new node [n];
		for (int i = 0; i < n; i++) {
			totals[i] = new node(ni(), ni(), i);
		}
		shuffle(totals);
		Arrays.sort(totals, new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				if(o1.a==o2.a){
					return o2.b-o1.b;
				}
				if(o1.a>o2.a)
					return -1;
				else 
					return 1;
//				return ;
			}
		});

		Arrays.sort(totals,k,n, new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				if((o1.b==o2.b)){
					return (o2.a-o1.a);
				}
				return (o1.b-o2.b);
			}
		});
		pr(totals);
		int val = totals[k-1].a;
		int ix=totals[k-1].idx+1;
		
		for (; ix < totals.length;ix++) {
			if(totals[ix].a!=val){
				break;
			}
//			ix++;
		}
		pr(ix);
		Arrays.sort(totals,ix,n, new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				if((o1.a==o2.a)){
					return (o2.b-o1.b);
				}
				return (o1.a-o2.a);
			}
		});
		
		pr(totals);
		for (int i = 0; i < p; i++) {
			out.print((totals[i].idx+1)+" ");
		}
		
	}
	void shuffle(node ar[]){
        for (int i = ar.length-1; i>=0;i--){
                int j = (int)(Math.random()*i);
                	node t = ar[i];
	      	      ar[i]=ar[j];
	      	      ar[j]=t;
        }    
    }
	class node {
		int a; int b; 
		int idx;
		public node(int a, int b, int idx) {
			this.a=a;
			this.b=b;
			this.idx=idx;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return a+" "+b+" "+idx;
		}
		
	}
	
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _332_C_Students_Revenge().run();}

	InputStream in=System.in;
	PrintWriter out=new PrintWriter(System.out);
	
	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
	private byte[] inbuf = new byte[1024];
	private int lenbuf = 0, ptrbuf = 0;

	private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = in.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	private boolean isSpaceChar(int c) {return !(c >= 33 && c <= 126);}
	private int skip() {int b;while ((b = readByte()) != -1 && isSpaceChar(b));return b;}

	public String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != // ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	public char[] ns(int n)
	{
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while(p < n && !(isSpaceChar(b))){
			buf[p++] = (char)b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}
	
	public char[][] nm(int n, int m)
	{
		char[][] map = new char[n][];
		for(int i = 0;i < n;i++)map[i] = ns(m);
		return map;
	}
	
	public int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}
	
	
	public int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
	
	public long nl(){
		long num = 0;
		int b;
		boolean minus = false;
		while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
		if(b == '-'){
			minus = true;
			b = readByte();
		}
		while(true){
			if(b >= '0' && b <= '9'){
				num = num * 10 + (b - '0');
			}else{
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	void pr(Object... ob) {if (!oj)System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));}
}

