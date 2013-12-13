package Sets;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class ICPCBalloons {

   public int minRepaintings(int[] balloonCount, String balloonSize, int[] maxAccepted) {
	   
	   ArrayList<Integer> M = new ArrayList<Integer>();
	   ArrayList<Integer> L = new ArrayList<Integer>();
	   int ballonTotalM=0,ballonTotalL=0;
	   for (int i = 0; i < balloonCount.length; i++) {
		   if(balloonSize.charAt(i)=='M'){
			   M.add(balloonCount[i]);
			   ballonTotalM+=balloonCount[i];
		   }else {
			   L.add(balloonCount[i]);
			   ballonTotalL+=balloonCount[i];
		   }
		   
	   }
	   sort(L);
	   sort(M);
	   int res = Integer.MAX_VALUE;
	   int n = maxAccepted.length;
	   for (int mask = 0; mask < (1<<n); mask++) {
		   ArrayList<Integer> a1 = new ArrayList<Integer>();
		   ArrayList<Integer> a2 = new ArrayList<Integer>();
		   int ta1=0,ta2=0;
		   for (int i = 0; i < n; i++) {
			   if((mask & (1<<i)) > 0){
				   a1.add(maxAccepted[i]);
				   ta1+=maxAccepted[i];
			   }else{
				   	a2.add(maxAccepted[i]);
			   		ta2+=maxAccepted[i];
			   }   
		   }
//		   print(a1,M);
//		   print(a2,L);
		   int res1=go(a1,M,ta1,ballonTotalM);
		   int res2=go(a2,L,ta2,ballonTotalL);
		   if(res1==-1 || res2==-1)
			   continue;
//		   System.err.println(res1+" "+res2);
		   res = min(res,res1+res2);
	   }
	   return res==Integer.MAX_VALUE?-1:res;
   }
   
   int go(ArrayList<Integer> accepteds, ArrayList<Integer>balloons, int t, int ballonTotal){
	   if(ballonTotal<t)
		   return -1;
	   if(accepteds.size()==0)return 0;
	   
	   sort(accepteds);
	   int j = balloons.size()-1;
	   
	   int res = 0;
	   
	   for (int i = accepteds.size()-1; i >=0; i--) {
		   int acc = accepteds.get(i);
		   if(j>=0){
			   int bal = balloons.get(j);
			   if(bal>=acc){
				   ballonTotal-=acc;
			   }else{
				   res+=(acc-bal);
			   }   
		   }else{
			   res+=acc;
		   }
		   j--;
	   }
	   return res;
   }

// BEGIN CUT HERE
   public static void main(String[] args) {
		if (args.length == 0) {
			ICPCBalloonsHarness.run_test(-1);
		} else {
			for (int i=0; i<args.length; ++i)
				ICPCBalloonsHarness.run_test(Integer.valueOf(args[i]));
		}
	}

    private static void print(Object... rs) {
        System.err.println(Arrays.deepToString(rs));
    }

    private static void printm(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.err.println("[" + a[i] + "]");
        }
    }

    private static void printm(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.err.println("[" + new String(a[i]) + "]");
        }
    }
    
    private static void printm(int[][] a) {
    	System.err.println("");
        for (int i = 0; i < a.length; i++) {
        	String line = "";
        	for (int j = 0; j < a[i].length; j++) {
				line+=a[i][j]+" ";
			}
            System.err.println("[" + line.trim() + "]");
        }
        System.err.println("");
    }
    

// END CUT HERE
}

// BEGIN CUT HERE
class ICPCBalloonsHarness {
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
			int[] balloonCount        = {100};
			String balloonSize        = "L";
			int[] maxAccepted         = {1,2,3,4,5};
			int expected__            = 10;

			return verifyCase(casenum__, expected__, new ICPCBalloons().minRepaintings(balloonCount, balloonSize, maxAccepted));
		}
		case 1: {
			int[] balloonCount        = {100};
			String balloonSize        = "M";
			int[] maxAccepted         = {10,20,30,40,50};
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new ICPCBalloons().minRepaintings(balloonCount, balloonSize, maxAccepted));
		}
		case 2: {
			int[] balloonCount        = {5,6,1,5,6,1,5,6,1};
			String balloonSize        = "MLMMLMMLM";
			int[] maxAccepted         = {7,7,4,4,7,7};
			int expected__            = 6;

			return verifyCase(casenum__, expected__, new ICPCBalloons().minRepaintings(balloonCount, balloonSize, maxAccepted));
		}
		case 3: {
			int[] balloonCount        = {100,100};
			String balloonSize        = "ML";
			int[] maxAccepted         = {50,51,51};
			int expected__            = -1;

			return verifyCase(casenum__, expected__, new ICPCBalloons().minRepaintings(balloonCount, balloonSize, maxAccepted));
		}
		case 4: {
			int[] balloonCount        = {8,5,1,4,1,1,3,1,3,3,5,4,5,6,9};
			String balloonSize        = "MMMLLLMMLLMLMLM";
			int[] maxAccepted         = {3,5,3,3,5,6,4,6,4,2,3,7,1,5,2};
			int expected__            = 5;

			return verifyCase(casenum__, expected__, new ICPCBalloons().minRepaintings(balloonCount, balloonSize, maxAccepted));
		}
		case 5: {
			int[] balloonCount        = {1,18,4,7,19,7,7,1,4,8,10,5,14,13,8,22,6,3,13,5,3,4,2,1,3,15,19,4,5,9,4,11,2,7,12,20,11,26,22,7,2,10,9,20,13,20,2,9,11,9};
			String balloonSize        = "LLMLLLLMLLLLLLLLLLLLMLLLLLLLLLLMMLMLLLMLLLLLLLLMLL";
			int[] maxAccepted         = {44,59,29,53,16,23,13,14,29,42,13,15,66,4,47};
			int expected__            = 210;

			return verifyCase(casenum__, expected__, new ICPCBalloons().minRepaintings(balloonCount, balloonSize, maxAccepted));
		}

		// custom cases

/*      case 6: {
			int[] balloonCount        = ;
			String balloonSize        = ;
			int[] maxAccepted         = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ICPCBalloons().minRepaintings(balloonCount, balloonSize, maxAccepted));
		}*/
/*      case 7: {
			int[] balloonCount        = ;
			String balloonSize        = ;
			int[] maxAccepted         = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ICPCBalloons().minRepaintings(balloonCount, balloonSize, maxAccepted));
		}*/
/*      case 8: {
			int[] balloonCount        = ;
			String balloonSize        = ;
			int[] maxAccepted         = ;
			int expected__            = ;

			return verifyCase(casenum__, expected__, new ICPCBalloons().minRepaintings(balloonCount, balloonSize, maxAccepted));
		}*/
		default:
			return -1;
		}
	}
}

// END CUT HERE
