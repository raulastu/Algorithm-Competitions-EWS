import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class PenguinTiles {
   public int minMoves(String[] tiles) {
	   int x=0,y=0;
	   for (int i = 0; i < tiles.length; i++) {
		   if(tiles[i].indexOf(".")>=0){
			  x=i;y= tiles[i].indexOf(".");
			  break;
		   }
	   }
	   
	   int a = ((tiles.length-1-x)>=1?1:0);
	   int b = (tiles[0].length()-1-y)>=1?1:0;
//	   print(x,y,a,b);
	   return a+b;
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
			PenguinTilesHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				PenguinTilesHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class PenguinTilesHarness {
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
			String[] tiles            = {"PP",
 "P."};
			int expected__            = 0;

			return verifyCase(casenum__, expected__, new PenguinTiles().minMoves(tiles));
		}
		case 1: {
			String[] tiles            = {"PPPPPPPP",
 ".PPPPPPP"};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new PenguinTiles().minMoves(tiles));
		}
		case 2: {
			String[] tiles            = {"PPP",
 "P.P",
 "PPP"};
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new PenguinTiles().minMoves(tiles));
		}
		case 3: {
			String[] tiles            = {"P.",
 "PP",
 "PP",
 "PP"};
			int expected__            = 1;

			return verifyCase(casenum__, expected__, new PenguinTiles().minMoves(tiles));
		}
		case 4: {
			String[] tiles            = {".PPP",
 "PPPP",
 "PPPP",
 "PPPP"};
			int expected__            = 2;

			return verifyCase(casenum__, expected__, new PenguinTiles().minMoves(tiles));
		}

		// custom cases

/*      case 5: {
			String[] tiles            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PenguinTiles().minMoves(tiles));
		}*/
/*      case 6: {
			String[] tiles            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PenguinTiles().minMoves(tiles));
		}*/
/*      case 7: {
			String[] tiles            = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new PenguinTiles().minMoves(tiles));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
