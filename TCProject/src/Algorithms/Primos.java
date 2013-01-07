/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Arrays;

/**
 *
 * @author rC
 */
public class Primos {

    public boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        int m = (int) Math.sqrt(n);

        for (int i = 2; i <= m; i++) {
            if (prime[i]) {
                for (int k = i * i; k <= n; k += i) {
                    prime[k] = false;
                }
            }
        }
        return prime;
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
//        System.err.println();
        for (int i = 0; i < 1000000; i++) {
            int a = new Primos().gcd(i, 145);
            System.err.println("err");
            break;
        }
        System.err.println(new Primos().lcm(6,9));
        System.err.println(new Primos().gcd(56, 42));
    }

    private static void print(String msg, Object... rs) {
        String x = Arrays.deepToString(rs);
        if (x.indexOf("[[") == 0) {
            x = x.substring(1, x.length() - 1);
        }
        System.err.println(msg + " " + x);

    }
}
