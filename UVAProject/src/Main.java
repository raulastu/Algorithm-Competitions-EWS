import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class Main {

	public void solve() {
		// while(true){
		int n = ni(), G = ni();
		int[] a = new int[n];
		int res = 0;
		for (int i = 0; i < n; i++) {
			int dif = ni() - ni();
			if (dif < 0)
				a[i] = -dif;
			else if (dif > 0) {
				a[i] = Integer.MAX_VALUE;
				res += 3;
			}

		}
		sort(a);
//		pr(a, G, res);
		for (int i = 0; i < a.length; i++) {
			if(a[i]<0 || a[i]==Integer.MAX_VALUE) continue;
			int bo = a[i] + 1;
			if (G >= bo) {
				G -= bo;
				a[i] = Integer.MAX_VALUE;
				res += 3;
			}
		}
//		pr(a, G, res);
//		for (int i = 0; i < a.length; i++) {
//			if(a[i]<0 || a[i]==Integer.MAX_VALUE) continue;
//			int bo = a[i];
//			if (G >= bo) {
//				G -= bo;
//				a[i] += bo;
//				res += 1;
//			}
//		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0)
				res += 1;
		}
		System.out.println(res);
		// }
	}

	public List<Integer> primeFactors(int number) {
		int n = number;
		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		return factors;
	}

	// IO methods

	void run() throws Exception {
		long s = System.currentTimeMillis();
		solve();
		out.flush();
		// pr(System.currentTimeMillis() - s + "ms");
	}

	public static void main(String[] args) throws Exception {
		new Main().run();
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
