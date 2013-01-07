package DP;

import java.util.Arrays;

public class LongestCommonSubseq {

    public int lcs(int[] X, int[] Y) {

        for (int i = 0; i < X.length; i++) {
            
        }

        return S[X.length - 1];
    }

    public static void main(String[] args) {
        int i = new LongestNonDecreasingSeq().longest(new int[]{5, 3, 4, 8, 6, 7});
        System.err.println(i);
    }

    private static void print(String msg, Object... rs) {
        String x = Arrays.deepToString(rs);
        if (x.indexOf("[[") == 0) {
            x = x.substring(1, x.length() - 1);
        }
        System.err.println(msg + " " + x);
    }
}
