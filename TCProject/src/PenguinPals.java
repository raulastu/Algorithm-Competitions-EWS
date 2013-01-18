import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class PenguinPals {
   public int findMaximumMatching(String colors) {
	   LinkedList<Character> l = new LinkedList<Character>();
	   for (int i = 0; i < colors.length(); i++) {
		   l.add(colors.charAt(i));
	   }
	   int s=0;
	   int r=0;
	   while(s!=l.size() && l.size()>1){
//		   print(l);
		   s=l.size();
		   if(l.get(0)==l.get(l.size()-1)){
			   l.remove(0);
			   l.remove(l.size()-1);
			   r++;
		   }
		   for (int i = 1; i < l.size(); i++) {
			   if(l.get(i)==l.get(i-1)){
				   l.remove(i);
				   l.remove(i-1);
				   r++;
			   }   
		   }
	   }
//	   print(l);
	   return r+((l.size()>2)?(l.size()/2-1):0);
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
			PenguinPalsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				PenguinPalsHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class PenguinPalsHarness {
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
			String colors             = "RRBRBRBB";
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 1: {
			String colors             = "RRRR";
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 2: {
			String colors             = "BBBBB";
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 3: {
			String colors             = "RBRBRBRBR";
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 4: {
			String colors             = "RRRBRBRBRBRB";
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 5: {
			String colors             = "R";
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 6: {
			String colors             = "RBRRBBRB";
			int expected__            = 3;

			return verifyCase(casenum__, expected__, new PenguinPals().findMaximumMatching(colors));
		}
		case 7: {
			String colors             = "RBRBBRBRB";
			int expected__            = 4;

			return verifyCase(casenum__, expected__, new PenguinPals().findMaximumMatching(colors));
		}

		// custom cases

/*      case 8: {
			String colors             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PenguinPals().findMaximumMatching(colors));
		}*/
/*      case 9: {
			String colors             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PenguinPals().findMaximumMatching(colors));
		}*/
/*      case 10: {
			String colors             = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PenguinPals().findMaximumMatching(colors));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
