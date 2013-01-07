package SRM_214_DIV_2;

// BEGIN CUT HERE
// END CUT HERE
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bloggoSequenceSearch {

    public String[] findPassages(String[] documents, String query) {        
        TreeSet<String> tree = new TreeSet<String>();
        String pat = "(?i)\\b" + query.replace("...", "\\b.*?\\b") + "\\b";
        Pattern p = Pattern.compile(pat);
        for (int i = 0; i < documents.length; i++) {            
            Matcher mat = p.matcher(documents[i]);
            for (int j = 0; mat.find(j); j=mat.start()+2) {
                String st =zeroF(mat.group().length()) + " " + zeroF(i) + " " + zeroF(mat.start()) + " [" + mat.group() + "]";
                tree.add(st);
            }
        }
        String pat2 = "(?i)\\b" + query.replace("...", "\\b.+\\b") + "\\b";
        p = Pattern.compile(pat2);
        for (int i = 0; i < documents.length; i++) {
            Matcher mat = p.matcher(documents[i]);
            for (int j = 0; mat.find(j); j=mat.start()+2) {
                String st =zeroF(mat.group().length()) + " " + zeroF(i) + " " + zeroF(mat.start()) + " [" + mat.group() + "]";
                tree.add(st);
            }
            
            for (int j = documents[i].length();j>=0; j-=3) {
                mat = p.matcher(documents[i].substring(0, j));
                if(mat.find()){
                    String str = zeroF(mat.group().length()) + " " + zeroF(i)+" " + zeroF(mat.start()) + " [" + mat.group() + "]";
                    tree.add(str);
                }
            }
        }
        //System.out.println(tree);
        return topFive(tree);
    }

    String zeroF(int n){
        return n<10?"0"+n:n+"";
    }

    String[] topFive(TreeSet<String> tree) {
        String[] top = new String[tree.size() > 5 ? 5 : tree.size()];
        for (int i = 0; i < top.length; i++) {
            top[i] = Integer.parseInt(tree.first().split(" ")[1])+" "+
                    Integer.parseInt(tree.first().split(" ")[2])+" "+
                    tree.first().split(" ",4)[3];
            tree.remove(tree.first());
        }
        return top;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new bloggoSequenceSearch()).findPassages(new String[]{"But in a larger sense we can not dedicate --",
                        "we can not consecrate -- we can not hallow this",
                        "ground. The brave men, living and dead, who",
                        "struggled, here, have consecrated it far above",
                        "our poor power to add or detract. The world will",
                        "little note, nor long remember, what we say here,",
                        "but can never forget what they did here. It is",
                        "for us, the living, rather to be dedicated here",
                        "to the unfinished work which they have, thus",
                        "far, so nobly carried on. It is rather for us",
                        "to be here dedicated to the great task remaining",
                        "before us -- that from these honored dead we take",
                        "increased devotion to that cause for which they",
                        "here gave the last full measure of devotion --",
                        "that we here highly resolve that these dead",
                        "shall not have died in vain; that this nation",
                        "shall have a new birth of freedom; and that",
                        "this government of the people, by the people,",
                        "for the people, shall not perish from the earth."}, "the...People"), new String[]{"17 19 [the people]", "17 34 [the people]", "18 4 [the people]", "17 19 [the people, by the people]"});
            eq(1, (new bloggoSequenceSearch()).findPassages(new String[]{"But in a larger sense we can not dedicate --",
                        "we can not consecrate -- we can not hallow this",
                        "ground. The brave men, living and dead, who",
                        "struggled, here, have consecrated it far above",
                        "our poor power to add or detract. The world will",
                        "little note, nor long remember, what we say here,",
                        "but can never forget what they did here. It is",
                        "for us, the living, rather to be dedicated here",
                        "to the unfinished work which they have, thus",
                        "far, so nobly carried on. It is rather for us",
                        "to be here dedicated to the great task remaining",
                        "before us -- that from these honored dead we take",
                        "increased devotion to that cause for which they",
                        "here gave the last full measure of devotion --",
                        "that we here highly resolve that these dead",
                        "shall not have died in vain; that this nation",
                        "shall have a new birth of freedom; and that",
                        "this government of the people, by the people,",
                        "for the people, shall not perish from the earth."}, "Shall...The"), new String[]{"18 16 [shall not perish from the]"});
            eq(2, (new bloggoSequenceSearch()).findPassages(new String[]{"But in a larger sense we can not dedicate --",
                        "we can not consecrate -- we can not hallow this",
                        "ground. The brave men, living and dead, who",
                        "struggled, here, have consecrated it far above",
                        "our poor power to add or detract. The world will",
                        "little note, nor long remember, what we say here,",
                        "but can never forget what they did here. It is",
                        "for us, the living, rather to be dedicated here",
                        "to the unfinished work which they have, thus",
                        "far, so nobly carried on. It is rather for us",
                        "to be here dedicated to the great task remaining",
                        "before us -- that from these honored dead we take",
                        "increased devotion to that cause for which they",
                        "here gave the last full measure of devotion --",
                        "that we here highly resolve that these dead",
                        "shall not have died in vain; that this nation",
                        "shall have a new birth of freedom; and that",
                        "this government of the people, by the people,",
                        "for the people, shall not perish from the earth."}, "wE...nOT"), new String[]{"0 22 [we can not]", "1 0 [we can not]", "1 25 [we can not]", "1 0 [we can not consecrate -- we can not]"});
            eq(3, (new bloggoSequenceSearch()).findPassages(new String[]{"But in a larger sense we can not dedicate --",
                        "we can not consecrate -- we can not hallow this",
                        "ground. The brave men, living and dead, who",
                        "struggled, here, have consecrated it far above",
                        "our poor power to add or detract. The world will",
                        "little note, nor long remember, what we say here,",
                        "but can never forget what they did here. It is",
                        "for us, the living, rather to be dedicated here",
                        "to the unfinished work which they have, thus",
                        "far, so nobly carried on. It is rather for us",
                        "to be here dedicated to the great task remaining",
                        "before us -- that from these honored dead we take",
                        "increased devotion to that cause for which they",
                        "here gave the last full measure of devotion --",
                        "that we here highly resolve that these dead",
                        "shall not have died in vain; that this nation",
                        "shall have a new birth of freedom; and that",
                        "this government of the people, by the people,",
                        "for the people, shall not perish from the earth."}, "we...can...not"), new String[]{"0 22 [we can not]", "1 0 [we can not]", "1 25 [we can not]", "1 0 [we can not consecrate -- we can not]"});
            eq(4, (new bloggoSequenceSearch()).findPassages(new String[]{"B A b B B A b a A B b b b a a a B a A b a B B b b ",
                        "A B b b A a A b A A a b b A A a A a A b A a A B b ",
                        "B B a A a a A A A b A b b a a B B b a A a A b a A ",
                        "a b b b b A B a A A A A a b A b A A B a A b b a A ",
                        "A b a A b B B a b A A A A B A A B a A B a b b b B ",
                        "A A A b b a a a A b b b a A A b a B a a B b B a b ",
                        "B A B A a b A B a B b A b B b b A B A A a B A b B ",
                        "A A b B a a b B b a b a A A A B A b b b b A b b A ",
                        "B B A A B B A b a a b a a A B B A A B B A B b A b ",
                        "A a A b B B b A a b b B A a B b b A B b a a a b b ",
                        "B B a b A A a b a A a A a B B A B A A a B B b a B ",
                        "B b B B a B A B b B B a A a a a b b B a A A b a A ",
                        "b B a a a B b a A a A b a a A b A B b a B a b A A ",
                        "A A b B b A a B a a a b B A b B B a b B b b b B B ",
                        "b B a A A A B B b b b b a b B B a a a b B b A A B ",
                        "a B A a a a a A A B A A B b a b A A a A a a B B B ",
                        "B B A B b B B a b B A B A b b A b A B A A b A a b ",
                        "B A A A b A B a b b b a b b b a a A A b A b a A b ",
                        "A a B B B A B b b A B a B a A b B b b a B A B b a ",
                        "B a A A B a a b b B b B A A a A b a a b b b a B b ",
                        "a a b A B a b B B B A A B a B b B A b B b a b A B ",
                        "A a a b a A b B A b B a A B a a A B a A b a b a B ",
                        "A b A b b A b b a B b a A a b A a A A A A a A b A ",
                        "a B B A a B B a b B b a B b A a B B B a B a a b a ",
                        "a a A b B B B a A B a B a A a B a a B b A B b b B ",
                        "A a A B A A A b b B A A a A b B b a A b B A b b A ",
                        "A A a a b B A b a b a A A A B B b B A a A B A B b ",
                        "b a b B a A B a a b B B B A b a A a A A A a a A b ",
                        "a b a a B a B b a B B A A b a B A B b A b a A a a ",
                        "b a a B a a b A B A a b a B A B b b B A b A a b a ",
                        "a B b B a a a A b B B A b b b A A B A b b b B b A ",
                        "B B a A b b a B B b A a a A B B A a A b a a B A A ",
                        "a A a A b b B B a B B b a b b A B a B A a a b a A ",
                        "A B A A a a b A b A B B A b A B b B B a a a A b a ",
                        "b A B b b b a b b A A a A B b B B A a b b B a b a ",
                        "A B B b b a a a B A B b b a b A a a B A b B A B B ",
                        "A b B b B a b a B B B B A a A a a B B b b a b A A ",
                        "B B a a b B a A b A A A a A a b b b a B B A a B a ",
                        "A B a a B A B B a B B b b a B a b b A A B b A A b ",
                        "B b a a A a B b B a b A B B B A b B b A A B a a B ",
                        "B b b A B a a b a B a b A A b B a b b a A B B a A ",
                        "A A b A a a a a B B b b b b A B A B B a B b A a a ",
                        "B B B A b A a a a B a B b b B b a A a b b A B a B ",
                        "A B b b B a b A b B b A B A A A a B B a A b b b B ",
                        "B a A B A b b A b b a A A b b b A B a b B a b A b ",
                        "B a a B a B A b B A b b a b B a b a A b b a A b B ",
                        "a b b a A b A a A B B a b B B a A B A a b B a a a ",
                        "b b a A a a A a a B b A B a A B B a A a B A b A a ",
                        "b b B b B a a b a B B A B b A b A a b b B A B b a ",
                        "a b a B a A B a A A A A A a B a A A a B a b b b b "}, "a...b...a...b...a...a...b...b...a...a...b...b"), new String[]{"45 24 [a b B a b a A b b a A b B]", "8 12 [A b a a b a a A B B A A B B]", "18 18 [A B a B a A b B b b a B A B b]", "40 16 [a B a b A A b B a b b a A B B]", "47 16 [a B b A B a A B B a A a B A b]"});
            eq(5, (new bloggoSequenceSearch()).findPassages(new String[]{"this government of the people, by the people,",
                        "for the people, shall not perish from the earth."}, "people"), new String[]{"0 23 [people]", "0 38 [people]", "1 8 [people]"});
            eq(6, (new bloggoSequenceSearch()).findPassages(
                    new String[]{"a;A?a.a-a.A(A a(A.A A,A,A!a!a a(A)a(A,a,A)a,a.a-A", "A,A,a A?a;a;A?a?a?A?A)a(a!A.a A(A(a-a?a(A;a;A a!A", "a!A,A A!a,a-a a.A.a a-a a?a!a(A,A,a A.A;a A a-a)A", "A?a.a a?a A!A!A A-a A!a-a)A A-A.a,a(A!a(A.A.a)a)a", "A-a)a.A-A-A;a.a(A;A(A(a)a!a,A.a!A,A(a(A;A A?A.a.a", "a,a-A?A A!a)A-a.a?A-A)A,a,A;A.A-A A.A A!a-A!A!A?A", "A?A!a(A?a)A-A.A(A(A;a-a(A?A-a,A!A,a;a a!a?A(A)a?a", "a;A A?a!A;a.A;a,A!a-a.a-a)a,A,A)a;a.A.a a!A)a.a)A", "A,A)A!A,a.A a!A.A!A a)A-a?A,a)a;A)a;a,A A(A.a.A!A", "A a!a-a-A?A,A A)a A(a?A-a!a)a)A.a(a)A-a.a;A;A,A(a", "A!a)A;a!a a A(A,A.A.A a?A?A-a?A;A)A!a!a-A-A,a a;a", "A?a!a A-a(A,a)A)a!A?a?A)A A(A-A,a(A?a(A;A-A;A-A(a", "a(A;A)A(A A a.a!A;a?a,a.A-A-a?a?a a A,a(a(A(a?a.A", "A(a;a a-A?a(a.A;A A,A?A A A-A(a(A!A;a-a(A?A?A,a)A", "a-A?a!a-a;a)A a,a.A!A-A,a;A!A!A;A A)A,a.a,A a-A.a", "a(A.a a?a.a A;A(A;a.a(A,a.a?a-a!a(A)a-a(A!a!a;a.a", "A?a;A(a-A-a)A)a-a(A.A-A;a-a?a!A)a;A.a)A A)a)A;A!a", "A A)a?a;a-A A-A,a)A)a(A;A,a A;A(a.a(a-A.a-A A,a;a", "A?a.A-a;a!a.A?a!a)A a(a(A!a!A(a!a.a)A?a a a,a;a A", "A;a.A)A.a-a?a,A-A,a(a.a-A?a-A.A?A A;A.a)a,A.A-a(a", "a(A!A?A(a A.a(A(A;A(a!A a;A(A?A;A-a!A;a)a?a)A)A-a", "a.a;A?A?A-a!a(A.a.a-A A.A)a!A A,A!A!A!A!a)a-a,A(a", "a?a a A!a!a?A)a;A!A)A A)A)A-A a)a;a)a-a,A;A-a,a.A", "a)a.a-A)a(a)A-A-a-A.a,A!a?a)a.a!a-A A;A?a;A.A-a(a", "A?a.a)a a;a.A)A!a,A)a.A a,A)a!A-a.A)a!a;A)A!a-A?a", "A.a,A.A)a?A?A-A,a)A-a a;A?a,a A,a.a-a)A.A a)a-a-a", "a;a-A,a!a;a.a(A?a a,a A;a!A)A-A)A.A,a.A.A.A A?a.A", "a!a,a;A!A a,A)a)a!A-a!A,a;A;a)a-A?a.a,a.A;A.a.A?A", "A(a;a.A,a a)a,A)a;A?a(A a?a.A a.a)a-a,A!a;a a-a-A", "A?A a)a)a,A a-a;a?A(A;a-a;a(A,a a(A-A a)A a(A;a)a", "a)A!A(a!a.a A.a(A;a-a(a-a)A;a;a.a?A!a!a-a)a?a.A.a", "A(A,a-a-A!a.a?A,a;A)a(A A.a,A;a)A,a;a a!a!a A?a;A", "a?A.A a!a a,a.a-A,a(a;a-a;A?A(a)A A)A A-A?a!A-A A", "A.a!a a,a)a(A A,A(a!A A(A(a.a-a,a!a?A a;a;A)a!a?a", "a?A.A,a.A?a,A A(A,a?A.A)a;a-a-a-a?A)a,A(a A(a,A)A", "A;A a-a;a;a.a;A,A.a?a;A a!a.a?a?A(A.A!a A a.a-A-A", "a(A.A a)A!a-A!a a A a)a,A)A-a)a-a;A-a-a)a;A,a.A-A", "A,a.a a(a)a A,A a(a,a.a,A;A-a.A a;A?A(A;A!a.a;a!A", "a A!A A)a;a(A!a A,a.a a,a,A;a-a?a;A a?a-A,A(A;A;a", "a(A-a,a(A;A)a(a?a?a!A.a(a?a?a?A(A A)A(a,A?A?a(a(a", "A a,a)A a A.a a-a)a?A A(a a.a a-A A A!a)a-A a.a,A", "A.A.a!A,a(a!a!A!A-a(a!A.A?a,A;a-A(a,A-A?a?a!a?a-A", "A!a A?A)A a;A-a;a.a?A(A(A?A(a-A!A!a?a;A-a!A-A?a(a", "A?A(a-A?a;A,a!A-A(a,A.A(A a!a,a A.A-A.A;A-A-A.A(A", "A.a!A.a!A;A a.A)a;A a;a(A!a?A;a;A,A;A-a.a-A(a,A!A", "A(A!a;a?A,a)A!a-A)A,A;A(a;a!A,a.A?A A(a!a-A?a,a(A", "a.A;a a!a)A?A)a a A(a?a.a-a-a?A?A-A-A!a)a,A!a)A(A", "A;A-a,a-A!A!A?A(a(A)A-a;A;a;A)a,A?a a?A?a a-A)A!A", "A!A a(a;A;A;A;a)A)a A a,a.a.A)A A!A?A A!a,A-a a.A", "A)A A(A)a)A a(A)a(A-a?a)a(A)a.a!A?a;a)a;A-a)a;A?A"}, "a...a...A...A...a"),
                    new String[]{"0 0 [a;A?a.a-a]", "0 2 [A?a.a-a.A]", "0 4 [a.a-a.A(A]", "0 6 [a-a.A(A a]", "0 8 [a.A(A a(A]"});
            eq(7, (new bloggoSequenceSearch()).findPassages(
                    new String[]{"b C a a a B c A A c b b b a a c a c B a B B B B c ",                    
                    "c A B C C A c C A a C c b c c a B C A A C a b b C ", //1
                    "c B A c c C b B C c a A C a b b A b A B B a c a a ",
                    "b c c a b a a c C a a A b a B b A b b a C C A A B ",
                    "c A C A C a C C b b C C B a c a c B b b a C b C A ",
                    "c c a a A C b C A C a c C b a C B A A a B a a C A ",
                    "A C C c a a b C B C C A C a b C c b C B A C A A B ",
                    "C B c c C A C B a b A A b a C a b b C b b c b C C ",
                    "c B c B C B C b a c B a b A a b a B B A C B A A c ",
                    "A C C c B B C C B A b B C A a b B B c A c C b A C ",
                    "A B C b a A C B B B B c B C A b B b a A a A b c B ", //10
                    "B b b b A B a C a b C C C B c c a A b a c C C c a ",
                    "c C A c B a A B b c A B a c b c A a C a C a c B c ",
                    "A b c b a c A b A B A B A B a a A B a A A b C c c ",
                    "b b a B b a C B B C c C c A c b c b B B C a c b c ",
                    "C C B a a C C A A C b b c B b B b a B C C B a c a ",
                    "C b a b B A b A A A b a a c A C B b C b a B B a C ",
                    "b c A C B c b A B A A c C b B B c A C A B C b B c ",
                    "b c A c B a A B c C A C c b c a c A A b A A A B C ",
                    "C c c A c B c A B B B A b c c C a c b C b C A C C ",
                    "B B C A a c A c A A B a b A B c b c c A B A c C b ",
                    "c a B c A b B a a c C c c A A a B A a C C C B c a ",
                    "A a a A b C a A b b b B B a a b C b a A A b b c A ",
                    "C C c a b A b B a C a b A a A b A C a b A B A A B ",
                    "B A a B c b C C b A B C b b A a c b A a b c a a B ",
                    "b B a c b C A a C b B B A a B c c b c b B A c c B ",
                    "a a b A C C B b b a a a A b c B B b B a c b A C c ",
                    "c b B b b A c C A A A B b B A A c A b a c C a b a ",
                    "A A b a a c A a A C c b B B B a a c c b B b A c b ",
                    "B A C C a b C a A c c c A C A a c a A a C C B C C ",
                    "c b b B B B a B c C C b C B b C c B b c b c B c a ",
                    "c b C C C A B a A a b c c B C A a b a b C C B B A ",
                    "A C C C A A b b c B b B a B b b B C B A b B C c B ",
                    "A a B b A B c c c C C c b b C b B c A c c c A a c ",
                    "a a C B B a c c c C a A C a b A C C C a c A A C A ",
                    "A a a c c C B b b c a B B c B C b A a a A a B A a ",
                    "C B C b a A B C B B B b b B C c B b a c C c C C C ",
                    "C a b B B b b A B C b b A C c b A B A B a a B c c ",
                    "C A B A B C a B C C c C C b C A B c c a A a C C c ",
                    "C b C B a C c a C b a C a c a C c A b A A C b C B ",
                    "a c A a B C C b B A b b B A a A C b C C a C c c c ",
                    "b B b C b C b A a a B C C C A B b A C B B a c b C ",
                    "C a c C B A B B B b C B c a C c C b C A A c b a B ",
                    "a b c c B A B C A b c b A c a C A C C A A c b A a ",
                    "B c B c b c b C a C C b c b C B C C B c B a A C A ",
                    "c A A a a b A C C C B A B A a b B A B C a A b c b ",
                    "A A b b C A A A c c a b A C c A A A C c A c B A c ",
                    "A a c c c B a C b a c B a A C c c C c C c C C a C ",
                    "A c C c b b a a a b A b c b B C c A B B a a b C C ",
                    "a c A a C B A a b B a A B A A B c c A a c b b c a "},
                    "a...b...c...b...a"),
                    new String[]{"10 0 [A B C b a]", "13 0 [A b c b a]", "22 28 [a b C b a]", "43 16 [A b c b A]", "10 0 [A B C b a A]"});
        } catch (Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
    }

    private static void eq(int n, int a, int b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
        }
    }

    private static void eq(int n, double a, double b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: expected '" + b + "', received '" + a + "'.");
        }
    }

    private static void eq(int n, char a, char b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: expected '" + b + "', received '" + a + "'.");
        }
    }

    private static void eq(int n, long a, long b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: expected \"" + b + "L, received " + a + "L.");
        }
    }

    private static void eq(int n, boolean a, boolean b) {
        if (a == b) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: expected " + b + ", received " + a + ".");
        }
    }

    private static void eq(int n, String a, String b) {
        if (a != null && a.equals(b)) {
            System.err.println("Case " + n + " passed.");
        } else {
            System.err.println("Case " + n + " failed: expected \"" + b + "\", received \"" + a + "\".");
        }
    }

    private static void eq(int n, int[] a, int[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, long[] a, long[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void eq(int n, String[] a, String[] b) {
        if (a.length != b.length) {
            System.err.println("Case " + n + " failed: returned " + a.length + " elements; expected " + b.length + " elements.");
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                System.err.println("Case " + n + " failed. Expected and returned array differ in position " + i);
                print(b);
                print(a);
                return;
            }
        }
        System.err.println("Case " + n + " passed.");
    }

    private static void print(int a) {
        System.err.print(a + " ");
    }

    private static void print(long a) {
        System.err.print(a + "L ");
    }

    private static void print(String s) {
        System.err.print("\"" + s + "\" ");
    }

    private static void print(int[] rs) {
        if (rs == null) {
            return;
        }
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if (i != rs.length - 1) {
                System.err.print(", ");
            }
        }
        System.err.println('}');
    }

    private static void print(long[] rs) {
        if (rs == null) {
            return;
        }
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print(rs[i]);
            if (i != rs.length - 1) {
                System.err.print(", ");
            }
        }
        System.err.println('}');
    }

    private static void print(String[] rs) {
        if (rs == null) {
            return;
        }
        System.err.print('{');
        for (int i = 0; i < rs.length; i++) {
            System.err.print("\"" + rs[i] + "\"");
            if (i != rs.length - 1) {
                System.err.print(", ");
            }
        }
        System.err.println('}');
    }

    private static void nl() {
        System.err.println();
    }
// END CUT HERE
}
