package testing;

import static java.lang.Math.*;

/**
 *
 * @author rC
 */
public class TesisMuestra {

    public static void main(String[] args) {
        int N = 250;
        double p = 0.95;
        double q = 1 - p;
        double e = 0.05;
        double z = 1.96;
        double n = N * pow(z, 2) * p * q / (pow(e, 2) * (N - 1) + pow(z, 2) * p * q);

        System.err.println(n);
    }
}
