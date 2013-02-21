import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;


public class MagicMoleculeEasy {
    public int maxMagicPower(int[] magicPower, String[] magicBond, int k) {
        int res;
        K=k;
//        print(((1<<0)&3));
//        if(true)return 1;
        this.magicBond=new char[magicBond.length][magicBond.length];
        this.magicPower=magicPower;
        for (int i = 0; i < magicBond.length; i++) {
			this.magicBond[i]=magicBond[i].toCharArray();
		}
        go(0, 0, 0);
        return MAX;
    }
    int N;
    int K;
    int MAX=-1;
    char [][] magicBond;
    int[]magicPower;
    void go(int i, int k, long kk){
//    	print(kk,list);
    	if(k==K){
    		int xx = check(kk);
//    		print(list,xx);
    		if(xx>-1){
    			MAX=max(MAX,xx);
//    			print(list);
    		}
    	}
    	if(k>K)
    		return;
    	if(i==magicPower.length)
    		return;
//    	kk = kk|(1<<i);
    	go(i+1, k+1,kk|(1<<i));
    	go(i+1, k,kk);
    }
    int check(long x){
    	int total=0;
//    	print(list, x);
    	for (int i = 0; i < magicPower.length; i++) {
    		long rr = (1<<i)&x;
			if(rr>0){
				total+=magicPower[i];
				continue;
			}	
			boolean connectedInside=false;
			boolean hasConnections=false;
			for (int j = 0; j < magicBond.length; j++) {
				if(j==i)continue;
				if(magicBond[i][j]=='Y'){
					hasConnections=true;
					if((1<<j&x)>0){
						connectedInside=true;
//						break;
					}else
						return -1;
				}
			}	
			if(hasConnections && !connectedInside)
				return -1;
		}
    	return total;
    }
    

// BEGIN CUT HERE



    public static void main(String[] args) {
        try {
            eq(0,(new MagicMoleculeEasy()).maxMagicPower(new int[] {1, 2}, new String[] {"NY",
                "YN"}, 1),2);
            eq(1,(new MagicMoleculeEasy()).maxMagicPower(new int[] {100, 1, 100}, new String[] {"NYN",
                "YNY",
                "NYN"}, 1),1);
            eq(2,(new MagicMoleculeEasy()).maxMagicPower(new int[] {100, 1, 100}, new String[] {"NYN",
                "YNY",
                "NYN"}, 2),200);
            eq(3,(new MagicMoleculeEasy()).maxMagicPower(new int[] {4, 7, 5, 8}, new String[] {"NYNY",
                "YNYN",
                "NYNY",
                "YNYN"}, 2),15);
            eq(4,(new MagicMoleculeEasy()).maxMagicPower(new int[] {46474, 60848, 98282, 58073, 42670, 50373}, new String[] {"NYNNNY", "YNNYNY", "NNNYYY", "NYYNNN", "NNYNNN", "YYYNNN"}, 3),209503);
            eq(5,(new MagicMoleculeEasy()).maxMagicPower(new int[] 
            		{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 
            		new String[] {
            		"NNYYYNYYNYNNY", 
            		"NNYNYYYYYYYNY", 
            		"YYNYYNYYYYYYY",
            		"YNYNYYNYYYYYY",
            		"YYYYNNYYYYYNY", 
	                "NYNYNNYYYYYNN", 
	                "YYYNYYNYYYYYY", 
	                "YYYYYYYNYNYYY",
	                "NYYYYYYYNYYYY", 
	                "YYYYYYYNYNNNN", 
	                "NYYYYYYYYNNYN", 
	                "NNYYNNYYYNYNN", 
	                "YYYYYNYYYNNNN"}, 9),-1);
            eq(6,(new MagicMoleculeEasy()).maxMagicPower(new int[] {1, 1}, new String[] {"NN", "NN"}, 1),1);
            eq(7,(new MagicMoleculeEasy()).maxMagicPower(new int[] {1,1,2,5,2,4,2}, new String[] {"NNNNNNN","NNYNNNN","NYNNNYN","NNNNNNY","NNNNNNN","NNYNNNN","NNNYNNN"}, 3),11);
            int [] ar = new int[50];
            fill(ar,1);
            String [] s =new String[50];
            String sx = "NNNNNNNNNN";
//            String sx = "YYYYYYYYYY";
            for (int i = 0; i < s.length; i++) {
            	s[i]=sx+sx+sx+sx+sx;
			}
            long a = System.currentTimeMillis();
            eq(8,(new MagicMoleculeEasy()).maxMagicPower(ar, s, 15),-1);
            System.err.println(System.currentTimeMillis()-a);
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
	private static void print(Object... rs) {
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
            print(received + "<" + a.length + "> ", a);
            print(expected + "<" + b.length + "> ", b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                print(received + " ", a);
                print(expected + " ", b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, long[] a, long[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            print(received + "<" + a.length + "> ", a);
            print(expected + "<" + b.length + "> ", b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                print(received, a);
                print(expected, b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, double[] a, double[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            print(received + "<" + a.length + "> ", a);
            print(expected + "<" + b.length + "> ", b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                print(received, a);
                print(expected, b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, String[] a, String[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: different lengths");
            print(received + "<" + a.length + "> ", (Object[]) a);
            print(expected + "<" + b.length + "> ", (Object[]) b);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                System.err.println("Case " + n + " failed. " + received + " and " + expected + " array differ in position " + i);
                print(received, (Object[]) a);
                print(expected, (Object[]) b);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }


    
    static String expected = "  expe";
    static String received = "  rc";
// END CUT HERE
}

// BEGIN CUT HERE

// END CUT HERE
