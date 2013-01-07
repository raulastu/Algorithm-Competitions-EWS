/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearch;

/**
 *
 * @author rC
 */
public class TCTuto {

    int binarySearch(int[] A, int target) {
        int lo = 0, hi = A.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        if (lo == A.length || lo < 0 || A[lo] != target) {
            return -1;
        }
        return lo;
    }

    int binarySearch(double[] A, double target) {
        int lo = 0, hi = A.length;
        int i = 0;
        while (i++ < 100) {
            int mid = lo + (hi - lo) / 2;
            System.err.println(mid);
            if (A[mid] >= target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (lo == A.length || lo < 0 || A[lo] != target) {
            return -1;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 5, 5, 6, 6, 6};
        double[] b = {1, 2, 3, 4, 5, 5, 5, 6, 6, 6};
//        System.err.println(new TCTuto().binarySearch(a, 0));
        System.err.println(new TCTuto().binarySearch(b, 5));
    }
}
