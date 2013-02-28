package contest100;
import java.util.*;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _B_template {

	public void solve() {
		int n = ni();
		String[] ar = new String[n];
		for (int i = 0; i < n; i++) {
			ar[i] = ns();
		}
		this.ar = ar;
		go("", 0);
		for (String string : a) {
			boolean none = true;
			for (int jj = 0; jj < ar.length; jj++) {
				if (ar[jj].contains(string)) {
					none = false;
					break;
				}
			}
			if (none) {
				out.println(string);
				break;
			}
		}
		// out.println(res);
		// print(a,a2);
	}

	String ar[];
	TreeSet<String> a = new TreeSet<String>(new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			int n=o1.length();
			int n2=o2.length();
			if(n!=n2){
				return n-n2;
			}
			else 
				return o1.compareTo(o2);
//			return 0;
		}
	});

	void go(String title, int x) {
		if (x >= 4)
			return;
		// pr(title,x);
		for (int j = 0; j < 26; j++) {
			String ntitle = title + (char) ('a' + j);
			// pr(ntitle);
			a.add(ntitle);
		}
		for (int i = 0; i < 26; i++) {
			go(title + (char) ('a' + i), x + 1);
		}
	}

	private boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	void run() throws Exception {
		in = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		// print(oj);
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		pr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {
		new _B_template().run();
	}

	InputStream in;
	PrintWriter out;
	String INPUT = "";

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

	private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b !=
									// ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	private int ni() {
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

	private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	void pr(Object... ob) {
		if (!oj)
			System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}