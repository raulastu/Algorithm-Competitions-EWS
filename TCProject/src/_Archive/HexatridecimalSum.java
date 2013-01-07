package _Archive;

// BEGIN CUT HERE
// END CUT HERE
import java.math.BigInteger;
import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class HexatridecimalSum {

    public String maximizeSum(String[] numbers, int k) {
        sort(numbers);
//        HashSet<Character> set = new HashSet<Character>();
        long a = System.currentTimeMillis();
        for (int kk = 0; kk < k; kk++) {
            BigInteger max = BigInteger.ZERO;
            char el = 'x';
            for (int i = 0; i < numbers.length; i++) {
                for (int j = 0; j < numbers[numbers.length - i - 1].length(); j++) {
                    char selected = numbers[numbers.length - i - 1].charAt(j);
                    if (selected != 'Z') {
                        BigInteger sum = BigInteger.ZERO;
                        for (int l = 0; l < numbers.length; l++) {
                            sum = sum.add(new BigInteger(numbers[l].replace(selected, 'Z'), 36));
                        }
                        if (max.compareTo(sum) < 0) {
                            max = sum;
                            el = selected;
                            break;
                        }
                    }
                }
            }

            if (el != 'x') {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = numbers[i].replace(el, 'Z');
                }
            }
        }
//        print("", numbers);
        System.err.println(System.currentTimeMillis() - a);
        BigInteger s = BigInteger.ZERO;
        for (int i = 0; i < numbers.length; i++) {
            s = s.add(new BigInteger(numbers[i], 36));
        }
        return s.toString(36).toUpperCase();
    }

    BigInteger sum(String[] numbers) {
        BigInteger s = BigInteger.ZERO;
        for (int i = 0; i < numbers.length; i++) {
            s = s.add(new BigInteger(numbers[i], 36));
        }
        return s;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        try {
            eq(0, (new HexatridecimalSum()).maximizeSum(new String[]{"HELLO"}, 2), "ZZLLO");
            eq(1, (new HexatridecimalSum()).maximizeSum(new String[]{"500", "POINTS", "FOR", "THIS", "PROBLEM"}, 5), "1100TC85");
            eq(2, (new HexatridecimalSum()).maximizeSum(new String[]{"TO", "BE", "OR", "NOT", "TO", "BE"}, 0), "QNO");
            eq(3, (new HexatridecimalSum()).maximizeSum(new String[]{"KEQUALS36"}, 36), "ZZZZZZZZZ");
            eq(4, (new HexatridecimalSum()).maximizeSum(new String[]{"GOOD", "LUCK", "AND", "HAVE", "FUN"}, 7), "31YUB");
            long a = System.currentTimeMillis();
            eq(4, (new HexatridecimalSum()).maximizeSum(new String[]{"BX1ZLKFS18WXSSMI159Z920L778ERL1SATY6J6T6RAKR57EOZ9", "NP8R1775H0K9MSW7GBU7XCVMEXUEBDOADIIB3FVEUZZX9DKVSO", "ZS2KXNYRYFTNMOZ9I0MFJTWZSGC9FFD4WPDGP4CTHCPH5O7H9M", "ZXXJUXTPN6ECSB49W774BTHB8T9GYD9IGZW2HWUMAS5UNJNELD", "R2BP1LYIRV7VHN46P7D6Q9VO30VVZKAZXNDN8IVF9P5MHK2IR5", "K9BQAGHTD07WPKKY7Y6HEC2J0XBD5HSDVUG7VMAY9FU0G2SE47", "Y91BRAVJQ8ZSMOT0ZDN70T8Y42UXO34UIO5UOJ58YZF031BXD", "VYTEF951WSMVSOUR6ECAF8ZT0LY8NM3UWXBDN2I496SAE05GPC", "6IV9WTSSFTS9EUAXSY3XOEBSMPVIZCMLI2U2MVORHYHXU0E601", "NRRC5TH4PQJCMLBJH8ANYOE4BJBYUYLD78F3PY4W4G0CTU8910", "I8S7R3J9VGQGTGWPTCUAHQWMMFRSTHYCID7EGY0CFBGTSPY7NE", "AETMIFNOAQ77SWZE4UK4BD0EX4EARK21OBKX29CAR2HA8137DI", "GEL1NQCGA8U6TRJIJCBNZIT1CH4UK8PVTUOADBCSTFU94J9WRU", "MGUNJWC9F3NKOTHVZ98BX35JJOPY5WHQZL97DSTYB83RUQO8MA", "BXJA92W0U6FCBQ4AJL7VQSZG53JEUZCWNEX7SC0IBY5H1SAX0F", "990RVNMB24OKIVE5AP7L37DMA3Q7G41C5Y6OIESSKK5N45ML9I", "RRIQV1QCSN7N02XZM7KZGG5YGCUUG8QEEPQI3P7XS2RIBFZAHV", "WEZSQW6ZYC3O40X1FMWODWNSZXBB5RLYGB6X5G0CF6MM5ZUAEV", "MKRUIFEBHOMANLC6FJ560EU5ATZVGRJR5LTRSW497JYM2SS1LV", "C2IKD68249RJXHTKU36KYKY16L1C6Q2Q9I1IWGOAIMMNRXLU0S", "KYBA6ELUHV2RQJAFF9XCUHGDMVEPUCH682BNDV045U4A2AQ6R6", "KEZQOY3TB5HM84N5M11TKZHI3BYJRJFYNFB48N6X5A0R3VIRL3", "ONT0S20DVEGR2LKE5XNTPINSCGW5WW8OTWNS1DWTSMSJIEDHRF", "RPDNR3ZX950Q6S05EQ080O6HL2Z3S3F0VHLBICX2RIGWOOS2TA", "98PO2VNXVM4RI4MCI73CN8TAZANRQFYV3UJ8X8L6VCECAB2E2Y", "TM7GS1P5NPH0BTL93GTLXCXV8S56MP007F39VRY0WDKQTEMM78", "AK3EA7VBFE59RJTPFU7WBT7SOKPVQSS1DCDQEN8CISU3MPF1QX", "SCOQ17ELNFCJY6PP0A2UUFT5B3JCYU3SHG6BI2EXP8KFVJBY1B", "9QXEQFL5C7D45B516HE2CSBEBUWTU1HNAM9AOM13IVXMZZDCEF", "41XHBYA0JBFG7IP4D93SGOEQVS8TS3QNN1UDYYV0F4O9YLA6BS", "G50P1ZOT2GUFD0QDTWUBBODZR5F153VG8V8T9NZJ41V0TQNHJL", "Y0JQ8DDB3EMFE3WC4OPNHILE3VRBD2T1QVAQ4EOMGSB4ZQZW0W", "PN206VOJ8MHZDYYP316ZDESN4G8LZ0M0D7QZ3DNZGS8BZ3SC6T", "SOONDZ60I3F93INNO41EVOYCJBFATHK4FRDW85WOQWWAYV666R", "936HK4VJKGZT4SP6MBF1XQIUXR2HDSO1J18PA9EM6LNZBHDN9J", "TY8Q2Y4HSRGDRP5JO5I9ZH4RLLJQBIKW6O0L9H2BRYDJ58UDX3", "RXZ795W4UVMWA87EQINWD62DTSPTZYD7WEK3FX4530GKSZFT42", "CSO468CIFBBA9M25ENJG52Y750V6A27462M8ZQ5SHE8WRYNZVK", "I3BAR85EVD6O8XKSVOQY9M3ALWV9A0ZR8BA7OR1ONRAPQZL62Q", "IVR0P1J2WQDDNO72N9MFM4QOI6ZPYPWXE3Z9IKKBNVCOPSH7", "C0QYMQKGNP2270TPATIFDEOE0KU7DB0R76E84JNHG2V3K4LA8B", "6O7XH8P8EOM22YHOU0YZTLJ60WQNDJ3PZRH8G3OP81GX9W4CBP", "N5P2Q5SQI7SCHX073VYS6Z7DVRONVR9E3PXO7J43NHUGRSL9I0", "AJQKT1XMQ9ADBXRTXMB5KMXCVP4V3TQGK0366KNL8PLG6TOB2K", "Q6B84NOQGM2H9IWBCW2P3UEWV3Q9BKMLE3813BE7EB7M1473Q4", "WDCMUQW9Z8PJO9HQSANFLSG1D8OQBCVLQQG8J2BN2CDQAMF84H", "N16ZTOH25FYLME94L3WODWAXB9E5Z2YBYFICF0PK1VRR0WT2TO", "NB9D206TRP32QQGRAC2M8UEA68GUDCBJ0PTC0DZO4Q2CHS0HME", "7VISUGNWM9JX7CHGNVSECO20EEXTJY0W512VFSG1CIKXNR268U", "AAD92VUYCBZOD6X6JET8RFTBERVM2HO0HVODHZH6P0AAZIB5SB"}, 36), "1C10ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZYM");
            System.err.println(System.currentTimeMillis() - a);

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
