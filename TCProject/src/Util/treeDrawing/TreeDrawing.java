package Util.treeDrawing;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class TreeDrawing {
	int n;
	int NN=1000;
	String nodeNames[] = new String[NN];
	int leftChild[] = new int[NN];
	int rightChild[] = new int[NN];
	int depth[]=new int[NN];
	int parent[]=new int[NN];
	
	void depRec(int node, int d){
		depth[node]=d;
		if(leftChild[node]!=-1)
			depRec(leftChild[node],d+1);
		if(rightChild[node]!=-1){
			depRec(rightChild[node],d+1);
		}
		return;
	}
	
	public String[] draw(String[] tree) {
		fill(leftChild,-1);
		fill(rightChild,-1);
		n=0;
		String s="";
		for (int i = 0; i < tree.length; i++) {
			s+=tree[i];
		}
		LinkedList<Integer> V=new LinkedList<Integer>();
		while(s.length()>0){
			int t = s.indexOf("[");
			t=t<0?-1:t;
			int u = s.indexOf("]");
			u=u<0?-1:u;
			if(t==-1)t=99999;
			if(u==-1)u=99999;
			if(t<u){
				String tmp = s.substring(0,t);
				s= s.substring(t+1);//TODO NOT SURE
				nodeNames[n]=tmp;
				if(V.size()>0){
					if(leftChild[V.getLast()]==-1){
						leftChild[V.getLast()]=n;
					}else{
						rightChild[V.getLast()]=n;
					}
				}
				V.addLast(n);
				n++;
			}else{
				s=s.substring(1);
				V.removeLast();//TODO NOT SURE
			}
		}
//		print(V);
		
		depRec(0,0);
		for (int i = 0; i < n; i++) {
			if(leftChild[i]!=-1) parent[leftChild[i]]=i;
			if(rightChild[i]!=-1)parent[rightChild[i]]=i;
		}
//		print("nodeNames",nodeNames,depth,leftChild,rightChild);
		V.clear();
		for (int d = 100; d>=0; d--) {
			for (int t = 0; t < n; t++) {
				if(depth[t]==d){
					V.addLast(t);
				}
			}
		}
		LinkedList<String> REP[] = new LinkedList[NN];
		for (int i = 0; i < REP.length; i++) {
			REP[i]=new LinkedList<String>();
		}
		for (int tt = 0; tt < V.size(); tt++) {
			int node = V.get(tt);
			if(leftChild[node]==-1 && rightChild[node]==-1){
				String a = nodeNames[node];
				REP[node].addLast(a);
				continue;
			}
//			print(REP);
			if(rightChild[node]==-1){
				LinkedList<String> desc = new LinkedList<String>(REP[leftChild[node]]);
				int tmp = desc.get(desc.size()-1).indexOf(nodeNames[leftChild[node]]);
				int len = nodeNames[leftChild[node]].length();
				char[]S=new char[desc.getLast().length()];
				fill(S,' ');
				S[tmp+(len-1)/2]='|';
				desc.addLast(new String(S));
				String currName = nodeNames[node];
//				print("currName",currName);
				int pos = (currName.length()-1)/2;
				if(pos > (tmp+(len-1)/2)){
					int add = pos -(tmp+(len-1)/2);
					char add2[]=new char[add];
					fill(add2,' ');
					for (int u = 0; u < desc.size(); u++) {
						desc.set(u, new String(add2)+desc.get(u));
					}
					tmp+=add;
				}
				int offset = tmp+(len-1)/2-pos;
				for (int i = 0; i < offset; i++) {
					currName=" "+currName;
				}
				while(currName.length()<desc.get(0).length())
					currName+=" ";
				if(currName.length() > desc.get(0).length()){
					int A = currName.length()-desc.get(0).length();
					char B[] = new char[A];
					fill(B,' ');
					for (int p = 0; p < desc.size(); p++) {
						desc.set(p,desc.get(p)+new String(B));//TODO NOT SURE
					}
				}
				desc.addLast(currName);
				REP[node]=desc;
//				print("leftchildadded",REP);
				continue;
			}
			LinkedList<String> desc1 = new LinkedList<String>(REP[leftChild[node]]);
			LinkedList<String> desc2 = new LinkedList<String>(REP[rightChild[node]]);
			char A1[]=new char[desc1.getFirst().length()];
			fill(A1,' ');
			char B1[]=new char[desc2.getFirst().length()];
			fill(B1,' ');
			while(desc1.size() < desc2.size())
				desc1.addFirst(new String(A1));
			while(desc1.size() > desc2.size())
				desc2.addFirst(new String(B1));

			for (int p = 0; p < desc1.size(); p++) {
				desc1.set(p, desc1.get(p)+" ");
			}

			int minOffset=-9999;
			for (int i = 0; i < desc1.size(); i++) {
//				StringUtil.
				int k = findLastNotOf(desc1.get(i),' ');
				int l = findFirstNotOf(desc2.get(i),' ');
				if(l==-1 || k==-1)continue;
				minOffset=max(minOffset,2+k-l);
			}
//			print("descs",desc1,desc2,minOffset);
			if(minOffset<0){
				char BB[]=new char[-minOffset];
				fill(BB,' ');
				for (int t = 0; t < desc1.size(); t++) {
					desc1.set(t, new String(BB) + desc1.get(t));
				}
				minOffset=0;
			}
			int ADD = minOffset + desc2.get(0).length() - desc1.get(0).length();
//			MSG(ADD);
//			MSG(desc1.get(0).length());
			if(ADD >0){
				char [] ADD2= new char[ADD];
				fill(ADD2,' ');
				for (int i = 0; i < desc1.size(); i++) {
					desc1.set(i, desc1.get(i)+new String(ADD2));
				}
			}
			
//			print(minOffset);
//			print(desc1.get(0).length());
//			MSG(desc2.get(0).length()+minOffset);
//			if(desc2.get())
			for (int i = 0; i < desc2.size(); i++) {
				for (int j = 0; j < desc2.get(i).length(); j++) {
					if(desc2.get(i).charAt(j)!=' '){
						String x = desc1.get(i);
						char [] xx = x.toCharArray();
						xx[minOffset+j]=desc2.get(i).charAt(j);
						desc1.set(i,new String(xx));
					}
				}
			}
			
			int start = findFirstNotOf(desc1.getLast(),' ');
			int end = findLastNotOf(desc1.getLast(),' ');
			int dashes=0;
			for (int i = start; i < end; i++) {
				if(desc1.getLast().charAt(i)==' '){
					char[] ll=desc1.getLast().toCharArray();
					ll[i]='-';
					desc1.set(desc1.size()-1,new String(ll));
					dashes++;
				}	
			}
			
//			LinkedList<String> desc = desc1;
			LinkedList<String> desc = new LinkedList<String>(desc1);
			
			int tmp = desc.getLast().indexOf(nodeNames[leftChild[node]]);
			int len = nodeNames[leftChild[node]].length() + dashes+ nodeNames[rightChild[node]].length();
			char S[]=new char[desc.getLast().length()];
			fill(S,' ');
			S[tmp+(len-1)/2]='|';
			desc.add(new String(S));
			
			String currName = nodeNames[node];
			int pos = (currName.length()-1)/2;
			if(pos>(tmp+(len-1)/2)){
				int add = pos - (tmp+(len-1)/2);
				char add2[]=new char[add];
				fill(add2,' ');
				for (int u = 0; u < desc.size(); u++) {
					desc.set(u, new String(add2)+desc.get(u));
				}
				tmp+=add;
			}
			
			int offset = tmp+(len-1)/2-pos;
			for (int i = 0; i < offset; i++) {
				currName = " "+currName;
			}
			while(currName.length() < desc.get(0).length()){
				currName+=" ";
			}
			if(currName.length()>desc.get(0).length()){
				int A = currName.length()-desc.get(0).length();
				char B[]=new char[A];
				fill(B,' ');
				for (int p = 0; p < desc.size(); p++) {
					desc.set(p, desc.get(p)+new String(B));
				}
			}
			desc.addLast(currName);
			REP[node]=desc;
//			print("descs",desc1,desc2,minOffset,ADD);
		}
//		REV(REP[0]);
		Collections.reverse(REP[0]);
		
		int forwardSpace = 999999;
		int backwardSpace=0;
		for (int t = 0; t < REP[0].size(); t++) {
			forwardSpace = min(forwardSpace,findFirstNotOf(REP[0].get(t), ' '));
			backwardSpace = max(backwardSpace,findLastNotOf(REP[0].get(t), ' '));
		}
//		print("REP",REP);
		for (int t = 0; t < REP[0].size(); t++) {
			String a = REP[0].get(t);
			a=a.substring(0,backwardSpace+1);//TODO DUNNOT
			a=a.substring(forwardSpace);//TODO DUNNOT
			REP[0].set(t, a);
		}

//		print("REP",REP);
		String [] res = new String[REP[0].size()];
		for (int i = 0; i < REP[0].size(); i++) {
			res[i]=REP[0].get(i);
		}		
		return res;
	}
	public int findFirstNotOf(String x, char c){
		for (int i = 0; i <x.length(); i++) {
			if(x.charAt(i)!=c)
				return i;
		}
		return -1;
	}
	public int findLastNotOf(String x, char c){
		for (int i = x.length()-1; i >=0; i--) {
			if(x.charAt(i)!=c)
				return i;
		}
		return -1;
	}
	// BEGIN CUT HERE
	public static void main(String[] args) {
		if (args.length == 0) {
			TreeDrawingHarness.run_test(-1);
		} else {
			for (int i = 0; i < args.length; ++i)
				TreeDrawingHarness.run_test(Integer.valueOf(args[i]));
		}
	}

	private static void print(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
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
				line += a[i][j] + " ";
			}
			System.err.println("[" + line.trim() + "]");
		}
		System.err.println("");
	}

	// END CUT HERE
}

// BEGIN CUT HERE
class TreeDrawingHarness {
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

	static boolean compareOutput(String[] expected, String[] result) {
		if (expected.length != result.length)
			return false;
		for (int i = 0; i < expected.length; ++i)
			if (!expected[i].equals(result[i]))
				return false;
		return true;
	}

	static String formatResult(String[] res) {
		String ret = "";
		ret += "{";
		for (int i = 0; i < res.length; ++i) {
			if (i > 0)
				ret += ",";
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
		switch (casenum__) {
		case 0: {
			String[] tree = { "ALICE[BOB[DENISE[]EDITH[]]CONR",
					"OY[FRANCINE[GILBERT[]HARRY[]]]]" };
			String[] expected__ = { "         ALICE         ",
					"           |           ", "    BOB-------CONROY   ",
					"     |          |      ", "DENISE-EDITH FRANCINE  ",
					"                |      ", "          GILBERT-HARRY" };

			return verifyCase(casenum__, expected__,
					new TreeDrawing().draw(tree));
		}
		case 1: {
			String[] tree = { "A[B[C[DDDDDDDDDDDDDDD[]]E[]]F[G[H[]]I[]]]" };
			String[] expected__ = { "            A      ",
					"            |      ", "        B--------F ",
					"        |        | ", "       C-E      G-I",
					"       |        |  ", "DDDDDDDDDDDDDDD H  " };

			return verifyCase(casenum__, expected__,
					new TreeDrawing().draw(tree));
		}
		case 2: {
			String[] tree = { "A[BBBBB[]C[D[FFFFFFFFF[]]E[]]]" };
			String[] expected__ = { "   A      ", "   |      ", "BBBBB-C   ",
					"      |   ", "     D-E  ", "     |    ", " FFFFFFFFF" };

			return verifyCase(casenum__, expected__,
					new TreeDrawing().draw(tree));
		}
		case 3: {
			String[] tree = { "TOPCODERCOLLEGIATECHALLENGE[SEMIFINALROOMONE[",
					"TOMEK[ERYX[]ADRIANKUEGEL[MICKLE[]]]BSTANES",
					"CU[LARS[RALPHFURMANIAK[]]RUBERIK[]]]]" };
			String[] expected__ = { "    TOPCODERCOLLEGIATECHALLENGE ",
					"                 |              ",
					"          SEMIFINALROOMONE      ",
					"                 |              ",
					"      TOMEK----------BSTANESCU  ",
					"        |                |      ",
					"ERYX-ADRIANKUEGEL   LARS-RUBERIK",
					"          |          |          ",
					"        MICKLE RALPHFURMANIAK   " };

			return verifyCase(casenum__, expected__,
					new TreeDrawing().draw(tree));
		}
		case 4: {
			String[] tree = { "A[B[]C[ABCDEFGHIJK[]]]" };
			String[] expected__ = { "    A      ", "    |      ",
					"   B-C     ", "     |     ", "ABCDEFGHIJK" };

			return verifyCase(casenum__, expected__,
					new TreeDrawing().draw(tree));
		}

		// custom cases

		/*
		 * case 5: { String[] tree = ; String[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TreeDrawing().draw(tree)); }
		 */
		/*
		 * case 6: { String[] tree = ; String[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TreeDrawing().draw(tree)); }
		 */
		/*
		 * case 7: { String[] tree = ; String[] expected__ = ;
		 * 
		 * return verifyCase(casenum__, expected__, new
		 * TreeDrawing().draw(tree)); }
		 */
		default:
			return -1;
		}
	}
}

// END CUT HERE
