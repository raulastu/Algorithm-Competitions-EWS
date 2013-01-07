package DFS;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class LinearCity {
   public String[] getReference(int[] refSource, int[] refDestination, String refDirection, int N, int[] source, int[] destination) {
	   int [][]left = new int[N][N+1];
	   int [][]right = new int[N][N+1];
	   this.N=N;
	   for (int i = 0; i < refSource.length; i++) {
		   if(refDirection.charAt(i)=='L'){
			   left[refSource[i]][refDestination[i]]=1;
			   right[refDestination[i]][refSource[i]]=1;
		   }else{
			   right[refSource[i]][refDestination[i]]=1;
			   left[refDestination[i]][refSource[i]]=1;
		   }
	   }
//	   print(left,right);
//	   print(left);	   
	   String [] res = new String[source.length];
	   for (int i = 0; i < source.length; i++) {
		   if(go(source[i],destination[i],left)){
			   res[i]="LEFT";
		   }
		   else if(go(source[i],destination[i],right)){
			   res[i]="RIGHT";
		   }else{
			   res[i]="UNKNOWN";
		   }
	   }
	   return res;
   }
   int N;
   boolean go(int i, int lookup, int[][] dir){
	   if(i==lookup) return true;
	   boolean res = false;
	   for (int j = 0; j < N; j++) {
		   if(dir[i][j]==1){
			   res = res || go(j,lookup, dir);
		   }
	   }
	   return res;
   }


// BEGIN CUT HERE

	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}
	
	static String tl="";
	private static void printTree() {
		try{
			String[] drawing = new Util.treeDrawing.TreeDrawing().draw(new String[]{tl});
			System.err.println(Arrays.deepToString(drawing).replaceAll("\\[|\\]", "").replaceAll(", ", "\n")+"\n");
		}catch (Exception ex){
			System.err.println("invalid tree>"+tl);
		}	
		tl="";
	}
	private static void tn(Object...o){tl+="("+Arrays.deepToString(o).replaceAll(" |\\[|\\]", "")+")";}
	private static void tb(){tl+="[]";}
	private static void tns(){tl+="[";}
	private static void tne(){tl+="]";}
   

public static void main(String[] args) {
		if (args.length == 0) {
			LinearCityHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				LinearCityHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class LinearCityHarness {
	public static void run_test(int casenum) {
		if (casenum != -1) {
			if (runTestCase(casenum) == -1)
				System.err.println("Illegal input! Test case " + casenum + " does not exist.");
			return;
		}
		
		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = runTestCase(i);
			if (x == -1) {
				if (i >= 100) break;
				continue;
			}
			correct += x;
			++total;
		}
		
		if (total == 0) {
			System.err.println("No test cases run.");
		} else if (correct < total) {
			System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
		} else {
			System.err.println("All " + total + " tests passed!");
		}
	}
	
	static boolean compareOutput(String[] expected, String[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (!expected[i].equals(result[i])) return false; return true; }

	static String formatResult(String[] res) {
		String ret = "";
		ret += "{";
		for (int i=0; i<res.length; ++i) {
			if (i > 0) ret += ",";
			ret += String.format(" \"%s\"", res[i]);
		}
		ret += " }";
		return ret;
	}
	
	static int verifyCase(int casenum, String[] expected, String[] received) { 
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
		switch(casenum__) {
		case 0: {
			int[] refSource           = {1, 2};
			int[] refDestination      = {2, 0};
			String refDirection       = "RR";
			int N                     = 3;
			int[] source              = {1, 0};
			int[] destination         = {0, 1};
			String[] expected__       = {"RIGHT", "LEFT" };

			return verifyCase(casenum__, expected__, new LinearCity().getReference(refSource, refDestination, refDirection, N, source, destination));
		}
		case 1: {
			int[] refSource           = {1, 0};
			int[] refDestination      = {2, 2};
			String refDirection       = "RL";
			int N                     = 3;
			int[] source              = {1, 0};
			int[] destination         = {0, 1};
			String[] expected__       = {"RIGHT", "LEFT" };

			return verifyCase(casenum__, expected__, new LinearCity().getReference(refSource, refDestination, refDirection, N, source, destination));
		}
		case 2: {
			int[] refSource           = {2, 3, 1, 0, 2, 0, 5, 5};
			int[] refDestination      = {1, 4, 4, 4, 4, 3, 2, 3};
			String refDirection       = "RLRLRLLL";
			int N                     = 6;
			int[] source              = {0, 1, 0};
			int[] destination         = {2, 3, 5};
			String[] expected__       = {"LEFT", "RIGHT", "UNKNOWN" };

			return verifyCase(casenum__, expected__, new LinearCity().getReference(refSource, refDestination, refDirection, N, source, destination));
		}
		case 3: {
			int[] refSource           = {1, 0, 2, 3};
			int[] refDestination      = {0, 2, 3, 2};
			String refDirection       = "RRRL";
			int N                     = 5;
			int[] source              = {0, 2, 3, 0, 4};
			int[] destination         = {2, 4, 1, 1, 0};
			String[] expected__       = {"RIGHT", "UNKNOWN", "LEFT", "LEFT", "UNKNOWN" };

			return verifyCase(casenum__, expected__, new LinearCity().getReference(refSource, refDestination, refDirection, N, source, destination));
		}
		case 4: {
			int[] refSource           = {6, 0, 0, 5, 2, 4, 1, 1, 1, 6, 2, 0, 2, 2, 3, 1, 5, 1, 5, 6, 0};
			int[] refDestination      = {4, 6, 4, 2, 6, 3, 2, 4, 5, 5, 3, 1, 0, 4, 0, 6, 4, 3, 3, 3, 5};
			String refDirection       = "RLRLRRRRRRRLRRLRRRRRL";
			int N                     = 7;
			int[] source              = {5, 6, 2, 4, 6, 2, 4};
			int[] destination         = {0, 0, 0, 5, 2, 5, 6};
			String[] expected__       = {"RIGHT", "RIGHT", "RIGHT", "LEFT", "LEFT", "RIGHT", "LEFT" };

			return verifyCase(casenum__, expected__, new LinearCity().getReference(refSource, refDestination, refDirection, N, source, destination));
		}

		// custom cases

/*      case 5: {
			int[] refSource           = ;
			int[] refDestination      = ;
			String refDirection       = ;
			int N                     = ;
			int[] source              = ;
			int[] destination         = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new LinearCity().getReference(refSource, refDestination, refDirection, N, source, destination));
		}*/
/*      case 6: {
			int[] refSource           = ;
			int[] refDestination      = ;
			String refDirection       = ;
			int N                     = ;
			int[] source              = ;
			int[] destination         = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new LinearCity().getReference(refSource, refDestination, refDirection, N, source, destination));
		}*/
/*      case 7: {
			int[] refSource           = ;
			int[] refDestination      = ;
			String refDirection       = ;
			int N                     = ;
			int[] source              = ;
			int[] destination         = ;
			String[] expected__       = ;

			return verifyCase(casenum__, expected__, new LinearCity().getReference(refSource, refDestination, refDirection, N, source, destination));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
