package _430;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

import java.awt.Point;
import java.io.*;

public class _430_D_Working_out {
	//->solution screencast http://youtu.be/oHg5SJYRHA0
	public void solve() {
		n = ni();
		m=ni();
		ar= new int[n][m];
		for (int i = 0; i < m; i++) {
			ar[i]=na(m);
		}
		pr(ar);
		int minI=0,minJ=0,min=10000;
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				if(ar[i][j]<min){
					minI=i;
					minJ=j;
					min=ar[i][j];
				}
			}
		}
		int a= bfs(0,0,minI,minJ);
		int b= bfs(minI,minJ,n-1,m-1);
		int c= bfs2(n-1,0,minI,minJ);
		int d= bfs2(minI,minJ,0,m-1);
		pr(a,b,c,d);
		out.println(a+b+c+d-ar[minI][minJ]);
	}
	int n,m;
	int [][] ar;
	
	int bfs(int startX, int endX, int startY, int endY){
		LinkedList<node> Q = new LinkedList<node>();
		Q.add(new node(startX, endX,ar[startX][startY]));
		int max=0;
		boolean [][] memo=new boolean[n][m];
		while(!Q.isEmpty()){
			node p = Q.poll();
			if(p.x==endX && p.y==endY){
				max=max(max,p.c);
			}
			int X=p.x+1;
			int Y=p.y;
			if(X>=0 && X<n && Y>=0 && Y<m && !memo[X][Y] ){
				memo[X][Y]=true;
				Q.add(new node(X,Y,p.c+ ar[X][Y]));
			}
			X=p.x;
			Y=p.y+1;
			if(X>=0 && X<n && Y>=0 && Y<m && !memo[X][Y] ){
				memo[X][Y]=true;
				Q.add(new node(X,Y,p.c+ ar[X][Y]));
			}
		}
		return max;
	}
	
	int bfs2(int startX, int endX, int startY, int endY){
		LinkedList<node> Q = new LinkedList<node>();
		Q.add(new node(startX, endX,ar[startX][startY]));
		int max=0;
		boolean [][] memo=new boolean[n][m];
		while(!Q.isEmpty()){
			node p = Q.poll();
			if(p.x==endX && p.y==endY){
				max=max(max,p.c);
			}
			int X=p.x+1;
			int Y=p.y;
			if(X>=0 && X<n && Y>=0 && Y<m && !memo[X][Y] ){
				memo[X][Y]=true;
				Q.add(new node(X,Y,p.c+ ar[X][Y]));
			}
			X=p.x;
			Y=p.y-1;
			if(X>=0 && X<n && Y>=0 && Y<m && !memo[X][Y] ){
				memo[X][Y]=true;
				Q.add(new node(X,Y,p.c+ ar[X][Y]));
			}
		}
		return max;
	}
	class node{
		int x,y,c;
		public node(int x, int y, int c) {
			this.x=x;
			this.y=y;
			this.c=c;
		}
	}
	
	
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _430_D_Working_out().run();}

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

