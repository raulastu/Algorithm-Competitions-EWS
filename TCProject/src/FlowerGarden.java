import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class FlowerGarden {
	public int[] getOrdering(final int[] height, int[] bloom, int[] wilt) {
		b=bloom;
		w=wilt;
		h=height;
		int N = height.length;
		int [] res = new int[N];
		int x=0;
		boolean done[]=new boolean[N];
		for (int i = 0; i < N; i++) {
			int best = -1;
			
			dontchallengemeyouwillregret:for (int j = 0; j < N; j++) {
				if(done[j])continue;
				int best2=j;
				for (int j2 = 0; j2 < N; j2++) {
					if(done[j2]) continue;
					if(coll(best2,j2) && height[j2]<height[j]){
						best2=j2;
						continue dontchallengemeyouwillregret;
					}
				}
				if(best==-1 || height[best]<height[j])best=j;
			}
			done[best]=true;
			res[i]=height[best];
		}
		
		return res;
	}
	int[] b,w,h;
	int[][] rel;
	boolean co(int a, int b){
		if(rel[a][b]==1)return true;
//		if(a==b)return false;
		boolean r=false;
		for (int i = 0; i < rel.length; i++) {
			if(rel[a][i]==1){
				r = r || co(i,b);
			}
		}
		return r;
	}
	ArrayList<Integer> desc(int a){
		ArrayList<Integer> r = new ArrayList<Integer>();
		r.add(h[a]);
		for (int i = 0; i < rel.length; i++) {
			if(rel[a][i]==1){
				for (Integer integer : desc(i)) {
					if(!r.contains(integer))
						r.add(integer);
				}
				
			}
		}
		return r;
	}
	ArrayList<Integer> asc(int a){
		ArrayList<Integer> r = new ArrayList<Integer>();
		r.add(h[a]);
		for (int i = 0; i < rel.length; i++) {
			if(rel[i][a]==1){
				for (Integer integer : asc(i)) {
					if(!r.contains(integer))
						r.add(integer);
				}
				
			}
		}
		return r;
	}
	
	boolean coll(int i, int j){
		return collide(i,j) || collide(j,i);
		
	}
	boolean collide(int i,int j){
		if(b[i]>=b[j]&& b[i]<=w[j]) return true;
		if(w[i]>=b[j]&& w[i]<=w[j]) return true;
		return false;
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
			FlowerGardenHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				FlowerGardenHarness.run_test(Integer.valueOf(args[i]));
		}
	}

	// END CUT HERE
}

// BEGIN CUT HERE
class FlowerGardenHarness {
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
			int[] height = { 5, 4, 3, 2, 1 };
			int[] bloom = { 1, 1, 1, 1, 1 };
			int[] wilt = { 365, 365, 365, 365, 365 };
			int[] expected__ = { 1, 2, 3, 4, 5 };

			return verifyCase(casenum__, expected__,
					new FlowerGarden().getOrdering(height, bloom, wilt));
		}
		case 1: {
			int[] height = { 5, 4, 3, 2, 1 };
			int[] bloom = { 1, 5, 10, 15, 20 };
			int[] wilt = { 4, 9, 14, 19, 24 };
			int[] expected__ = { 5, 4, 3, 2, 1 };

			return verifyCase(casenum__, expected__,
					new FlowerGarden().getOrdering(height, bloom, wilt));
		}
		case 2: {
			int[] height = { 5, 4, 3, 2, 1 };
			int[] bloom = { 1, 5, 10, 15, 20 };
			int[] wilt = { 5, 10, 15, 20, 25 };
			int[] expected__ = { 1, 2, 3, 4, 5 };

			return verifyCase(casenum__, expected__,
					new FlowerGarden().getOrdering(height, bloom, wilt));
		}
		case 3: {
			int[] height = { 5, 4, 3, 2, 1 };
			int[] bloom = { 1, 5, 10, 15, 20 };
			int[] wilt = { 5, 10, 14, 20, 25 };
			int[] expected__ = { 3, 4, 5, 1, 2 };

			return verifyCase(casenum__, expected__,
					new FlowerGarden().getOrdering(height, bloom, wilt));
		}
		case 4: {
			int[] height = { 1, 2, 3, 4, 5, 6 };
			int[] bloom = { 1, 3, 1, 3, 1, 3 };
			int[] wilt = { 2, 4, 2, 4, 2, 4 };
			int[] expected__ = { 2, 4, 6, 1, 3, 5 };

			return verifyCase(casenum__, expected__,
					new FlowerGarden().getOrdering(height, bloom, wilt));
		}
		case 5: {
			int[] height = { 3, 2, 5, 4 };
			int[] bloom = { 1, 2, 11, 10 };
			int[] wilt = { 4, 3, 12, 13 };
			int[] expected__ = { 4, 5, 2, 3 };

			return verifyCase(casenum__, expected__,
					new FlowerGarden().getOrdering(height, bloom, wilt));
		}
		case 6: {
			int[] height = {355, 432, 141, 84, 544, 650, 777, 499, 709, 764}; 
			int[] bloom = {251, 18, 324, 87, 145, 118, 152, 52, 171, 160};
			int[] wilt = {293, 200, 344, 234, 197, 281, 275, 342, 261, 262};
			int[] expected__ = {293, 200, 344, 234, 197, 281, 275, 342, 261, 262};

			return verifyCase(casenum__, expected__,
					new FlowerGarden().getOrdering(height, bloom, wilt));
		}
//		, }

		// custom cases

		/*
		 * case 6: { int[] height = ; int[] bloom = ; int[] wilt = ; int[]
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FlowerGarden().getOrdering(height, bloom, wilt)); }
		 */
		/*
		 * case 7: { int[] height = ; int[] bloom = ; int[] wilt = ; int[]
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FlowerGarden().getOrdering(height, bloom, wilt)); }
		 */
		/*
		 * case 8: { int[] height = ; int[] bloom = ; int[] wilt = ; int[]
		 * expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * FlowerGarden().getOrdering(height, bloom, wilt)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
