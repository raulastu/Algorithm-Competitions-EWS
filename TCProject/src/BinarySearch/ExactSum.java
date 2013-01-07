package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class ExactSum {
	public void BS(int[] precio, int money) {
		Arrays.sort(precio);
		int menor = Integer.MAX_VALUE;
		String res = "";
		for (int i = 0; i < precio.length; i++) {
			int a = precio[i];
			int b = money - a;
			int ind = Arrays.binarySearch(precio, b);
			if (ind >= 0&&ind != i) {
					if (b - a >= 0) {
						if (menor > b - a) {
							res = a + " and " + b + ".";
							menor = b - a;
						}
					} else {
						if (menor > a - b) {
							res = b + " and " + a + ".";
							menor = a - b;
						}
					}
			}
		}
		System.out.println("Peter should buy books whose prices are "+res+"\n");
	}

	public static void main(String[] arg) {
		ExactSum e = new ExactSum();
		Scanner sc=new Scanner(System.in);
		while (sc.hasNext()) {
			int b = sc.nextInt();
		    int[] pr = new int[b];
		    for (int i = 0; i < pr.length; i++) {
				pr[i]=sc.nextInt();
			}
		    int m = sc.nextInt();
		    e.BS(pr, m);
		}
		
	}
}
