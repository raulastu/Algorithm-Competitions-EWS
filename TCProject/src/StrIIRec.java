import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class StrIIRec {
    public String recovstr(int n, int minInv, String minStr) {
    	if(n*(n-1)/2<minInv)return "";
    	ArrayList<Character> curr = new ArrayList<Character>();
    	ArrayList<Character> rest = new ArrayList<Character>();
    	for (int i = 0; i < minStr.length(); i++) {
    		curr.add(minStr.charAt(i));
		}
    	sort(curr);
    	int added=0;
    	if(n>minStr.length())
	    	for (int i = 0; i < 23; i++) {
	    		char x =(char)('a'+i);
				if(!minStr.contains(x+"")){
					rest.add((char)('a'+i));
					added++;
					if(added>=n-minStr.length())
						break;
				}
			}
    	sort(rest);
    	char[] restc = new char[rest.size()];
    	String rc="";
    	for (int i = 0; i < restc.length; i++) {
    		restc[i]=rest.get(i);
    		rc+=restc[i];
		}
    	int c= count(minStr+rc);
    	if(c>=minInv)
    		return minStr+rc;
    	
    	for (int i = restc.length-1;i>=0; i--) {
			for (int j = i-1; j >=0; j--) {
				char t = restc[j];
				restc[j]=restc[i];
				restc[i]=t;
				if(count(minStr+new String(restc))>=minInv){
					return minStr+new String(restc);
				}
			}
		}
    	String xxx = new String(restc);
    	char [] xx = (minStr+xxx).toCharArray();
    	for (int i = xx.length-1; i >=0 ;i--) {
			for (int j = i-1; j >=0; j--) {
				if(xx[j]<xx[i]){
					char t = xx[j];
					xx[j]=xx[i];
					xx[i]=t;
					int co=count(new String(xx));
//					pr(new String(xx)+co);
					if(co>=minInv){
						return new String(xx);
					}
				}
			}
		}
        return "";
    }
    
    int count(String x){
    	int res=0;
    	for (int i = 0; i < x.length(); i++) {
			for (int j = i+1; j < x.length(); j++) {
				if(x.charAt(i)>x.charAt(j))
					res++;
			}
		}
    	return res;
    }
// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new StrIIRec()).recovstr(2, 1, "ab"),"ba");
            eq(1,(new StrIIRec()).recovstr(9, 1, "efcdgab"),"efcdgabhi");
            eq(2,(new StrIIRec()).recovstr(11, 55, "debgikjfc"),"kjihgfedcba");
            eq(3,(new StrIIRec()).recovstr(15, 0, "e"),"eabcdfghijklmno");
            eq(4,(new StrIIRec()).recovstr(9, 20, "fcdebiha"),"fcdehigba");
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