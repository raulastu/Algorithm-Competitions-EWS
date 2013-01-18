import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class LandAndSea {
	public int[] howManyIslands(String[] seaMap) {
		memo = new boolean[seaMap.length][seaMap[0].length()];
		int c = 0;
		grid = new int[seaMap.length][seaMap[0].length()];
		nodes = new ArrayList<node>();
		for (int i = 0; i < seaMap.length; i++) {
			for (int j = 0; j < seaMap[0].length(); j++) {
				if (seaMap[i].charAt(j) == '.') {
					grid[i][j] = -2;
				} else {
					grid[i][j] = -1;
				}
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (!memo[i][j] && grid[i][j] == -1) {
					nodes.add(new node(i, j));
					memo[i][j] = true;
					grid[i][j] = c;
					go(i, j, c++);

				}
			}
		}
//		print(grid);
		int[] res = new int[c];
		if (c == 0)
			return new int[0];
		fill(res, Integer.MAX_VALUE);

		int zerolevelers = 0;
		boolean[][]cont=new boolean[c][c];
		
		for (int i = 0; i < c; i++) {
//			cont[i]=-1;
			for (int j = 0; j < c; j++) {
				if(i!=j){
					cont[i][j]=contains(i,j);
//					if(cont[i][j]){
//						cont[j][i]=!cont[i][j];
//					}
				}
			}
		}
		for (int i = 0; i < c; i++) {
			boolean containsOneOrMore = false;
			for (int j = 0; j < c; j++) {
				if (j != i) {
					if (cont[j][i]) {
						containsOneOrMore = true;
//						print(i, j);
						res[i]++;

					}
				}
			}
			if (!containsOneOrMore) {
				zerolevelers++;
				res[i] = 0;
			}
		}
//		print(res, zerolevelers);
		int lvl = 0;
		boolean found = true;
		int highest = 0;
		if (zerolevelers == c) {
			// int[] rr=new int[1];
			// fill(rr,c);
			// return rr;
		} else
			while (found || lvl <= c) {
//				print(lvl);
				found = false;
				for (int i = 0; i < c; i++) {
					if (res[i] == lvl) {
						for (int j = 0; j < c; j++) {
							if (i == j)
								continue;
							if (res[j] - 1 == lvl)
								continue;
							if (cont[i][j]) {
								boolean father = true;
								for (int j2 = 0; j2 < c; j2++) {
									if (res[j2] - 1 == lvl)
										continue;
									if (i != j2 && j2 != j)
										if (cont[j2][j] && cont[i][j2]) {
											father = false;
											break;
										}
								}
								if (father) {
									found = true;
									res[j] = lvl + 1;
									highest = max(highest, lvl + 1);
								}
							}
						}
					}
				}
				if (!found)
					lvl++;
			}
//		print(res, c);
		int[] res1 = new int[highest + 1];
		for (int i = 0; i < c; i++) {
			// if(i<highest+1)
			res1[res[i]]++;
		}
		return res1;
	}

	class sea {

	}

	class node {
		int x, y;

		node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	ArrayList<node> nodes;
	int xi[] = { 1, -1, 0, 0 };
	int xj[] = { 0, 0, 1, -1 };

	boolean contains(int a, int b) {
		memo2 = new boolean[grid.length][grid[0].length];
		return !ff2(nodes.get(a).x, nodes.get(a).y, b);
	}

	boolean memo2[][];

	boolean ff2(int x, int y, int c) {
		if (x == 0 || x == grid.length - 1 || y == 0 || y == grid[0].length - 1)
			return true;
		boolean isOut = false;
		for (int i = 0; i < 4; i++) {
			int X = x + xi[i];
			int Y = y + xj[i];
			// if(X==0 || X==grid.length-1 || Y==0 || Y==grid[0].length-1){
			// return true;
			// break;
			// }
			if (X >= 0 && X < grid.length && Y >= 0 & Y < grid[X].length
					&& !memo2[X][Y] && grid[X][Y] != c) {
				memo2[X][Y] = true;
				isOut = isOut || ff2(X, Y, c);
			}
		}
		return isOut;
	}

	int[] grid[];
	boolean memo[][];
	int di[] = { 1, -1, 0, 0, 1, -1, -1, 1 };
	int dj[] = { 0, 0, 1, -1, 1, 1, -1, -1 };

	void go(int i, int j, int c) {
		for (int j2 = 0; j2 < 8; j2++) {
			int X = i + di[j2];
			int Y = j + dj[j2];
			if (X >= 0 && X < grid.length && Y >= 0 && Y < grid[X].length
					&& !memo[X][Y] && grid[X][Y] == -1) {
				grid[X][Y] = c;
				memo[X][Y] = true;
				go(X, Y, c);
			}
		}
	}

	// BEGIN CUT HERE

	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}

	static String tl = "";

	private static void printTree() {
		try {
			String[] drawing = new Util.treeDrawing.TreeDrawing()
					.draw(new String[] { tl });
			System.err.println(Arrays.deepToString(drawing)
					.replaceAll("\\[|\\]", "").replaceAll(", ", "\n")
					+ "\n");
		} catch (Exception ex) {
			System.err.println("invalid tree>" + tl);
		}
		tl = "";
	}

	private static void tn(Object... o) {
		tl += "(" + Arrays.deepToString(o).replaceAll(" |\\[|\\]", "") + ")";
	}

	private static void tb() {
		tl += "[]";
	}

	private static void tns() {
		tl += "[";
	}

	private static void tne() {
		tl += "]";
	}

	public static void main(String[] args) {
		if (args.length == 0) {
			LandAndSeaHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				LandAndSeaHarness.run_test(Integer.valueOf(args[i]));
		}
	}

	// END CUT HERE
}

// BEGIN CUT HERE
class LandAndSeaHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum
						+ " does not exist.");
			return;
		}

		int correct = 0, total = 0;
		for (int i = 0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100)
					break;
				continue;
			}
			correct += x;
			++total;
		}

		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of "
					+ total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}

	static boolean compareOutput(int[] expected, int[] result) {
		if (expected.length != result.length)
			return false;
		for (int i = 0; i < expected.length; ++i)
			if (expected[i] != result[i])
				return false;
		return true;
	}

	static String formatResult(int[] res) {
		String ret = "";
		ret += "{";
		for (int i = 0; i < res.length; ++i) {
			if (i > 0)
				ret += ",";
			ret += String.format(" %d", res[i]);
		}
		ret += " }";
		return ret;
	}

	static int verifyCase(int casenum, int[] expected, int[] received) {
		System.err.print("Example " + casenum + "... ");
		if (compareOutput(expected, received)) {
			System.err.println("PASSED");
			return 1;
		} else {
			System.err.println("FAILED");
			System.err.println("    Expected: " + formatResult(expected));
			System.err.println("    Received: " + formatResult(received));
			return 0;
		}
	}

	static int runTestCase(int casenum__) {
		switch (casenum__) {
		case 0: {
			String[] seaMap = { "x" };
			int[] expected__ = { 1 };

			return verifyCase(casenum__, expected__,
					new LandAndSea().howManyIslands(seaMap));
		}
		case 1: {
			String[] seaMap = { "xxxxx", "x...x", "x.x.x", "x...x", "xxxxx" };
			int[] expected__ = { 1, 1 };

			return verifyCase(casenum__, expected__,
					new LandAndSea().howManyIslands(seaMap));
		}
		case 2: {
			String[] seaMap = { "xxxxx", "x...x", "x.x.x", "x...x", "xxxxx",
					"xxxxx", "x...x", "x.x.x", "x...x", "xxxxx" };
			int[] expected__ = { 2, 1 };

			return verifyCase(casenum__, expected__,
					new LandAndSea().howManyIslands(seaMap));
		}
		case 3: {
			String[] seaMap = { "..", ".." };
			int[] expected__ = {};

			return verifyCase(casenum__, expected__,
					new LandAndSea().howManyIslands(seaMap));
		}
		case 4: {
			String[] seaMap = { 
					"............", 
					".......xxxx.", 
					"..xxx.x...x.",
					"..x..x..x.x.", "..x.x.x...x.", "..xx...xxx.." };
			int[] expected__ = { 1, 1 };

			return verifyCase(casenum__, expected__,
					new LandAndSea().howManyIslands(seaMap));
		}
		case 5: {
			String[] seaMap = {
					"xxxxxxxxxxxxxxxx",
					"x..............x", 
					"x..xxxxxxxxxxx.x", 
					"x..x.........x.x",
					"x..x..xxxxx..x.x",
					"x..x..x...x..x.x",
					"x..x..x.x.x..x.x",
					"x..x..x...x..x.x",
					"x..x..xxxxx..x.x",
					"x..x.........x.x",
					"x..xxxxxxxxxxx.x",
					"x..............x",
					"xxxxxxxxxxxxxxxx",
					"................",
					"xxxxxxx........x",
					"x.....x........x",
					"x.x.x.x........x",
					"x.....x........x",
					"xxxxxxx........x",};
			int[] expected__ = { 1, 1,1,1 };

			return verifyCase(casenum__, expected__,
					new LandAndSea().howManyIslands(seaMap));
		}
		// custom cases

		/*
		 * case 5: { String[] seaMap = ; int[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LandAndSea().howManyIslands(seaMap)); }
		 */
		/*
		 * case 6: { String[] seaMap = ; int[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LandAndSea().howManyIslands(seaMap)); }
		 */
		/*
		 * case 7: { String[] seaMap = ; int[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * LandAndSea().howManyIslands(seaMap)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
