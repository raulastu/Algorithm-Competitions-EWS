package _Archive;

// BEGIN CUT HERE
// END CUT HERE
import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class Teaching {

    public int count(String[] words, int K) {
        int res = 0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        LinkedHashMap<Character, Integer> map2 = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < 26; i++) {
            map.put(new Character((char) ('a' + i)), 0);
        }
        int[] a = new int[26];


        for (Character character : map.keySet()) {
            for (int j = 0; j < words.length; j++) {
                if (words[j].contains(character + "")) {
                    if (map2.containsKey(character)) {
                        int x = map2.get(character);
                        map2.put(character, x + 1);
                    } else {
                        map2.put(character, 1);

                    }
                    a[character - 'a']++;
                }
            }
        }
        sort(a);

        map2 = sortByValue(map2);

        int count = 0;
        int d = map2.size() - K;
        for (Iterator it = map2.keySet().iterator(); it.hasNext();) {
            Character charx = (Character) it.next();
            if (count < d) {
                map.remove(charx);
                it.remove();
            }
            count++;
        }
        System.err.println(map2);
        for (int i = 0; i < words.length; i++) {
            boolean canRead = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!map2.containsKey(words[i].charAt(j))) {
                    canRead = false;
                }
            }
            if (canRead) {
                res++;
            }
        }

        return res;
    }

    static LinkedHashMap sortByValue(Map map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {

            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
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
//            eq(0, (new Teaching()).count(new String[]{"antarctica", "antahellotica", "antacartica"}, 6), 2);
//            eq(1, (new Teaching()).count(new String[]{"antaxxxxxxxtica", "antarctica"}, 3), 0);
            eq(2, (new Teaching()).count(new String[]{"antabtica", "antaxtica", "antadtica", "antaetica", "antaftica",
                        "antagtica", "antahtica", "antajtica", "antaktica"}, 8), 3);
            eq(1, (new Teaching()).count(new String[]{"antabxjeoictica", "antacgappsktica", "antauayfybjtica", "antaortiulctica", "antadnjzwzmtica", "antaykddorltica", "antaiknauajtica", "antaejljsmytica", "antazqbttdjtica", "antaxjinuhvtica", "antakdmdvovtica", "antaocaimhptica", "antapcyxecztica", "antaooxdlyytica", "antadoqtckatica", "antarlzwxtftica", "antaigavwbltica", "antaclxyuhjtica", "antawzygbfetica", "antalxnuclktica", "antaguiczibtica", "antamgxgpyctica", "antasjlaqjntica", "antavizdwjdtica", "antalqeznrstica", "antajppuwdrtica", "antajrsmijztica", "antacafjtmmtica", "antazcbcllqtica", "antawyvwjoytica", "antacuyrzhltica", "antaannxdautica", "antasuhnjsqtica", "antambhtjpftica", "antadjvwjugtica", "antamgbhuaytica", "antafejrpfctica", "antafyyowhrtica", "antazcqbvjxtica", "antaftvflqjtica", "antaecmzhketica", "antasdbuqkttica", "antarrmqoyptica", "antafbmfegftica", "antaexdffiptica", "antadxhftebtica", "antattatcantica", "antagwegtigtica", "antamehquoqtica", "antanzowdfutica"}, 14), 7);

        } catch (Exception exx) {
            System.err.println(exx);
            exx.printStackTrace(System.err);
        }
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

    private static void print(String msg, Object... rs) {
        String x = deepToString(rs);
        if (x.indexOf("[[") == 0) {
            x = x.substring(1, x.length() - 1);
        }
        System.err.println(msg + " " + x);
    }
    static String expected = "  expe";
    static String received = "  rChi";
// END CUT HERE
}
