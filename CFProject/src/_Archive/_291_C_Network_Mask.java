package _Archive;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _291_C_Network_Mask {
	//->solution screencast http://youtu.be/oHg5SJYRHA0
	public void solve() {
		int n = ni(), k=ni();
		
		int [][] ar = new int[n][4];
		for (int i = 0; i < n; i++) {
			String ns = ns();
			String [] ab = ns.split("\\.");
			int a=parseInt(ab[0]);
			int b=parseInt(ab[1]);
			int c=parseInt(ab[2]);
			int d=parseInt(ab[3]);
			ar[i][0]=a;
			ar[i][1]=b;
			ar[i][2]=c;
			ar[i][3]=d;
		}
//		pr(ar);
//		int a=0,b=0,c=0,d=0;
		
		int []a=new int[4];
		for (int i = 0; i < 4; i++) {
			for (int j = 7; j >=0; j--) {
				a[i]|=(1<<j);
//				pr(a,getIp(a));
				HashSet<Integer> s = new HashSet<Integer>();
				for (int jj = 0; jj < ar.length; jj++) {
					int r=0;
					for (int l = 0; l < 4; l++) {
						r=r|(((ar[jj][l]&a[l])<<(8*(l+1))));
					}
					s.add(r);
				}
				if(s.size()==k){
					out.println(getIp(a));
					return;
				}	
			} 
		}
		out.println(-1);
	}
	String getIp(int[] a){
		return a[0]+"."+a[1]+"."+a[2]+"."+a[3];
	}
	
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _291_C_Network_Mask().run();}

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

