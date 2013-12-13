import java.awt.Point;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main7 {
	static int[][] stand = new int[][] {
			{ 0, 0 }, 
			{ -1, -1 }, //1
			{ 0, -1 },  //2 south
			{ 1, -1 }, //3
			{ -1, 0 }, //4 //west
			{ 0, 0 }, 
			{ 1, 0 },//6  // east
			{ -1, 1 }, // 
			{ 0, 1 }, //8 north
			{ 1, 1 }  //
			};

	public void solve() {
		int n = ni();
//		char[] a= new char [1000001];
		int t = 0;
		Point p1 = new Point();
		Point p2 = new Point();
		while (t++ < n) {
			long s = 0;
			char[] a = ns(1000001);
			for (int i = 0; i < a.length-1; i++) {
				if(i==0){
					p1.x = stand[a[i]-'0'][0];
					p1.y = stand[a[i]-'0'][1];
				}else{
					p2.x=p1.x+stand[a[i]-'0'][0];
					p2.y=p1.y+stand[a[i]-'0'][1];
					
					
					s+=p1.x*p2.y-p2.x*p1.y;
					pr(p1,p2, s);
//					pr(s);
					p1.x=p2.x;p1.y=p2.y;
				}
			}
//			System.out.println(s/(double)2);
			long temp;

			if (s<0)
			{
				s =-s;
			}
			temp = s/2;
			if (temp *2 == s)
			{
				System.out.printf("%d\n", s/2);
			}
			else
			{
				System.out.printf("%d.5\n", s/2);
			}
		}
	}
	
	void run() throws Exception {
			long s = System.currentTimeMillis();
			solve();
			out.flush();
			pr(System.currentTimeMillis() - s + "ms");
		}
		public static void main(String[] args) throws Exception {new Main7().run();}

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
