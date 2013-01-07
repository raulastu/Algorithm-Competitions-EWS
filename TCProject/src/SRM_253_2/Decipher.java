package SRM_253_2;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class Decipher {
    public String[] decipher(String[] encoded, String frequencyOrder) {
        String[] res;
        String s ="";
        for (int i = 0; i < encoded.length; i++) {
			s+=encoded[i];
		}
        char [] x=s.toCharArray();
        int [] frecuency= new int[26];
        
        for (int i = 0; i < x.length; i++) {
        	if(x[i]!=' ')
        		frecuency[x[i]-'A']++;
		}
        LinkedHashMap<String,Integer> map = new LinkedHashMap<String, Integer>();
        for (int i = 0; i < frecuency.length; i++) {
			map.put(((char)(i+'A'))+"",frecuency[i]);
		}
        map=sortByValue(map);
//        System.err.println(map);
        String mapString = "";
        for (String sx : map.keySet()) {
        	mapString+=sx;
		}
        Map<String,String> decipherMap = new HashMap<String,String>();
        for (int i = 0; i < frequencyOrder.length(); i++) {
        	decipherMap.put(mapString.charAt(i)+"",frequencyOrder.charAt(i)+"");
		}
//        System.err.println(decipherMap);
        decipherMap.put(" ", " ");
        for (int i = 0; i < encoded.length; i++) {
        	String r = "";
        	for (int  j= 0; j < encoded[i].length(); j++) {
				r+= decipherMap.get(encoded[i].charAt(j)+"");
			}
        	encoded[i]=r;
		}
        return encoded;
    }
    private static LinkedHashMap sortByValue(Map map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {

            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue()).compareTo(((Map.Entry) (o1)).getValue());
            }
        });
// logger.info(list);
        LinkedHashMap result = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0,(new Decipher()).decipher(new String[] { "ABBBCC" }, "XYZ"),new String[] {"ZXXXYY" });
            eq(1,(new Decipher()).decipher(new String[] { "RZLW" }, "CEFD"),new String[] {"EDCF" });
            eq(2,(new Decipher()).decipher(new String[] { "XX YYY Z YYY XX",
                 "WWWWWZWWWWW" }, "ETMQ"),new String[] {"MM TTT Q TTT MM", "EEEEEQEEEEE" });
            eq(3,(new Decipher()).decipher(new String[] { " X ",
                 "",
                 " ",
                 "  ",
                 "   " }, "B"),new String[] {" B ", "", " ", "  ", "   " });
            eq(4,(new Decipher()).decipher(new String[] { "RAZVLHAR KNW CNR",
                 "HEA HNFMNSAR NFAK" }, "EORTPNFHSCDIWG"),new String[] {"REGISTER NOW FOR", "THE TOPCODER OPEN" });
            String [] worstCase = new String[50];
            for (int i = 0; i < worstCase.length; i++) {
				worstCase[i]="ABCDEABCDEABCDEABCDEABCDEABCDEABCDEABCDE";
			}
            eq(4,(new Decipher()).decipher(worstCase, "EORTPNFHSCDIWG"),new String[] {"REGISTER NOW FOR", "THE TOPCODER OPEN" });
        } catch( Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }
    private static void eq( int n, int a, int b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, char a, char b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected '"+b+"', received '"+a+"'.");
    }
    private static void eq( int n, long a, long b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"L, received "+a+"L.");
    }
    private static void eq( int n, boolean a, boolean b ) {
        if ( a==b )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected "+b+", received "+a+".");
    }
    private static void eq( int n, String a, String b ) {
        if ( a != null && a.equals(b) )
            System.err.println("Case "+n+" passed.");
        else
            System.err.println("Case "+n+" failed: expected \""+b+"\", received \""+a+"\".");
    }
    private static void eq( int n, int[] a, int[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++)
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, long[] a, long[] b ) {
        if ( a.length != b.length ) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if ( a[i] != b[i] ) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void eq( int n, String[] a, String[] b ) {
        if ( a.length != b.length) {
            System.err.println("Case "+n+" failed: returned "+a.length+" elements; expected "+b.length+" elements.");
            return;
        }
        for ( int i= 0; i < a.length; i++ )
            if( !a[i].equals( b[i])) {
                System.err.println("Case "+n+" failed. Expected and returned array differ in position "+i);
                print( b );
                print( a );
                return;
            }
        System.err.println("Case "+n+" passed.");
    }
    private static void print( int a ) {
        System.err.print(a+" ");
    }
    private static void print( long a ) {
        System.err.print(a+"L ");
    }
    private static void print( String s ) {
        System.err.print("\""+s+"\" ");
    }
    private static void print( int[] rs ) {
        if ( rs == null) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( long[] rs) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print(rs[i]);
            if ( i != rs.length-1 )
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void print( String[] rs ) {
        if ( rs == null ) return;
        System.err.print('{');
        for ( int i= 0; i < rs.length; i++ ) {
            System.err.print( "\""+rs[i]+"\"" );
            if( i != rs.length-1)
                System.err.print(", ");
        }
        System.err.println('}');
    }
    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
