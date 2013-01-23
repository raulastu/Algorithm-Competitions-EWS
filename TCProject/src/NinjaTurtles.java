import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class NinjaTurtles {
   public int countOpponents(int P, int K) {
	   int h=Integer.MAX_VALUE;
	   int l=0;
	   int min=Integer.MAX_VALUE;
	   while(l<h){
		   int m = (h+l+1)/2;
//		   print(l,h,m);
		   int x=(m/K)*3+(m/3);
		   if(x==P && min > m){
//			   print(lç,h,m,'x');
			   h=m;
			   min=min(min,m);
		   }else if(x<P){
			   l=m;
		   }else{
			   h=m-1;
		   }
		   
	   }
	   return min==Integer.MAX_VALUE?-1:min;
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
			NinjaTurtlesHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				NinjaTurtlesHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class NinjaTurtlesHarness {
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
			int P                     = 5;
			int K                     = 4;
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}
		case 1: {
			int P                     = 1;
			int K                     = 4;
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}
		case 2: {
			int P                     = 13;
			int K                     = 6;
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}
		case 3: {
			int P                     = 13;
			int K                     = 17;
			int expected__            = 30;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}
		case 4: {
			int P                     = 122;
			int K                     = 21;
			int expected__            = 258;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}

		// custom cases

/*      case 5: {
			int P                     = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}*/
/*      case 6: {
			int P                     = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}*/
/*      case 7: {
			int P                     = ;
			int K                     = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new NinjaTurtles().countOpponents(P, K));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
