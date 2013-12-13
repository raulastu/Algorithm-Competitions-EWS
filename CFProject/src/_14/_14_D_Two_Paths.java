package _14;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

import java.awt.Point;
import java.io.*;

public class _14_D_Two_Paths {
	//->solution screencast http://youtu.be/oHg5SJYRHA0
	public void solve() {
		int n = ni();
		boolean[][]m=new boolean[n][n];
		ArrayList<Point> roads = new ArrayList<Point>();
//		node root = new node();
		HashMap<Integer,node> map = new HashMap<Integer, _14_D_Two_Paths.node>();
//		map.put(1,root);
		left=new int[n];
		right = new int[n];
		fill(left,-1);
		fill(right,-1);
		for (int i = 0; i < n-1; i++) {
			int a=ni()-1,b=ni()-1;
			roads.add(new Point(a,b));
			right[a]=b;
			left[b]=a;
			m[a][b]=m[b][a]=true;
			if(map.containsKey(a)){
				node anode=map.get(a);
				if(map.containsKey(b)){
					anode.add(map.get(b));
				}else{
					node bnode = new node(b);
					anode.add(bnode);
				}
				
			}else{
				node anode=new node(a);
				if(map.containsKey(b)){
					anode.add(map.get(b));
				}else{
					node bnode = new node(b);
					anode.add(bnode);
				}				
			}
		}
//		pr(left);
		int max=0;
		for (int i = 0; i < n-1 ; i++) {
			int a = roads.get(i).x;
			int b = roads.get(i).y;
			
			map.get(a).neis.remove(new node(b));
			
			ArrayList<Integer> as=new ArrayList<Integer>();
			ArrayList<Integer> bs=new ArrayList<Integer>();
			boolean []vis=new boolean[n];
			getNe(a,vis,as);
			vis=new boolean[n];
			getNe(b,vis,bs);
			m[a][b]=m[b][a]=false;
			right[a]=-1;
			left[b]=-1;
			int maxA=0;
			pr(as,bs);
			for (int j = 0; j < as.size(); j++) {
				vis=new boolean[n];
				vis[as.get(j)]=true;
				maxA=max(maxA,go(as.get(j),vis)-1);
			}
			
			int maxB=0;
			for (int j = 0; j < bs.size(); j++) {
				vis=new boolean[n];
				vis[bs.get(j)]=true;
				maxB=max(maxB,go(bs.get(j),vis)-1);
			}
			pr(maxA,maxB);
			max=max(max,maxA*maxB);
			right[a]=b;
			left[b]=a;
		}
		out.println(max);
	}
	int []left;
	int []right;
	boolean a;
	boolean b;
	
	void getNe(int i, boolean vis[], ArrayList<Integer> s){
		s.add(i);
		if(left[i]!=-1 && !vis[left[i]]) {
			vis[i]=true;
			getNe(left[i],vis,s);
		}
		if(right[i]!=-1 && !vis[right[i]]){
			vis[i]=true;
			getNe(right[i],vis,s);
		}
	}
	
	int go(int i, boolean []vis){
		int l=0;
		if(left[i]!=-1 && !vis[left[i]]){
			vis[left[i]]=true;
			l=1+go(left[i],vis);
			
		}
		int r=0;
		if(right[i]!=-1 && !vis[right[i]]){
			vis[right[i]]=true;
			r=1+go(right[i],vis);
			
		}
		return max(r,l);
	}
	
	class node{
		public node(int n) {
			this.idx=n;
		}
		int idx;
		Set<node> neis=new  HashSet<_14_D_Two_Paths.node>();
		void add(node n){
			neis.add(n);
		}
		
		@Override
		public boolean equals(Object obj) {
			node b = (node)obj;
			return idx==b.idx;
		}
	}
	
	
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _14_D_Two_Paths().run();}

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

