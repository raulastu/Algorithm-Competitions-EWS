package _330;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

import java.awt.Point;
import java.io.*;

public class _330_D_Biridian_Forest {
	//->solution screencast http://youtu.be/oHg5SJYRHA0
	public void solve() {
		int r = ni(), c=ni();
		char [][] g= new char[r][c];
		for (int i = 0; i < r; i++) {
			g[i]=ns(c);
		}
		
		int di[]={0,0,-1,1};
		int dj[]={-1,1,0,0};

		long res = 0;
		ArrayList<Node> re = new ArrayList<Node>();
		int me=1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(g[i][j]=='E'){
					Queue<Node> Q = new LinkedList<Node>();
					Q.add(new Node(i,j,0));
					boolean memo[][]=new boolean[r][c];
					memo[i][j]=true;
					while(!Q.isEmpty()){
						Node q = Q.poll();
//						pr(q);
						if(g[q.x][q.y]!='T' && g[q.x][q.y]!='S' && g[q.x][q.y]!='E'
								&& g[q.x][q.y]!='0'){
							re.add(new Node((int)(g[q.x][q.y]-'0'),-1,q.c));
						}else if(g[q.x][q.y]=='S'){
							me=q.c;
						}
						for (int k = 0; k < 4; k++) {
							int X=q.x+di[k];
							int Y=q.y+dj[k];
							if(X>=0 && X<r && Y>=0 && Y<c && g[X][Y]!='T' && !memo[X][Y]){
								memo[X][Y]=true;
								Q.add(new Node(X,Y,q.c+1));
							}
						}
					}
				}
			}
		}
		pr(re,me);
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).c<=me)
				res+=re.get(i).x;
		}
		out.println(res);
	}
	
	class Node {
		int x,y,c;
		public Node(int a, int b, int c) {
			this.x=a;
			this.y=b;
			this.c=c;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return x+" "+y;
		}
	}
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _330_D_Biridian_Forest().run();}

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

