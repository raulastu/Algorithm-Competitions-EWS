package util;

import java.util.Arrays;

public class Print {
	public static void pr(Object... ob) {
			System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}

