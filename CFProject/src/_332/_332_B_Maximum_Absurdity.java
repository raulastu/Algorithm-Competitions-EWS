package _332;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _332_B_Maximum_Absurdity {
	//->solution screencast http://youtu.be/oHg5SJYRHA0
	public void solve() {
		int n = ni(), k=ni();
		int []s= na(n);
		pr(s);
		node [] totals = new node [n-k+1];
		long first = 0;
		for (int i = n-1; i >=n-k; i--) {
			first+=s[i];
		}
		totals[n-k]=new node(first,n-k);
//		pr(totals);
		for (int i = n-k-1; i>=0; i--) {
//			pr(i);
			totals[i]= new node(totals[i+1].a+s[i]-s[i+k],i);
		}
		shuffle(totals);
		Arrays.sort(totals, new Comparator<node>() {
			@Override
			public int compare(node o1, node o2) {
				if(o1.a==o2.a){
					return o1.idx-o2.idx;
				}
				if(o1.a>o2.a)
					return -1;
				else 
					return 1;
//				return ;
			}
		});
		pr(totals);
		long max=0;
		int a=1;
		int b=k+1;
		for (int i = 0; i < totals.length-1; i++) {
			node ax = totals[0];
			node bx = totals[i+1];
			if(abs(ax.idx-bx.idx)>=k){
				out.println((min(ax.idx,bx.idx)+1)+" "+(max(ax.idx,bx.idx)+1));
				return;
			} 
		}
		
		pr(totals);
//		for (int i = 0; i < totals.length; i++) {
////			totals[i];
//			for (int j = i+k; j < totals.length; j++) {
//				long ss = totals[i]+totals[j];
////				pr(ss);
//				if(ss>max){
//					max=ss;
//					a=i+1;
//					b=j+1;
//				}
//			}
//		}
		out.println(a+" "+b);
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
		long a; int idx;
		public node(long a, int b) {
			this.a=a;
			this.idx=b;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return a+" "+idx;
		}
		
	}
	
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _332_B_Maximum_Absurdity().run();}

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

