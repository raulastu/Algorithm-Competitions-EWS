import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class UndoHistory {
    public int minPresses(String[] lines) {
        int res=0;
        HashSet<String> set = new HashSet<String>();
        set.add("");
        String buff="";
//        for (int i = 0; i < lines.length; i++) {
//        	int lower=0;
//        	if(lines[i].startsWith(buff)){
//    			lower=buff.length();
//    		}
//        	for (int j = 0; j <=lines[i].length() ; j--) {
//        		String a=lines[i].substring(0,j);
//        		pr(buff,res,a,set);
//				if(set.contains(a)){
//					res+=2;
//					buff=a;
////					for (int k = j; k<=lines[i].length(); k++) {
////						set.add(lines[i].substring(0,k));
////					}
//					break;
//				}else{
//					set.add(a);
//					res++;
//				}	
//			}
//        	buff+=lines[i];
//		}
        this.lines=lines;
        int x = go(0,0,"",new HashSet<String>());
        return x;
    }
    String []lines;
    int go(int i, int j, String buffer, HashSet<String> undo){
    	int r=0;
    	pr(i,j);
    	if(i==lines.length){
    		return 0;
    	}
    	if(j==lines[i].length()){
    		return 1+go(i+1,0,buffer,undo);
    	}	
    	
    	if(!buffer.equals("") &&lines[i].substring(j).startsWith(buffer)){
    		r+=go(i,buffer.length(),buffer,undo);
    	}else{
    		boolean found=false;
    		int k = lines[i].length();
    		for ( ; k-1 > j; k--) {
    			String ss = lines[i].substring(j,k);
    			if(undo.contains(ss)){
    				buffer=ss;
    				found=true;
    				break;
//    				r+=2;
    			}	
			}
    		if(found){
    			pr("found",buffer);
    			r+=2+go(i,k,buffer,undo);
    		}else{
    			if(j==0 && !buffer.equals("")){
    				r+=2;
    				buffer="";
    			}
    			buffer+=lines[i].charAt(j);
    			undo.add(buffer);
    			r+=1+go(i, j+1, buffer, undo);
    		}
    	}
    	return r;
    }

// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new UndoHistory()).minPresses(new String[] {"tomorrow", "topcoder"}),18);
            eq(1,(new UndoHistory()).minPresses(new String[] {"a","b"}),6);
            eq(2,(new UndoHistory()).minPresses(new String[] {"a", "ab", "abac", "abacus" }),10);
            eq(3,(new UndoHistory()).minPresses(new String[] {"pyramid", "sphinx", "sphere", "python", "serpent"}),39);
//            eq(4,(new UndoHistory()).minPresses(new String[] {"ba","a","a","b","ba"}
//               ),13);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
	private static void pr(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}

   private static void eq(int n, int a, int b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " " + a + " " + expected + " " + b + ".");
        }
    }

    private static void eq(int n, double a, double b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " '" + a + "' " + expected + " '" + b + "'.");
        }
    }

    private static void eq(int n, char a, char b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " '" + a + "' " + expected + " '" + b + "'.");
        }
    }

    private static void eq(int n, long a, long b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " '" + a + "L' " + expected + " '" + b + "L'.");
        }
    }

    private static void eq(int n, boolean a, boolean b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " '" + a + "' " + expected + " '" + b + "'.");
        }
    }

    private static void eq(int n, String a, String b) {
        if (a != null && a.equals(b)) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: " + received + " \"" + a + "\" " + expected + " \"" + b + "\".");
        }
    }

    private static void eq(int n, int[] a, int[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            pr(received + "<" + a.length + "> ", a);
            pr(expected + "<" + b.length + "> ", b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                pr(received + " ", a);
                pr(expected + " ", b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, long[] a, long[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            pr(received + "<" + a.length + "> ", a);
            pr(expected + "<" + b.length + "> ", b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                pr(received, a);
                pr(expected, b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, double[] a, double[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            pr(received + "<" + a.length + "> ", a);
            pr(expected + "<" + b.length + "> ", b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                pr(received, a);
                pr(expected, b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, String[] a, String[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            pr(received + "<" + a.length + "> ", (Object[]) a);
            pr(expected + "<" + b.length + "> ", (Object[]) b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                pr(received, (Object[]) a);
                pr(expected, (Object[]) b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }
    
    static String expected = "  expe";
    static String received = "  rc";
// END CUT HERE
}
