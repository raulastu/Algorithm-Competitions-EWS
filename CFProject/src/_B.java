
import java.util.*;

import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.io.*;

public class _B {

	int di[] = { 0, 0, -1, 1 };
	int dj[] = { -1, 1, 0, 0 };

	void go(int i, int j) {
		for (int j2 = 0; j2 < 4; j2++) {
			int X = i + di[j2];
			int Y = j + dj[j2];
			if (X >= 0 && X < memo.length && Y >= 0 && Y < memo[X].length
					&& !memo[X][Y] && grid[X][Y] == 'B') {
				memo[X][Y] = true;
				go(X, Y);
			}
		}
	}

	char[][] grid;
	boolean memo[][];

	public void solve() {
		int N = readInt();
		int M = readInt();
		grid = new char[N][M];
		for (int i = 0; i < N; i++) {
			grid[i] = in.next().toCharArray();
		}
		boolean no = false;
		memo = new boolean[N][M];
		int f = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == 'B' && !memo[i][j]) {
					if (f == 1) {
						System.out.println("NO");
						return;
					}
					memo[i][j] = true;
					f++;
					go(i, j);
				}
			}
		}

		outer: for (int i = 0; i < M; i++) {
			int w = 0, b = 0;
			boolean blackfinished = false;
			for (int j = 0; j < N; j++) {
				if (grid[j][i] == 'W') {
					if (b > 0)
						blackfinished = true;
					w++;
				}
				if (grid[j][i] == 'B') {
					if (blackfinished) {
						no = true;

						break outer;
					}
					b++;
				}
			}
		}
		outer: for (int i = 0; i < N; i++) {
			int w = 0, b = 0;
			boolean blackfinished = false;
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == 'W') {
					if (b > 0)
						blackfinished = true;
					w++;
				}
				if (grid[i][j] == 'B') {
					if (blackfinished) {
						no = true;
						break outer;
					}
					b++;
				}
			}
		}

		if (no) {
			System.out.println("NO");
			return;
		}

//		node[] nn = new node[M];
		ArrayList<node> nn = new ArrayList<_B.node>();
		for (int i = 0; i < M; i++) {
			int a = Integer.MAX_VALUE, b = -1;
			for (int j = 0; j < N; j++) {
				if (grid[j][i] == 'B') {
					a = min(j, a);
					b = max(j, b);
				}
			}
			if(a!=Integer.MAX_VALUE)
				nn.add(new node(a, b));
		}
//		print(nn);
		for (int i = 0; i < nn.size(); i++) {
			for (int j = i + 1; j < nn.size(); j++) {
				if (nn.get(i).a > nn.get(j).b) {
					System.out.println("NO");
					return;
				}
				if (nn.get(i).b < nn.get(j).a) {
					System.out.println("NO");
					return;
				}
				if (nn.get(i).b < nn.get(j).b && nn.get(i).a < nn.get(j).a) {
					System.out.println("NO");
					return;
				}
				if (nn.get(i).b > nn.get(j).b && nn.get(i).a > nn.get(j).a) {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
	}

	class node {
		int a, b;

		public node(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public String toString() {
		
			return a+" "+b;
		}
	}

	_B() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);
	}

	public static void close() {
		in.close();
		out.close();
	}

	public static void main(String[] args) throws Exception {
		new _B().solve();
		close();
	}

	static Scanner in;
	static PrintWriter out;

	static int readInt() {
		return in.nextInt();
		// return parseInt(in.nextLine());
	}

	static int[] readIntArray() {
		String l[] = in.nextLine().split(" ");
		int[] r = new int[l.length];
		for (int i = 0; i < l.length; i++) {
			r[i] = parseInt(l[i]);
		}
		return r;
	}


	static void print(Object... ob) {
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}
