package _289;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _298_C_Parity_Game {
	//->solution screencast http://youtu.be/oHg5SJYRHA0
	
	public void solve() {
		char [] a = ns(1000),b=ns(1000);
		char bb [] = new char[b.length];
		String s = ""+b[0];
		int x1=0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]=='1'){
				x1++;
			}
		}
		for (int i = 1; i < b.length; i++) {
			if(b[i-1]=='0' && b[i]=='0'){
				continue;
			}
			s+=b[i];
		}
//		pr(s);
		Queue<node> Q = new LinkedList<node>();
		Q.add(new node(x1,new String(a)));
		HashSet<String> memo = new HashSet<String>();
		memo.add(new String(a));
//		pr(memo.contains(new String(a)));
		while(!Q.isEmpty()){
//			pr(Q);
			node q = Q.poll();
			if(q.s.equals(s)){
				out.println("YES");
				return;
			}
//			String next = q.s; 
			if(q.s.length()==0)continue;
			
			if((q.x1%2)!=0){
				String next=q.s+"1";
				if(!memo.contains(next)){
					memo.add(next);
					Q.add(new node(q.x1+1,next));
				}
					
			}else{
				if(q.s.charAt(q.s.length()-1)!='0'){
					String next=q.s+"0";
					if(!memo.contains(next)){
						memo.add(next);
						Q.add(new node(q.x1,next));
					}
						
				}
			}
			
			if(q.s.charAt(0)=='1'){
				String next2=q.s.substring(1);
				if(!memo.contains(next2)){
					memo.add(next2);
					Q.add(new node(q.x1-1,next2));
				}
					
			}else{
				String next2=q.s.substring(1);
				if(!memo.contains(next2)){
					memo.add(next2);
					Q.add(new node(q.x1,next2));
				}	
			}
			
		}
		out.println("NO");
	}
	class node{
		int x1;
		String s;
		public node(int x1, String s) {
			this.x1=x1;
			this.s=s;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return s;
		}
	}
	
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _298_C_Parity_Game().run();}

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

