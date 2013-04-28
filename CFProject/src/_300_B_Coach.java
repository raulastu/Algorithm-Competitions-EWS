import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _300_B_Coach {
	//->solution screencast http://youtu.be/oHg5SJYRHA0
	public void solve() {
		int n = ni(), t=ni();
		int [][] graph= new int[50][50];
		for (int i = 0; i < t; i++) {
			int a = ni(), b=ni();
			graph[a][b]=1;
			graph[b][a]=1;
		}  
		ArrayList<Integer> free = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> ar2 = new ArrayList<ArrayList<Integer>>();
		HashSet<Integer> taken = new HashSet<Integer>();
		String res="";
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer>ar = new ArrayList<Integer>();
			ar.add(i);
			if(taken.contains(i))continue;
			len(graph,i,ar);
			taken.addAll(ar);
			if(ar.size()==2){
				ar2.add(ar);
			}else if(ar.size()==1){
				free.add(i);
			}else if(ar.size()==3){
				res+=(ar.get(0)+" "+ar.get(1)+" "+ar.get(2))+"\n";
			}else{//size>3
				out.println(-1);
				return;
			}
		}
//		pr(arr);
		if(ar2.size()>free.size()){
			out.print(-1);
			return;
		}
		for (int i = 0; i < ar2.size(); i++) {
			ArrayList<Integer>ar = ar2.get(i);
			res+=(ar.get(0)+" "+ar.get(1)+" "+free.remove(0))+"\n";
		}
//		pr(res);
		for (int i = 0; i < free.size(); i+=3) {
			res+=(free.get(i)+" "+free.get(i+1)+" "+free.get(i+2))+"\n";
		}
		out.print(res);
	}
	int len(int G[][], int x, ArrayList<Integer>ar){
		int r=0;
		for (int i = 0; i < G.length; i++) {
			if(i==x)continue;
			if(ar.contains(i))continue;
			if(G[x][i]==1 || G[i][x]==1){
				ar.add(i);
				r=1+max(r,len(G,i,ar));
			}
		}
		return r;
	}
	
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _300_B_Coach().run();}

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

