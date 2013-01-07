package SRM236_2;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;
import java.util.*;

public class ComputerExpert {
    public String[] operate(String[] facts, String[] rules) {
        String[] res;
        ArrayList<String> resl=new ArrayList<String>();
        HashMap<String,String[]> factsMap = new HashMap<String, String[]>();
        for (int i = 0; i < rules.length; i++) {
			String factsToMeetS = rules[i].split(" -> ")[0];
			String resultingFact = rules[i].split(" -> ")[1];
			String factsToMeet[] = factsToMeetS.split(",");
//			sort(factsToMeet);
			if(factsMap.containsKey(resultingFact)){
				int n=0;
				while(factsMap.containsKey(resultingFact+n)){
					n++;
				}
				factsMap.put(resultingFact+n,factsToMeet);
			}else{
				factsMap.put(resultingFact,factsToMeet);
			}
			
		}
//        for (String key: factsMap.keySet()) {
//        	String [] string= factsMap.get(key);
//        	print(key,string);
//		}
        
        int sizeOf= -1;
        ArrayList<String> respnse = new ArrayList<String>();
        for (int i = 0; i < facts.length; i++) {
			resl.add(facts[i]);
		}
        while(resl.size() != sizeOf){
        	sizeOf=resl.size();
        	for (String key: factsMap.keySet()) {
//        		if(key.equals("N1")){
//        			System.err.println("breakPoint");
//        		}
        		String string[]= factsMap.get(key);
        		
        		String key1=key.replaceAll("[0-9]+", "");
//        		System.err.println(key);
        		
        		if(!resl.contains(key1)){
            		boolean containsAllrules=true;
        			for (int i = 0; i < string.length; i++) {
        				if(string[i].contains("/")){
        					String [] ors = string[i].split("/");
//        					print(ors);
        					boolean containsAtLeast1Or=false;
        					for (int j = 0; j < ors.length; j++) {
        						if(resl.contains(ors[j])){
        							containsAtLeast1Or=true;
        							break;
        						}
							}
        					if(!containsAtLeast1Or){
        						containsAllrules=false;
        						break;
        					}
        				}
        				else if(!resl.contains(string[i])){
    						containsAllrules=false;
    						break;
    					}
    				}
    				if(containsAllrules){
    					respnse.add(key1);
    					resl.add(key1);
    				}
				}
			}
//        	System.out.println(resl);
        }
//        System.err.println(resl);
        sort(respnse);
        return respnse.toArray(new String[respnse.size()]);
    }

// BEGIN CUT HERE
    void print(Object... ob){
    	System.err.println(Arrays.deepToString(ob));
    }
    
    public static void main(String[] args) {
        try {
            eq(0,(new ComputerExpert()).operate(new String[] {"SKY_IS_CLOUDY","HAVE_MONEY"}, new String[] {"HAVE_MONEY,BAD_WEATHER -> WATCH_MOVIE","SKY_IS_CLOUDY -> BAD_WEATHER",
               "GOOD_WEATHER -> PLAY_SOCCER"}),new String[] {"BAD_WEATHER", "WATCH_MOVIE" });
            eq(1,(new ComputerExpert()).operate(new String[] {"NEEDLE_LEAF","KEEPS_LEAVES"}, new String[] {"KEEPS_LEAVES -> EVERGREEN","NEEDLE_LEAF -> GYMNOSPERM",
               "EVERGREEN,GYMNOSPERM -> PINE_TREE"}),new String[] {"EVERGREEN", "GYMNOSPERM", "PINE_TREE" });
            eq(2,(new ComputerExpert()).operate(new String[] {"I"}, new String[] {"I -> I","P -> CONSONANT", "Z -> CONSONANT", "A/E/I/O/U -> VOWEL"}),new String[] {"VOWEL" });
            eq(3,(new ComputerExpert()).operate(new String[] {"Y","W","L","T","H","J","G","T","F","P","T","P","P","N"}, new String[] {"C/V,J,F/T,N,W,L -> M","N/L,F,B/N/E,Y -> C",
               "M,G,G,S/F/Q,G,S/G,H/Z,W,F,C,Q/F,M -> E"}),new String[] {"C", "E", "M" });
            eq(4,(new ComputerExpert()).operate(new String[] {"G","H"}, new String[] {"A/B/C/D/E/F,G/Z -> Y", "H,H,H,H,H,H,H,H -> Z"}),new String[] {"Z" });
            eq(5,(new ComputerExpert()).operate(new String[] {"A","B","_X", "X_"}, new String[] {"A/B,C -> D","A,B,C -> D","X -> Y","_X_ -> Y"}),new String[] { });
            
            eq(6,(new ComputerExpert()).operate(new String[] 
            		{"M", "L", "K", "S", "V", "C", "X", "K", "B", "B", "F", "B", "Q", "G", "N", "L", "R", "C"},
            		new String[] {"O,S,N,M,X/L,W,E -> J", "P,E,Q/N,M,R,B,Y/J,R -> Q", "M,D/J/F/K -> Z",
            		"H,E,L,E/I,Q,R,W,R/R -> N"}),new String[] {"Z"});
            eq(7,(new ComputerExpert()).operate(new String[] 
            		{"K", "I", "F", "T", "Y", "I", "X", "S", "H", "I", "V", "K", "T", "L", "Y", "K", "L", "S", "P", "B", "C", "D", "H", "X", "F", "T", "Z", "K", "M", "O", "Y", "B", "L", "Z", "W"},
            		new String[] {"N,I,K,G/V,L -> E", "Y,U,Z,A/M,I/I -> P", "D -> B", "T,E,W/W/G/T,R,B -> U", "J,K,Q,L,Y -> B", "Z,G,Z/J,J,B,B,G/P,D -> Y", "H,H,L/Q,N,M -> W", "F,R/O/J,X,H,F/D,W,U/W,L,F,V -> K", "X,J,G,B/K,G,B,Q/J,W,C,H/W,C,F,F,A/R -> G", "H,W,F/E,Y,C,H/V,J,B,T/Z,Q,V,U,D/T,N,S,P -> V", "V,A,N,Q,D/B,N,E,U,B/H,H,O/C,L/Y,H -> P", "U,J,Q,G/I,J,T,G,T/O/C -> L", "P,C,Y,E,U/O/F,X/L,F,A,O/W,U,V -> E", "J,N,I,S/L,S,O,N/T,Q,E,U,H/X -> A", "F/R,P,K/C,N,Q,Z,A/S,D,I/R,R,Q,S -> S", "I,S,Q,R,Q/E,L,I/S,P/Y,L -> I", "F -> Q", "I,Z,C/Y,Y,Q,F,G/Q/G,J/L -> K", "Q,Z,G/I,H,Y/Z,D,Z,B,H/V/I,E,Z -> P", "E,J,U,P,V/K,J -> F", "D,A,P,D/K,U,Z,H/B,V/Q,L,K,X -> B", "O,O,X,F/A/Y,N,U/O,P -> Z", "N,F,W,I,G/M,F -> T", "J,D/C,G,C,J,N/U,E/L,P -> P", "I,T,B,Y/P,C/Z,X/Y,U,K,Q,L/F,N,K,K,C -> Y", "Z/V/E,C -> A", "J,E,X,V/A/M,Q -> X", "K,R,Q/M/L -> L", "J,T,L,G,E -> T", "C,B -> O", "L/F,N,K,Q,K -> N", "E,W,B,A/Z,F,E,J/B,N,M -> K", "E,Q,Y,M,Z/D -> J", "R,F/X,Y,R/E,Y,E/J,P,A,V/N,A -> J", "I,G,I,Y/G/H -> E", "U/W/K,A,V/K,Q,N,M,W -> S", "V,A,K,Z,L/I,U,G,Z -> H", "B,P,J/P,V,H,P,P/V,N,X/E,X,F,T/D,M,U -> U", "N/B/Y,J/J,G,N,R,T -> H", "X -> S", "N -> M", "P,D/M,B,M/D,T,M,Q,H/Z,P,R,L -> A"}),
            		new String[] {"A", "Q"});
            

//        	eq(6,(new ComputerExpert()).operate(new String[] 
//            		{"D", "U", "F", "J", "A", "L", "C", "U", "I", "W", "V", "B", "I", 
//            		"X", "C", "X", "K", "B", "O", "V", "S", "T", "V", "F", "V", "I", 
//            		"L", "H", "S", "C", "Q", "O", "W", "S", "G", "Y", "A", "I", "I",
//            		"U", "H", "E", "F", "S", "X", "X", "W", "Y", "P", "C"},
//            		new String[] {
//        			"L,Z,S/L,E/Y,W,B,G,D/X,J,C -> D", 
//        			"F,Z,Q/T -> Z", 
//        			"P -> L", 
//        			"R,M,Z,S,Q/P,L,S,V,T/V,X,A,B/M,O,I,V -> H", 
//        			"U/B/A/B,W -> F", "L,E,V,T,B/V,W,F -> G",
//        			"D,Q,J/M -> T", "Q,J,J,P,A/R/Q,N,Y -> N", 
//        			"K,E,N,F,B/A,D/Y,E,Q,G/R,I -> A", 
//        			"Y,C,C,L/E,P,W,I -> X", "T,E,D -> S", 
//        			"G,V,E,W -> R", "M,A,F,M,M/A,W -> E", "Y,R/A,X,Z,H,V -> S", "A,H,Z,M,V/M,H,B/O,V,W/N,W,X,I,G/K,J,U -> P", "C,U,J,D/B/G,I,O,V,E/S,E,A,C,Z/X,X,V,Z,N -> J", "F,T,H,H/I,T,K/I,D,N,A,B -> V", "A,K/A,X -> S", "S,N/K,D/A/R,Y/R,Z -> N", "Y/B,S,R,Y,R/X,D,V/D,I,U/U,T,Q -> C", "J,E,U,M,O -> G", "R,G,V,E -> B", "I,I/Y,A,E,S/I,K,Q,F,F -> N", "S -> H", "X/F,Q/A/Z,G,T/N -> E", "W,N,Q,Y,C/K,W,D,J,L/W,I,B,T -> Q", "E,K,Y/A,L/E,B,H,O,W -> M", "F,M,K,W,P/W,H,M,E/E,B,U,S,T -> L", "I/N,Q,L,D/E,X,F,G,K/R,Y -> O", "S,F,A,T,L -> B", "L,I,J/M,S,E,N/R,Z,O,S/M,F,S,W,T/M -> X", "P,Z,Y,Q,M/L,Q/C,D,T,U/Y/T,Z,C -> C", "K,H,E,B -> H", "F,G,G/W,Q,T,L/Q,U,J,L,U -> J", "F/E,O/Y,U,Y,T,P -> U", "T,Y,R,F,L/N,U,R/Q,W,W,Q,Q/P,G,V,M/J,T,Q -> W", "Y,V,D,L,E/X,G -> V", "V/F,V,Y/G,I/P,E -> E", "N,W/T -> T", "K,X/D,M,L,M/V/G,N,M,B/O,V,Q,I -> S", "E,I,H,C,P/V,V,U,C,L/R,V,Z/L -> S", "R/I,G,H,K,X/U,D -> X", "G,I/N,R,W,Y,H/I,O,P -> P", "Y/Z,L/E,B,E,W,R/V/S -> J", "B,U,P,M,J/G,Q/W,E,E,D,S/Z,P,N,P -> X", "A,F,E/I/T,M,H,C,A -> Y",
//            		}),new String[] {"M,N,R"});
//        	
        	eq(6,(new ComputerExpert()).operate(new String[] 
            		{"D", "U", "F", "J", "A", "L", "C", "U", "I", "W", "V", "B", "I", 
            		"X", "C", "X", "K", "B", "O", "V", "S", "T", "V", "F", "V", "I", 
            		"L", "H", "S", "C", "Q", "O", "W", "S", "G", "Y", "A", "I", "I",
            		"U", "H", "E", "F", "S", "X", "X", "W", "Y", "P", "C"},
            		new String[] {"L,Z,S/L,E/Y,W,B,G,D/X,J,C -> D", "F,Z,Q/T -> Z", "P -> L", "R,M,Z,S,Q/P,L,S,V,T/V,X,A,B/M,O,I,V -> H", "U/B/A/B,W -> F", "L,E,V,T,B/V,W,F -> G", "D,Q,J/M -> T", "Q,J,J,P,A/R/Q,N,Y -> N", "K,E,N,F,B/A,D/Y,E,Q,G/R,I -> A", "Y,C,C,L/E,P,W,I -> X", "T,E,D -> S", "G,V,E,W -> R", "M,A,F,M,M/A,W -> E", "Y,R/A,X,Z,H,V -> S", "A,H,Z,M,V/M,H,B/O,V,W/N,W,X,I,G/K,J,U -> P", "C,U,J,D/B/G,I,O,V,E/S,E,A,C,Z/X,X,V,Z,N -> J", "F,T,H,H/I,T,K/I,D,N,A,B -> V", "A,K/A,X -> S", "S,N/K,D/A/R,Y/R,Z -> N", "Y/B,S,R,Y,R/X,D,V/D,I,U/U,T,Q -> C", "J,E,U,M,O -> G", "R,G,V,E -> B", "I,I/Y,A,E,S/I,K,Q,F,F -> N", "S -> H", "X/F,Q/A/Z,G,T/N -> E", "W,N,Q,Y,C/K,W,D,J,L/W,I,B,T -> Q", "E,K,Y/A,L/E,B,H,O,W -> M", "F,M,K,W,P/W,H,M,E/E,B,U,S,T -> L", "I/N,Q,L,D/E,X,F,G,K/R,Y -> O", "S,F,A,T,L -> B", "L,I,J/M,S,E,N/R,Z,O,S/M,F,S,W,T/M -> X", "P,Z,Y,Q,M/L,Q/C,D,T,U/Y/T,Z,C -> C", "K,H,E,B -> H", "F,G,G/W,Q,T,L/Q,U,J,L,U -> J", "F/E,O/Y,U,Y,T,P -> U", "T,Y,R,F,L/N,U,R/Q,W,W,Q,Q/P,G,V,M/J,T,Q -> W", "Y,V,D,L,E/X,G -> V", "V/F,V,Y/G,I/P,E -> E", "N,W/T -> T", "K,X/D,M,L,M/V/G,N,M,B/O,V,Q,I -> S", "E,I,H,C,P/V,V,U,C,L/R,V,Z/L -> S", "R/I,G,H,K,X/U,D -> X", "G,I/N,R,W,Y,H/I,O,P -> P", "Y/Z,L/E,B,E,W,R/V/S -> J", "B,U,P,M,J/G,Q/W,E,E,D,S/Z,P,N,P -> X", "A,F,E/I/T,M,H,C,A -> Y",
            		}),new String[] {"M","N","R"});
            
            eq(7,(new ComputerExpert()).operate(
            		new String[]{"M", "L", "K", "S", "V", "C", "X", "K", "B", "B", "F", "B", "Q", "G", "N", "L", "R", "C"},
            		new String[] {
            				"O,S,N,M,X/L,W,E -> J",
            		"P,E,Q/N,M,R,B,Y/J,R -> Q", 
            		"D/J/F/K -> Z", 
            		"H,E,L,E/I,Q,R,W,R/R -> N", 
            		"O,F,M/G -> O", 
            		"D/L,K,E,N -> P", 
            		"M,W -> V", 
            		"B,O,T,M/O,X,Q,D,M -> W", 
            		"J,C,G/H,Q/W,R,Q,E/J,B -> U",
            		"N,N/F,L,H/N,N,G,L/J,A -> G", 
            		"Q,L/K,Y,W,D,A -> J", 
            		"X,P,D,H/P,N,G/D -> I", 
            		"W,I/O,B,X,L/H,T,Y,N,V/R,U,L/C,Q,M -> C",
            		"S/K,A -> Z", 
            		"E,Q,A/P,I,S,O/L,Y,R,F,Z/U,L,Y/D,T,T -> M", 
            		"E,F,E,U,V/V,L/Z,J/Q,I,M,H,S -> U", 
            		"C,C,I/N,A,D/W,S,P/V,X/V,V,G,A -> W", 
            		"L,G,M,V/V,M/J/C,H,W -> H",
            		"P,O,I/L,K,J,H,N -> P", 
            		"I,H,G/B/F,Q -> C", 
            		"R,W/R,C,P,W,A/U,I,O -> Z",
            		"B,G,Y/T,Q,G/O,G,H -> C", 
            		"N,Q,L,U,B/Z/N,U,Q,E,O/N,Z,R,S,J/X,F -> Z", 
            		"C,R,T,H/D,B,N/C,H,C,S/V,V,Q/B,Y -> E",
            		"N,E,B,G,F/Y,T,K,V,N/X/H,U,E,T,J -> X", 
            		"V,Z/U,O,Z/F,S,X/H/G,C,O,Q -> F", 
            		"E,A/U,U/N,A,T,T,E/D,I,W,V,X/U,N,I -> V", 
            		"C,K,M/C,V/J,M/C,C,Y,U/Z,Y,W -> P", 
            		"H,L,R,J,D/W,R,J,Z -> H", 
            		"W,Z,F,I,V/A,D,P,J/A,D,Y,S/Z,V,B,E,P/E,H,Q -> A", 
            		"C,O -> G", "W/H,S,K,D -> K"}),new String[] {"Z"});
//            
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

// BEGIN CUT HERE
// PROBLEM STATEMENT

// A human expert uses his prior knowledge to analyze a set of observations that are presented to him. These days, companies are starting to explore the benefits of computerized expert systems. Expert systems attempt to model the way human experts think and arrive at conclusions. Knowledge obtained in this way is more reliable, cheaper and reproducible.
/*
facts contains all the observations presented to the expert. rules is a set of rules that the expert can use to arrive at new conclusions. rules will be formatted as (<FACT>/.../<FACT>),...,(<FACT>/.../<FACT>) -> <FACT>. In the input, '/' represents the OR operator and ',' represents the AND operator.  Hence, the above input represents a boolean expression like (<FACT> OR ... OR <FACT>) AND ... AND (<FACT> OR ... OR <FACT>) -> <FACT>.  Each <FACT> represents a sequence of uppercase characters and the character '_'. Note: brackets and parentheses are only used for clarity and are not part of the input.

A rule composed solely of AND will fire only if all the facts listed in the rule are known. Similarly, a rule composed solely of OR will fire if any of the facts listed in the rule are known. Once a rule has fired, its outcome fact can be added to the knowledge of the expert (if not already known).

Given a String[] of facts and a String[] of rules return a String[] of all outcome facts, sorted in ascending alphabetical order. If there are no outcome facts then return an empty String[].

DEFINITION
Class:ComputerExpert
Method:operate
Parameters:String[], String[]
Returns:String[]
Method signature:String[] operate(String[] facts, String[] rules)


CONSTRAINTS
-facts will contain between 1 and 50 elements inclusive.
-Each element of facts will contain between 1 and 50 characters inclusive.
-Elements of facts will only contain characters 'A'-'Z' and the character '_'.
-rules will contain between 1 and 50 elements inclusive.
-Each element of rules will contain between 6 and 50 characters inclusive.
-Each element in rules will be formatted as (<FACT>/.../<FACT>),...,(<FACT>/.../<FACT>) -> <FACT>. In the input, '/' represents the OR operator and ',' represents the AND operator. Each <FACT> must be a sequence of uppercase characters 'A'-'Z' and the character '_'. Note: brackets and parentheses are only used for clarity and are not part of the input.


EXAMPLES

0)
{"SKY_IS_CLOUDY","HAVE_MONEY"}
{"HAVE_MONEY,BAD_WEATHER -> WATCH_MOVIE","SKY_IS_CLOUDY -> BAD_WEATHER",
"GOOD_WEATHER -> PLAY_SOCCER"}

Returns: {"BAD_WEATHER", "WATCH_MOVIE" }

In this simplistic example we want to decide whether to watch a movie or play soccer. We observe that SKY_IS_CLOUDY and that we HAVE_MONEY. The second rule tells us that if SKY_IS_CLOUDY then we have BAD_WEATHER. So we conclude that the weather is bad. Knowing this fact, we can now use the first rule that tells us that if we HAVE_MONEY and BAD_WEATHER then we WATCH_MOVIE. So we choose to watch a movie. The third rule never gets fired.

1)
{"NEEDLE_LEAF","KEEPS_LEAVES"}
{"KEEPS_LEAVES -> EVERGREEN","NEEDLE_LEAF -> GYMNOSPERM",
"EVERGREEN,GYMNOSPERM -> PINE_TREE"}

Returns: {"EVERGREEN", "GYMNOSPERM", "PINE_TREE" }

In this example we try to classify a plant. Since it has a NEEDLE_LEAF we know its a GYMNOSPERM. Since it KEEPS_LEAVES we know its an EVERGREEN. An EVERGREEN and a GYMNOSPERM must be a PINE_TREE.

2)
{"I"}
{"I -> I","P -> CONSONANT", "Z -> CONSONANT", "A/E/I/O/U -> VOWEL"}

Returns: {"VOWEL" }

I is a VOWEL. Note that there is no point firing the first rule, because we already know the outcome fact I.

3)
{"Y","W","L","T","H","J","G","T","F","P","T","P","P","N"}
{"C/V,J,F/T,N,W,L -> M","N/L,F,B/N/E,Y -> C",
"M,G,G,S/F/Q,G,S/G,H/Z,W,F,C,Q/F,M -> E"}

Returns: {"C", "E", "M" }

4)
{"G","H"}
{"A/B/C/D/E/F,G/Z -> Y", "H,H,H,H,H,H,H,H -> Z"}

Returns: {"Z" }

5)
{"A","B","_X", "X_"}
{"A/B,C -> D","A,B,C -> D","X -> Y","_X_ -> Y"}

Returns: { }

Here there are no rules fired. Note that "_X" and "X_" are not the same as "X" or "_X_".
*/
// END CUT HERE
