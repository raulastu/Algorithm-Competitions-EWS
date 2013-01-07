/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

/**
 *
 * @author rC
 */
public class Permutation {

    void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    void reverse(char a[]) {
        reverse(a, 0, a.length);
    }

    void reverse(char a[], int from, int to) {
        while (from < --to) {
            swap(a, from++, to);
        }
    }

    boolean nextPermutation(char[] a) {
        int j = a.length - 1;
        if (j <= 0) {
            return false;
        }
        while (j > 0 && a[j] <= a[--j]);

        if (a[j + 1] <= a[j]) {
            reverse(a);
            return false;
        }
        int k = a.length;
        while (a[--k] <= a[j]);
        swap(a, k, j);
        reverse(a, j + 1, a.length);
        return true;
    }

    public boolean next_permutation2(char a[]) {
        for (int i = a.length - 2, j; i >= 0; i--) {
            if (a[i + 1] > a[i]) {
                for (j = a.length - 1; a[j] <= a[i]; j--);
                swap(a, i, j);
                for (j = 1; j <= (a.length - i) / 2; j++) {
                    swap(a, i + j, a.length - j);
                }
                return true;
            }
        }
        return false;
    }

    private boolean nextPerm(char[] a) {
        if (a.length <= 1) {
            return false;
        }
        int i = a.length - 1;
        while (a[i - 1] >= a[i]) {
            i--;
            if (i == 0) {
                return false;
            }
        }
        int j = a.length;
        while (a[j - 1] <= a[i - 1]) {
            j--;
            if (j == 0) {
                return false;
            }
        }
        char tmp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = tmp;
        i++;
        j = a.length;
        while (i < j) {
            tmp = a[i - 1];
            a[i - 1] = a[j - 1];
            a[j - 1] = tmp;
            i++;
            j--;
        }
        return true;
    }
}
