import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class PrimeAnagrams {
   public int[] primes(String anagram) {

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
			PrimeAnagramsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				PrimeAnagramsHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    
    

// END CUT HERE
}

// BEGIN CUT HERE
class PrimeAnagramsHarness {
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
	
	static boolean compareOutput(int[] expected, int[] result) { if (expected.length != result.length) return false; for (int i=0; i<expected.length; ++i) if (expected[i] != result[i]) return false; return true; }

	static String formatResult(int[] res) {
		String ret = "";
		ret += "{";
		for (int i=0; i<res.length; ++i) {
			if (i > 0) ret += ",";
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
		switch(casenum__) {
		case 0: {
			String anagram            = "39151";
			int[] expected__          = { 5, 13, 19 };

			return verifyCase(casenum__, expected__, new PrimeAnagrams().primes(anagram));
		}
		case 1: {
			String anagram            = "921179";
			int[] expected__          = { 2, 17, 199 };

			return verifyCase(casenum__, expected__, new PrimeAnagrams().primes(anagram));
		}
		case 2: {
			String anagram            = "01123";
			int[] expected__          = { 2, 3, 101 };

			return verifyCase(casenum__, expected__, new PrimeAnagrams().primes(anagram));
		}
		case 3: {
			String anagram            = "0707070";
			int[] expected__          = { };

			return verifyCase(casenum__, expected__, new PrimeAnagrams().primes(anagram));
		}
		case 4: {
			String anagram            = "222";
			int[] expected__          = { 2, 2, 2 };

			return verifyCase(casenum__, expected__, new PrimeAnagrams().primes(anagram));
		}
		case 5: {
			String anagram            = "123";
			int[] expected__          = { };

			return verifyCase(casenum__, expected__, new PrimeAnagrams().primes(anagram));
		}

		// custom cases

/*      case 6: {
			String anagram            = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new PrimeAnagrams().primes(anagram));
		}*/
/*      case 7: {
			String anagram            = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new PrimeAnagrams().primes(anagram));
		}*/
/*      case 8: {
			String anagram            = ;
			int[] expected__          = ;

			return verifyCase(casenum__, expected__, new PrimeAnagrams().primes(anagram));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
