package DP;

import java.util.ArrayList;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.util.Arrays;

/**
 * 
 * @author rC
 */
public class Coins {

	/**
	 * Given a list of N coins, their values (V1, V2, ... , VN), and the total
	 * sum S. Find the minimum number of coins the sum of which is S (we can use
	 * as many coins of one type as we want), or report that it's not possible
	 * to select coins in such a way that they sum up to S.
	 * 
	 * @param s
	 * @param coins
	 * @return
	 */
	public int minCoins(int s, int[] coins) {
		int res = 0;
		int min[] = new int[s + 1];
		Arrays.fill(min, Integer.MAX_VALUE);
		Arrays.sort(coins);
		for (int i = 0; i < coins[0]; i++) {
			min[i] = 0;
		}
		for (int i = 0; i < coins.length; i++) {
			min[coins[i]] = 1;
		}
		int [] fre=new int[coins.length];
		for (int i = coins[0]; i <= s; i++) {
			System.err.print("i=" + i + " : ");
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i 
						&& i - coins[j] >= coins[0]
						&& min[i - coins[j]] + 1 < min[i]) {
					fre[j]++;
					min[i] = min[i - coins[j]] + 1;
					System.err.print(min[i] + "(" + coins[j] + ") ");
				}
			}
			System.err.println("");
		}
		pr(min,fre);
		return min[s];
	}

	public int minCoins2(int s, int[] coins) {
		int res = 0;
		int min[] = new int[s + 1];
		Arrays.fill(min, Integer.MAX_VALUE);
		min[0] = 0;
		for (int j = 0; j < coins.length; j++) {
			System.err.print(coins[j] + " : ");
			for (int i = 0; i <= s; i++) {
				if (i + coins[j] <= s && min[i] + 1 < min[i + coins[j]]) {
					System.err.print(i + "=");
					// System.err.print(i + coins[j]+":"+min[i + coins[j]]+" ");
					min[i + coins[j]] = min[i] + 1;
					System.err.print(i + coins[j] + ":" + (min[i] + 1) + " ");
				}
			}
			System.err.println("");
		}
		pr("", min);
		return min[s];
	}

	public int minCoins3(int s, int[] coins) {
		int res = 0;
		int n = coins.length;
		int min[] = new int[s + 1];
		fill(min, 1, s + 1, Integer.MAX_VALUE);
		int data[] = new int[s + 1];
		fill(data, -1);
		// min[0]=0;
		for (int i = 0; i <= s; i++) {
			for (int j = 0; j < n; j++) {
				if (coins[j] <= i 
						&& min[i - coins[j]] + 1 < min[i]) {
					min[i] = min[i - coins[j]] + 1;
					data[i] = j;
				}
			}
			pr(min);
			pr(data);
		}

		// show the data
		int ss = s;
		while (data[ss] != -1) {
			pr(coins[data[ss]]);
			ss = ss - coins[data[ss]];
		}
		return min[s];
	}
	public int minCoins444(int s, int[] coins) {
		int res = 0;
		int n = coins.length;
		int min[] = new int[s + 1];
		fill(min, 1, s + 1, Integer.MAX_VALUE);
		int data[] = new int[s + 1];
		fill(data, -1);
		// min[0]=0;
		boolean memo[]=new boolean[n];
		for (int i = 0; i <= s; i++) {
			for (int j = 0; j < n; j++) {
				if (coins[j] <= i 
						&& min[i - coins[j]] + 1 < min[i]) {
					min[i] = min[i - coins[j]] + 1;
					data[i] = j;
				}
			}
			pr(min);
			pr(data);
		}
		
		// show the data
		int ss = s;
		while (data[ss] != -1) {
			pr(coins[data[ss]]);
			ss = ss - coins[data[ss]];
		}
		return min[s];
	}
	
	public int minCoins4(int s, int[] coins) {
		int res = 0;
		int n = coins.length;
		int min[] = new int[s + 1];
		fill(min, 1, s + 1, Integer.MAX_VALUE);
		int data[] = new int[s + 1];
		fill(data, -1);
		// min[0]=0;

		for (int j = 0; j < n; j++) {
			for (int i = 0; i <= s; i++) {
				if (coins[j] <= i && min[i - coins[j]] + 1 < min[i]) {
					min[i] = min[i - coins[j]] + 1;
					data[i] = j;
				}
			}
			pr(min);
			pr(data);
		}

		// show the data
		int ss = s;
		while (data[ss] != -1) {
			pr(coins[data[ss]]);
			ss = ss - coins[data[ss]];
		}
		return min[s];
	}

	public static void main(String[] args) {
		// System.err.println(new Coins().minCoins(112, new int[] { 1, 3, 5 }));
		// System.err.println(new Coins().minCoins2(112, new int[] { 1, 3, 5
		// }));
		System.err.println(new Coins().minCoins444(11, new int[] { 1, 3, 5,2 }));
		// System.out.println(new Trainning().minCoinsRC(11, new int[]{1, 3,
		// 5}));
	}

	private static void pr(Object... rs) {
		System.err.println(Arrays.deepToString(rs).replace("]", "]\n"));
	}

}
