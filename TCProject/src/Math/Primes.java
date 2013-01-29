/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

import java.util.Arrays;

/**
 *
 * @author rC
 */
public class Primes {

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
    
    public static void main(String[] args) {
    }
}
