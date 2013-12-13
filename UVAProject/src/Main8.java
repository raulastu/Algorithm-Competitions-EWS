import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;


public class Main8 {
	private void solve() {
		int n = ni();
		HashMap<String, ArrayList> m = new HashMap<String, ArrayList>();
		ArrayList<HashMap<mathy, ArrayList>> l = new ArrayList<HashMap<mathy,ArrayList>>();
		m.put("Erdos",l);
		while(n-->0){
			String a=ns();
			String b=ns();
			if(a.equals("Erdos")){
				m.get("Erdos").add(new mathy(b,1));
			}
		}
	}
	
	class mathy{
		String s;
		int val;
		public mathy(String s, int val) {
			this.s=s;
			this.val=val;
		}
		@Override
		public boolean equals(Object obj) {
			return s.equals(((mathy)obj).s);
		}
	}
	
	void run() throws Exception {
			long s = System.currentTimeMillis();
			solve();
			out.flush();
			pr(System.currentTimeMillis() - s + "ms");
		}
		public static void main(String[] args) throws Exception {new Main8().run();}

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

		void pr(Object... ob) {if (!true)System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));}
	
}
