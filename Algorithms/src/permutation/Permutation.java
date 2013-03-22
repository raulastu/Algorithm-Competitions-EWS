
package permutation;

public class Permutation {
	
	static boolean nextPermutation(int[] src) {
		int i;
		for(i = src.length - 2;i >= 0 && src[i] > src[i + 1];i--)
			;
		if(i == -1)
			return false;
		int j;
		for(j = i + 1;j < src.length && src[i] < src[j];j++)
			;
		int d = src[i];
		src[i] = src[j - 1];
		src[j - 1] = d;
		for(int p = i + 1, q = src.length - 1;p < q;p++, q--){
			d = src[p];
			src[p] = src[q];
			src[q] = d;
		}
		return true;
	}
	
	// chars

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
}
