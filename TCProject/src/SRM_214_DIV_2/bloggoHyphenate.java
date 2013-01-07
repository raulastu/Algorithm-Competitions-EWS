package SRM_214_DIV_2;

// BEGIN CUT HERE
// END CUT HERE
import java.util.*;

public class bloggoHyphenate {

    public String[] correct(String[] dictionary, String[] candidates) {
        String[] res = new String[candidates.length];
        HashMap<String, int[]> map = new HashMap<String, int[]>();
        for (int i = 0; i < dictionary.length; i++) {
            String[] sp = dictionary[i].split(" ");
            int[] indexes = new int[sp.length - 1];
            int ac = 0;
            for (int j = 0; j < indexes.length; j++) {
                ac += sp[j].length();
                indexes[j] = ac;
            }
            map.put(dictionary[i].replaceAll(" ", ""), indexes);
        }

        for (int i = 0; i < candidates.length; i++) {
            int[] is = map.get(candidates[i].replaceAll("-", ""));
            String omg = candidates[i];
            StringBuilder sb = new StringBuilder(omg);
            int n = omg.indexOf("-");
            boolean correct = true;
            for (; n != -1;) {
                int search = Arrays.binarySearch(is, n);
                if (search < 0) {
                    int rightD = 1000000;
                    int rightI = -1;
                    if (Math.abs(search + 1)  < is.length && Math.abs(search + 1)  >=0) {
                        rightI = is[Math.abs(search + 1) ];
                        rightD = Math.abs(rightI - n);
                    }
                    int leftD = 1000000;
                    int leftI = -1;
                    if (Math.abs(search + 1)-1 >= 0 ) {
                        leftI = is[Math.abs(search + 1)-1];
                        leftD = Math.abs(leftI - n);
                    }
                    if (rightD == 1000000 && rightD == leftD) {
                        sb.replace(n, n + 1, "");
                    } else if (leftD > rightD) {
                        sb.replace(n, n + 1, "");
                        sb.insert(rightI, "-");
                    } else {
                        sb.replace(n, n + 1, "");
                        sb.insert(leftI, "-");
                    }
                    correct = false;
                }
                omg = omg.replaceFirst("-", ".");
                n = omg.indexOf("-");
            }
            if (correct) 
                res[i] = "correct";
            else 
                res[i] = sb.toString();            
        }

        return res;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new bloggoHyphenate()).correct(new String[]{"syl la ble", "dic tion a ry", "mole"}, new String[]{"mo-le", "syl-lable"}), new String[]{"mole", "correct"});
            eq(1, (new bloggoHyphenate()).correct(new String[]{"syl la ble", "dic tion a ry", "mole"}, new String[]{"dictio-nary", "syll-able"}), new String[]{"diction-ary", "syl-lable"});
            eq(2, (new bloggoHyphenate()).correct(new String[]{"syl la ble", "dic tion a ry", "mole"}, new String[]{"dictionary-", "-syllable"}), new String[]{"dictiona-ry", "syl-lable"});
            eq(3, (new bloggoHyphenate()).correct(new String[]{"zsx kd ds jply rf", "auca wb ill", "kvqm kpd p kqi xpbk j",
                        "cqf ccr ewq", "srl vu m u d b", "h qae qzge", "jdn qqjf y",
                        "zpa hbr", "d uft ctsm qjg", "l hgcp ik twuy bsi nlmu iyx",
                        "cjjz jn td zg", "h bd q hi", "obsr kci hjdm h yar zsq q xyr hxb",
                        "izq iibd yuh tgx nkq", "cjgd wfns", "ohc bn duc",
                        "pydv a geki s bo avdi wd", "zygp gqt p", "xq pqqb ufoe",
                        "cvm yamq moqj vl zoig w", "ahz b lf ixjv d", "qpg ven d",
                        "m cbxz yf tv djf", "kti wacd uvgb kmr ew r", "ng tfb unw ndl",
                        "qruv ctw a", "d hk v pcxh zoxy", "etbo wabk", "x hxiu n",
                        "wp qq u dvpi tclh ac l", "f am brs lk uss uyb pg",
                        "dtfx h ict if koe jhj", "nl shp yeji b rw vrg", "bz qfnc u",
                        "t ceoy eb ss myoe zaaj z jey", "j d uju mb irvu",
                        "anmo emjs syam ta bfiy kk", "gl ej egla tha jbug",
                        "zk u sz raij d", "kw lbya atdb pd", "no id hqum u wny qcy",
                        "phv nv l f oq m", "b xup tnq fziw yth sn", "pvc hnr oky lzj",
                        "ew wtwt gyty s uu pfe kif my", "t cw fsau",
                        "esk gqtd o yh jbx wed fl z", "vvr hqw wo gxwm",
                        "lei akz nzz bumb", "bc hlmw"}, new String[]{"-duftctsmqjg", "-leiakznzzbumb", "-xhxiun", "-zpahbr",
                        "ahzbl-fixjvd", "anmo-emjssyamtabfiykk", "aucawb-ill",
                        "bchlmw-", "bxuptnqfziwyth-sn", "bzq-fncu", "c-vmyamqmoqjvlzoigw",
                        "cjg-dwfns", "cjjzjn-tdzg", "cqfccre-wq", "dhkvpcxhzox-y",
                        "dtfx-hictifkoejhj", "eskgqtdoyhjbx-wedflz", "etbowab-k",
                        "ewwtwtgytysuupfe-kifmy", "fambrslkuss-uybpg", "glejegl-athajbug",
                        "hbdqhi-", "hq-aeqzge", "izqiibd-yuhtgxnkq", "jd-nqqjfy",
                        "jdujumb-irvu", "ktiwacduvgbkmr-ewr", "kv-qmkpdpkqixpbkj",
                        "kwlbya-atdbpd", "lhgcpiktwuybsi-nlmuiyx", "mcbx-zyftvdjf",
                        "ngtf-bunwndl", "nlshpyejibrwvrg-", "no-idhqumuwnyqcy", "o-hcbnduc",
                        "obsr-kcihjdmhyarzsqqxyrhxb", "ph-vnvlfoqm", "pvchnrok-ylzj",
                        "pydvageki-sboavdiwd", "qpgv-end", "qruvctw-a", "srlvumu-db",
                        "tceoyebssmyo-ezaajzjey", "tcwfsau-", "vvrhqwwo-gxwm",
                        "wpqqudvpit-clhacl", "xqpq-qbufoe", "zku-szraijd",
                        "zsxkddsjp-lyrf", "zygpgqt-p"}), new String[]{"d-uftctsmqjg", "lei-akznzzbumb", "x-hxiun", "zpa-hbr", "ahzb-lfixjvd", "correct", "correct", "bc-hlmw", "correct", "bz-qfncu", "cvm-yamqmoqjvlzoigw", "cjgd-wfns", "correct", "cqfccr-ewq", "dhkvpcxh-zoxy", "correct", "correct", "etbo-wabk", "correct", "correct", "glejegla-thajbug", "hbdq-hi", "h-qaeqzge", "correct", "jdn-qqjfy", "correct", "correct", "kvqm-kpdpkqixpbkj", "correct", "correct", "mcbxz-yftvdjf", "ngtfb-unwndl", "nlshpyejibrw-vrg", "correct", "ohc-bnduc", "correct", "phv-nvlfoqm", "pvchnroky-lzj", "correct", "qpg-vend", "correct", "correct", "tceoyebssmyoe-zaajzjey", "tcw-fsau", "correct", "wpqqudvpi-tclhacl", "xq-pqqbufoe", "correct", "zsxkdds-jplyrf", "correct"});
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
