package _Archive;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

import java.awt.Point;
import java.io.*;

public class _293_B_Distinct_Paths {
	//->solution screencast http://youtu.be/oHg5SJYRHA0
	int MOD = 1000000007;
	public void solve() {
		int n = ni(),m=ni(),k=ni();
		int [][] grid=new int[n][m];
		for (int i = 0; i < n; i++) {
			grid[i]=na(m);
		}
		pr(grid);
		boolean possible= bfs(grid,n,m);

		if(n+m-1>k){
			pr("!n+m-1>k");
			out.print("0");
			return;
		}
		if(!possible){
			pr("!possible");
			out.print("0");
			return;
		}
		long dp [][] = new long[n][m];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j]!=0){
					dp[i][j]=1;
				}
			}
		}
		if(dp[0][0]==0){
			dp[0][0]=k;
		}
		pr("dp",dp);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				long cur=(dp[i][j]%MOD);
				if(dp[i][j]==0)
					cur=k-(i+j);
				if(dp[i][j]==1)continue;
				if(i>0){
					dp[i][j]+=(cur*dp[i-1][j])%MOD;
				}
				if(j>0){
					dp[i][j]+=(cur*dp[i][j-1])%MOD;
				}
			}
//			pr("dp",dp);
		}
		pr(dp);
		out.println(dfs(grid,n,m,k)); 
	}
	long dfs(int [][]grid, int n, int m, int k){
		Queue<node> Q = new LinkedList<node>();
		if(grid[0][0]==0){
			for (int i = 0; i < k; i++) {
				Q.add(new node(0,0,(1<<i)));
			}
		}else{
			Q.add(new node(0,0,(1<<grid[0][0])));
		}
		int di[]={1,0};
		int dj[]={0,1}; 
		long res = 0;
		while(!Q.isEmpty()){
//			pr(Q);
			node q= Q.poll();
			if(q.a==n-1 && q.b==m-1){
				res=(res+1)%MOD;
			}
			for (int i = 0; i < 2; i++) {
				int X=q.a+di[i];
				int Y=q.b+dj[i];
				if(X>=0 && X<n && Y>=0 && Y<m){
					if(grid[X][Y]==0){
						for (int j = 0; j < k; j++) {
							if((q.list & (1<<j))==0){
								Q.add(new node(X,Y,q.list|(1<<j)));
							}
						}
					}	
					else
						Q.add(new node(X,Y,q.list|(1<<grid[X][Y])));
				}
			}
		}
		return res;
	}
	
	boolean bfs(int [][]grid, int n, int m){
		Queue<node> Q = new LinkedList<node>();
		Q.add(new node(0,0,(1<<grid[0][0])));
		int di[]={1,0};
		int dj[]={0,1};
		boolean memo[][]=new boolean[n][m]; 
		while(!Q.isEmpty()){
//			pr(Q);
			node q= Q.poll();
			for (int i = 0; i < 2; i++) {
				int X=q.a+di[i];
				int Y=q.b+dj[i];
				if(X>=0 && X<n && Y>=0 && Y<m && !memo[X][Y]){
					memo[X][Y]=true;
					if(grid[X][Y]!=0){
						if((q.list&(1<<(grid[X][Y])))>0){
							return false;
						}
						Q.add(new node(X,Y,q.list|(1<<grid[X][Y])));
					}	
					else
						Q.add(new node(X,Y,q.list));
				}
			}
		}
		return true;
	}
	class node {
		int a, b, list;
		public node(int a, int b, int list) {
			this.a=a;
			this.b=b;
			this.list=list;
		}
		@Override
		public String toString() {
			return "("+a+" "+b+ " "+Integer.toBinaryString(list)+")";
		}
	}
	
	
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _293_B_Distinct_Paths().run();}

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

