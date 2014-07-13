package _430;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _430_C_Xortree {
	//->solution screencast http://youtu.be/oHg5SJYRHA0
	public void solve() {
		
		int a[][]= new int[4000][4000];
		
//		pr();
//		pr(~0);
		int n = ni();
		node root=new node(1);
		nodes = new HashMap<Integer, _430_C_Xortree.node>();
		for (int i = 0; i < n; i++) {
			nodes.put(i+1,new node(i+1));
		}
		for (int i = 0; i < n-1; i++) {
			int ni=ni();
			int vi=ni();
			nodes.get(vi).sons.add(nodes.get(ni));
		}
		
//		int init[] =na(n);
		for (int i = 0; i < n; i++) {
			nodes.get(i+1).val=ni();
		}
		end = new int[n+1];
		for (int i = 0; i < n; i++) {
			end[i+1]=ni();
		}
//		pr(nodes, end);
		
//		end=na(n);
		go(root.n);
		out.println(res.size());
		for (int i = 0; i < res.size(); i++) {
			out.println(res.get(i));
		}
//		pr(res);
	}
	int []init;
	int [] end;
	HashMap<Integer, node> nodes;
	int r=0;
	ArrayList<Integer> res=new ArrayList<Integer>();
	void go(int i){
//		int r=0;
//		pr(i);
		node me=nodes.get(i);
		if(me.ac>0){
			if(me.ac%2==1)
				me.val=me.val==0?1:0;
			for (node son: me.sons) {
				for (node grandc : son.sons) {
					grandc.ac++;
				}
//				son.ac++;
			}
		}
		if(me.val!=end[me.n]){
//			sw(i,true);
			for (node son: me.sons) {
				for (node grandc : son.sons) {
					grandc.ac++;
				}
//				son.ac++;
			}
			res.add(i);
		}
		for (node son: nodes.get(i).sons) {
			go(son.n);
		}
	}
	void sw(int i,boolean doit){
		if(doit){
			int v=nodes.get(i).val;
			nodes.get(i).val=v==1?0:1;
		}
		for (int j = 0; j < nodes.get(i).sons.size(); j++) {
			sw(nodes.get(i).sons.get(j).n,!doit);
		}
	}
	
	class node{
		ArrayList<node> sons = new ArrayList<_430_C_Xortree.node>();
		int n;
		int val;
		int ac;
		public node(int n) {
			this.n=n;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			String sons = "";
			if(this.sons.size()>0){
				for (node son: this.sons) {
					sons+=son.toString();
				}
			}
			return "("+n+") "+" sons = "+sons;
		}
	}
	
	
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _430_C_Xortree().run();}

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

