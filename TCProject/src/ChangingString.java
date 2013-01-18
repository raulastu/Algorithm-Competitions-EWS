import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class ChangingString {
   public int distance(String A, String B, int K) {
	   int dis[]=new int[A.length()];
	   for (int i = 0; i < dis.length; i++) {
		   dis[i]=abs((int)(A.charAt(i)-B.charAt(i)));
	   }
	   sort(dis);
	   for (int i = 0; i < K; i++) {
		   if(dis[dis.length-1-i]==0)
			   dis[dis.length-1-i]=1;
		   else
			   dis[dis.length-1-i]=0;
	   }
	   int res=0;
	   for (int i = 0; i < dis.length; i++) {
		   res+=dis[i];
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
			ChangingStringHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ChangingStringHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class ChangingStringHarness {
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
	
	static boolean compareOutput(int expected, int result) { return expected == result; }
	static String formatResult(int res) {
		return String.format("%d", res);
	}
	
	static int verifyCase(int casenum, int expected, int received) { 
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
			String A                  = "ab";
			String B                  = "ba";
			int K                     = 2;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new ChangingString().distance(A, B, K));
		}
		case 1: {
			String A                  = "aa";
			String B                  = "aa";
			int K                     = 2;
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new ChangingString().distance(A, B, K));
		}
		case 2: {
			String A                  = "aaa";
			String B                  = "baz";
			int K                     = 1;
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new ChangingString().distance(A, B, K));
		}
		case 3: {
			String A                  = "fdfdfdfdfdsfabasd";
			String B                  = "jhlakfjdklsakdjfk";
			int K                     = 8;
			int expected__            = 24;

			return verifyCase(casenum__, expected__, new ChangingString().distance(A, B, K));
		}
		case 4: {
			String A                  = "aa";
			String B                  = "bb";
			int K                     = 2;
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new ChangingString().distance(A, B, K));
		}

		// custom cases

/*      case 5: {
			String A                  = ;
			String B                  = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ChangingString().distance(A, B, K));
		}*/
/*      case 6: {
			String A                  = ;
			String B                  = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ChangingString().distance(A, B, K));
		}*/
/*      case 7: {
			String A                  = ;
			String B                  = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ChangingString().distance(A, B, K));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
