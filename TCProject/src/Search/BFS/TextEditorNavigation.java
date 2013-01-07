package Search.BFS;

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

public class TextEditorNavigation {

    class Node {

        int x, y;
        String name;

        public Node(int x, int y, String name) {
            this.x = x;
            this.y = y;
            this.name = name;
        }

        @Override
        public String toString() {
            return x + " " + y + " " + name;
        }
    }
    Queue<ArrayList<Node>> q;

    public int keystrokes(String[] source, int[] start, int[] finish) {
        int res = -1;
        int max = 1;
        for (int i = 0; i < source.length; i++) {
            max = max(max, source[i].length());
        }
//        printm(source);
        int[] end = new int[source.length];
        boolean[][] memo = new boolean[source.length][max];
        for (int i = 0; i < source.length; i++) {
            end[i] = source[i].length() - 1;
            int x = max - source[i].length();
            for (int j = 0; j < x; j++) {
                source[i] += " ";
            }
        }
//        printm(source);
        q = new LinkedList<ArrayList<Node>>();
        ArrayList<Node> li = new ArrayList<Node>();
        li.add(new Node(start[0], start[1], ""));
        q.add(li);
        int[] di = {-1, 0, 1, 0}; //urdl
        int[] dj = {0, 1, 0, -1};
        String[] s = {"up", "right", "down", "left"};
        while (!q.isEmpty()) {
            ArrayList<Node> l = q.poll();
            Node p = l.get(l.size() - 1);
            if (p.x == finish[0] && p.y == finish[1]) {
//                System.err.println(l);
                return l.size() - 1;
            }
            for (int i = 0; i < 4; i++) {
                int X = p.x + di[i];
                int Y = p.y + dj[i];
                if (X >= 0 && X < source.length && Y >= 0 && Y < source[X].length() &&
                        !memo[X][Y]) {
                    doit(X, Y, memo, l, s[i]);
                }
            }
            if (p.y > 0) {
                doit(p.x, 0, memo, l, "home");
            }
            if (p.y != end[p.x]) {
                doit(p.x, end[p.x], memo, l, "end");
            }
            if (p.x > 0) {
                doit(0, p.y, memo, l, "top");
            }
            if (p.x < source.length - 1) {
                doit(source.length - 1, p.y, memo, l, "bot");
            }
            Pattern pat = Pattern.compile("\\b[a-zA-Z]");
            Matcher mat = pat.matcher(source[p.x].substring(0, p.y));
            int ny = -1;
            while (mat.find()) {
                ny = mat.start();
            }
            doit(p.x, ny, memo, l, "wl");
            pat = Pattern.compile(" [a-zA-Z]");
            mat = pat.matcher(source[p.x].substring(p.y, source[p.x].length()));

            int ny2 = -1;
            if (mat.find()) {
                ny2 = mat.end();
                doit(p.x, ny2 + p.y - 1, memo, l, "wr");
            }
        }
        return res;
    }

    void doit(int x, int y, boolean[][] memo, List l, String n) {
        if (x >= 0 && x < memo.length && y >= 0 && y < memo[x].length && !memo[x][y]) {
            memo[x][y] = true;
            ArrayList<Node> wl = new ArrayList<Node>(l);
            wl.add(new Node(x, y, n));
            q.add(wl);
        }
    }
// BEGIN CUT HERE

    public static void main(String[] args) {
        try {
            eq(0, (new TextEditorNavigation()).keystrokes(new String[]{"AAAAA AAA AAAAAAAAAAAAA  AAAA",
                        "AA   AAAAAAAAA AAAA     AAAA",
                        "BBBBBBBBBBBBBBBBBBBBBBBBBBB",
                        "BBBBBBB BBBBBBBBBB BBBBBBB",
                        "CCC CCCC CCCCCC      CCCC",
                        "DDDDDDDDDDDDDDDDDDD"}, new int[]{5, 7}, new int[]{2, 2}), 6);
            eq(1, (new TextEditorNavigation()).keystrokes(new String[]{"A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "BB BB BB BB BB BB BB BB BB BB BB BB BB BB BB BB BB",
                        "CCC CCC CCC CCC CCC CCC CCC CCC CCC CCC CCC CCC CC",
                        "DDDD DDDD DDDD DDDD DDDD DDDD DDDD DDDD DDDD DDDD ",
                        "EEEEE EEEEE EEEEE EEEEE EEEEE EEEEE EEEEE EEEEE EE",
                        "FFFF FFFF FFFF FFFF FFFF FFFF FFFF FFFF FFFF FFFF ",
                        "GGG GGG GGG GGG GGG GGG GGG GGG GGG GGG GGG GGG GG",
                        "HHHHHHHHHHH HHHHHHHHHH HHHHHHHHHH HHHHHHHHHH HHHHH",
                        "IIIIIIIIIIIIIII IIIIIIIIIIIIIII IIIIIIIIIIIIIII   ",
                        "JJJJJJJJ JJJJJJJJ JJJJJJJJ JJJJJJJJ JJJJJJJJ JJJJJ",
                        "KKKKKKKKKKKKKKKKKKKKKKKKKK KKKKKKKKKKKKKKKKKKKKKKK",
                        "LLLLLLLLLL LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL",
                        "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM",
                        "N N N N N N N N N N N N N N N N N N N N N N N N N ",
                        "OOOOO OOOO OOO OO O O OO OOO OOOO OOOOO OOOOOO OOO",
                        "PPPPPPP PPPPPP PPPPP PPPP PPP PP P P PP PPP PPPP P",
                        "QQQQQQ QQQQQ QQQQ QQQ QQ Q Q QQ QQQ QQQQ QQQQQ QQQ",
                        "ZZZZ ZZ ZZZ ZZ ZZZZ ZZ ZZZ ZZ ZZZZ ZZ ZZZ ZZ ZZZZ ",
                        "SSS S SSS S SSS S SSS S SSS S SSS S SSS S SSS S SS",
                        "TT TT TT TT TT TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"}, new int[]{12, 20}, new int[]{4, 36}), 8);
            eq(2, (new TextEditorNavigation()).keystrokes(new String[]{"A A A A AAAAAAA A A A A A A A A A A",
                        "B BBBBB B B B B BBBBB B B B B B B B B"}, new int[]{1, 0}, new int[]{1, 22}), 6);
            eq(3, (new TextEditorNavigation()).keystrokes(new String[]{"AAAAAAAAAAAAAA A A A A A A A A A A"}, new int[]{0, 2}, new int[]{0, 15}), 1);
            eq(4, (new TextEditorNavigation()).keystrokes(new String[]{"A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "N N N N N N N N N N N N N N N N N N N N N N N N N ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        "A A A A A A A A A A A A A A A A A A A A A A A A A ",
                        " O O O O O O O O O O O O OO O O O O O O O O O O O ",
                        " P P P P P P P P P P P P P PP P P P P P P P P P P ",
                        " Q Q Q Q Q Q Q Q Q Q Q Q Q Q QQ Q Q Q Q Q Q Q Q Q ",
                        " R R R R R R R R R R R R R R R RR R R R R R R R R ",
                        " S S S S S S S S S S S S S S S S SS S S S S S S S ",
                        " T T T T T T T T T T T T T T T T T TT T T T T T T ",
                        " U U U U U U U U U U U U U U U U U U UU U U U U U ",
                        " V V V V V V V V V V V V V V V V V V V VV V V V V ",
                        " W W W W W W W W W W W W W W W W W W W W WW W W W ",
                        " X X X X X X X X X X X X X X X X X X X X X XX X X ",
                        " Y Y Y Y Y Y Y Y Y Y Y Y Y Y Y Y Y Y Y Y Y Y YY Y ",
                        " Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z Z ZZZ"}, new int[]{49, 49}, new int[]{38, 26}), 23);
            eq(5, (new TextEditorNavigation()).keystrokes(new String[]{"AAA", "BB", "CCC"}, new int[]{1, 1}, new int[]{1, 1}), 0);
            eq(6, (new TextEditorNavigation()).keystrokes(new String[]{"AAAAA AAA AAAAAAAAAAAAA  AAAA",
                        "AA   AAAAAAAAA AAAA     AAAA",
                        "BBBBBBBBBBBBBBBBBBBBBBBBBBB",
                        "BBBBBBB BBBBBBBBBB BBBBBBB",
                        "CCC CCCC CCCCCC      CCCC",
                        "DDDDDDDDDDDDDDDDDDD"}, new int[]{2, 17}, new int[]{1, 2}), 4);
            eq(7, (new TextEditorNavigation()).keystrokes(new String[]{"A PC to do CAD huh  Sounds reasonable",
                        "Aurthor go out and buy us five new PCs",
                        "Dont you want to think about this for a minute",
                        "No every second counts and we want to be ahead of",
                        "the competition",
                        "       OK Greate idea Please place lOOk worth of",
                        "unmarked bills in my suitcase and Ill be on my way"}, new int[]{0, 11}, new int[]{1, 15}), 2);
            eq(7, (new TextEditorNavigation()).keystrokes(new String[]{"AAAAAA", "AAAAAAAAAAA"}, new int[]{1, 10}, new int[]{0, 5}), 2);
            eq(7, (new TextEditorNavigation()).keystrokes(new String[]{"AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA A A", "B B B B B B B B BB B B B BBBBBBB B B", "FFFFXFFFFFFFFFFFF        F F F F F F F F F F F", "CCCCCCCCCCCCCCCCCCC", "DDDDDDDDDDDDDDDDDDDDDDDD", "EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE"}, new int[]{2, 4}, new int[]{1, 16}), 5);
            eq(7, (new TextEditorNavigation()).keystrokes(new String[]{"    sdlfjasdlfkjasdflakjdsfalksjdfasldkj          ", "      adslfkjadslfkjasdflkajsdfalskdjfas          ", "        adlsfjasdlfkjasdflkjasdflajsdfal          ", "          adslfjasdlfjasdlfkjsadflkjsadl          ", "        adslkjfasdlkfjasdlfkjasdlfkjasdflk        ", "      asldkfjasldfkjasdlfkjasdflkjasdflkjasd      ", "    adslfkjasdlkfjasdlfkjasdflkjasdflkjasdflkj"}, new int[]{3, 25}, new int[]{0, 46}), 4);
            eq(7, (new TextEditorNavigation()).keystrokes(new String[]{" A A "}, new int[]{0, 3}, new int[]{0, 1}), 1);
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

    private static void print(Object... rs) {
        print("", rs);
    }

    private static void print(String msg, Object... rs) {
        String x = deepToString(rs);
        if (x.indexOf("[[") == 0) {
            x = x.substring(1, x.length() - 1);
        }
        System.err.println(msg + " " + x);
    }

    private static void printm(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.err.println("[" + a[i] + "]" + a[i].length());
        }
    }

    private static void printm(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.err.println("[" + new String(a[i]) + "]");
        }
    }
    static String expected = "  expe";
    static String received = "  rChi";
// END CUT HERE
}
