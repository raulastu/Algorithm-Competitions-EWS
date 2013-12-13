package _Archive;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _361_C_Levko_and_Array_Recovery {
	//->solution screencast http://youtu.be/oHg5SJYRHA0
	public void solve() {
		int n = ni(),k=ni();
		int ar[] = new int[n];
		for (int i = 0; i < ar.length; i++) {
			ar[i]=Integer.MAX_VALUE;
		}
		int [][] ops = new int[k][4];
		for (int i = 0; i < k; i++) {
			ops[i][0]=ni();
			ops[i][1]=ni();
			ops[i][2]=ni();
			ops[i][3]=ni();
		}
		for (int i = k-1; i >=0; i--) {
			int a = ops[i][1]-1;
			int b = ops[i][2]-1;
			int c = ops[i][3];
			
			if(ops[i][0]==2){
				int placeToPut=a;
				int x=0;
				int inf=0;
				for (int j = a; j <=b; j++) {
					if(ar[j]==Integer.MAX_VALUE){
						ar[j]=c;
						inf=1;
					}else if(ar[j]>c){
						placeToPut=j;
						x++;
					}
				}
				pr(ops[i],ar,x);
				
				if(x>=2){
					out.print("NO");
					return;
				}
				if(x==0 && inf==0){
					out.print("NO");
					return;
				}
				ar[placeToPut]=c;
				
			}else{
				for (int j = a; j <=b; j++) {
					if(ar[j]==Integer.MAX_VALUE){
						
					}else{
						ar[j]-=c;
					}
				}
				pr(ops[i],ar);
			}
		}
		out.println("YES");
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]==Integer.MAX_VALUE){
				out.print("1 ");
			}else
				out.print(ar[i]+" ");
		}
//		out.println(res);
	}
	
	
	// IO methods
		
	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {new _361_C_Levko_and_Array_Recovery().run();}

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

