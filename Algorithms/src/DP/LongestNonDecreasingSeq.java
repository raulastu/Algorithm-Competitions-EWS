package DP;

import java.util.Arrays;

public class LongestNonDecreasingSeq {

    public int longest(int[] seq) {
        int[] S = new int[seq.length];
        S[0] = 1;
        for (int i = 0; i < seq.length; i++) {
            S[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    S[i] = S[j] + 1;
                }
            }
        }
        print("", S);
        return S[seq.length-1];
    }
    public int longest2(int[] seq) {
        int[] S = new int[seq.length];
        Arrays.fill(S,1);
        for (int i = 0; i < seq.length; i++) {
//            S[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) {
                    S[i] = S[j] + 1;
                }
            }
        }
        print("", S);
        return S[seq.length-1];
    }

    public static void main(String[] args) {
//        int i = new LongestNonDecreasingSeq().longest(new int[]{20,5, 3, 4, 8, 6, 7,21});
        int i = new LongestNonDecreasingSeq().longest2(new int[]{5, 3, 4, 8, 6, 7});
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
