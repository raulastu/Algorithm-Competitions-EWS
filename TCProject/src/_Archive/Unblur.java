package _Archive;

// BEGIN CUT HERE
// END CUT HERE
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class Unblur {

    public String[] original(String[] blurred) {
        char[][] res = new char[blurred.length][blurred[0].length()];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (i == 0 || i == res.length - 1 || j == 0 || j == res[0].length - 1) {
                    res[i][j] = '.';
                }
            }
        }
        for (int i = 1; i < res.length - 1; i++) {
            for (int j = 1; j < res[i].length - 1; j++) {
                int c = parseInt(blurred[i - 1].charAt(j - 1) + "");
                int have = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (k == 1 && l == 1)continue;
                            int X = i - 1 + k;
                            int Y = j - 1 + l;
                            have += get(X, Y, res);                        
                    }
                }
                if (c > have) {
                    res[i][j] = '#';
                } else {
                    res[i][j] = '.';
                }
            }
        }
        String r[] = new String[res.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = new String(res[i]);
        }
        return r;
    }

    int get(int i, int j, char[][] x) {
        if (i >= 0 && j >= 0) {
            if (x[i][j] == '.') {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }
// BEGIN CUT HERE

    public static void main(String[] args) {
        try {
            eq(0, (new Unblur()).original(new String[]{"1221",
                        "1221",
                        "1221"}), new String[]{"....", ".##.", "...."});
            eq(1, (new Unblur()).original(new String[]{"00000",
                        "00000",
                        "00000",
                        "00000"}), new String[]{".....", ".....", ".....", "....."});
            eq(2, (new Unblur()).original(new String[]{"0011212121100",
                        "0123333333210",
                        "0123333333210",
                        "1233333333321",
                        "1233333333321",
                        "1233333333321",
                        "0112121212110"}), new String[]{".............", "...#.#.#.#...", "..#.#.#.#.#..", ".............", ".#.#.#.#.#.#.", "..#.#.#.#.#..", "............."});
            eq(3, (new Unblur()).original(new String[]{"1233321000000000123332100000000000000000000",
                        "1244422233222332334343323322232112332223321",
                        "1255523344343443545343434434343233432334432",
                        "0033303455465775633011445546454355753457753",
                        "0033303333364543533011433336333364521346542",
                        "0033303455464532445343545546454355753446542",
                        "0022202344342200234343434434343233432323221",
                        "0011101233221100123332223322232112332211111"}), new String[]{"...........................................", ".#####...........#####.....................", "...#...####.####.#...#.####.###..####.####.", "...#...#..#.#..#.#.....#..#.#..#.#....#..#.", "...#...#..#.####.#.....#..#.#..#.###..####.", "...#...#..#.#....#...#.#..#.#..#.#....#.#..", "...#...####.#....#####.####.###..####.#..#.", "..........................................."});
            eq(4, (new Unblur()).original(new String[]{"0000123210000",
                        "0012456542100",
                        "0135789875310",
                        "0258988898520",
                        "1479865689741",
                        "2589742479852",
                        "2589742479852",
                        "1479865689741",
                        "0258988898520",
                        "0135789875310",
                        "0012456542100",
                        "0000123210000"}), new String[]{".............", ".....###.....", "...#######...", "..#########..", "..####.####..", ".####...####.", ".####...####.", "..####.####..", "..#########..", "...#######...", ".....###.....", "............."});
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
