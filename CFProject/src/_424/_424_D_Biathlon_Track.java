package _424;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _424_D_Biathlon_Track {
	// ->solution screencast http://youtu.be/oHg5SJYRHA0
	public void solve() {
		int n = ni(), m = ni(), t=ni();
		tp = ni();
		tu = ni();
		td = ni();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++) {
			a[i] = na(m);
		}
		long res = 0;
		// 1200*300*300
		int best = 1000000000;
		int x1=-1,y1=-1,x2=-1,y2=-1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int i2 = i + 2; i2 < n; i2++) {
					for (int j2 = j + 2; j2 < m; j2++) {
						int l = 0;
//						pr("");
						for (int k2 = j; k2 <= j2; k2++) {
							if (k2 > j)
								l += ef(a[i][k2-1], a[i][k2]);
							if (k2 < j2)
								l += ef(a[i2][k2+1], a[i2][k2]);
						}
						for (int k2 = i; k2 <= i2; k2++) {
							if (k2 > i)
								l += ef(a[k2][j],a[k2-1][j]);
							if (k2 < i2)
								l += ef(a[k2][j2],a[k2+1][j2]);
						}
//						pr(l,best);
						if (abs(t - l)<best) {
							best = abs(t - l);
							x1=i+1;
							y1=j+1;
							x2=i2+1;
							y2=j2+1;
//							pr(x1,y1,x2,y2, l,best);
						}
					}
				}
			}
		}
		pr(best);
		out.println(x1+" "+y1+" "+x2+" "+y2);
	}

	int tp;
	int tu;
	int td;

	int ef(int a, int b) {
		pr(a,b);
		if (a < b) {
			return tu;
		} else if (a > b) {
			return td;
		} else {
			return tp;
		}
	}

	int[][] grid;


	// IO methods

	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {
		new _424_D_Biathlon_Track().run();
	}

	InputStream in = System.in;
	PrintWriter out = new PrintWriter(System.out);

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

	private boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	private int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	public String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != //
									// ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	public char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	public char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
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

	public long nl() {
		long num = 0;
		int b;
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

	void pr(Object... ob) {
		if (!oj)
			System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}
