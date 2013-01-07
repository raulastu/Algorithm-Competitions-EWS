package judges.UVA;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main3 {

	static char ch[][];
	static int visit[][];
	static int suma = 0;
	static int X[] = { 0, 1, -1, 0 };
	static int Y[] = { 1, 0, 0, -1 };

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		 Scanner in = new Scanner(System.in);
//		BufferedReader in = new BufferedReader(new InputStreamReader(
//				new BufferedInputStream(System.in)));
		PrintWriter out = new PrintWriter(System.out);

		int indice = 1;
		while (true) {
			String cad[] = in.nextLine().split(" ");

			int width = Integer.parseInt(cad[0]);
			int height = Integer.parseInt(cad[1]);

			if (width == 0 && height == 0)
				break;

			ch = new char[height][width];
			visit = new int[height][width];

			// obtener datos de la cadena y rellenarlos en el arreglo
			for (int i = 0; i < height; i++) {
				String txt = in.nextLine();
				ch[i] = txt.toCharArray();
			}

			// fin de lo basico empiezo de BFS

			// elimino las X repetidas y obtengo los datos

			ArrayList<Integer> res = new ArrayList<Integer>();

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if (ch[i][j] == 'X' || ch[i][j] == '*' && visit[i][j]==0) {
						res.add(solve(i, j));
					}

				}

			}
			Collections.sort(res);
			String rr = res.toString().replace("[", "").replace("]", "").replace(",", "");
//			System.err.println(rr);
//			print(rr);
			System.out.println("Throw " + indice + "\n" + rr + "\n");
			// System.out.println("Throw " + indice + "\n1 2 3\n");

			indice++;
		}

		in.close();
		out.close();
	}

//	private static void print(Object... rs) {
//		System.err.println(Arrays.deepToString(rs));
//	}

	public static int solve(int x, int y) {
		visit[x][y] = 1;
		int r = 0;
		if (ch[x][y] == 'X') {
			ch[x][y]='*';
			r++;
//			visit[x][y] = 0;
			goForX(x, y);
		}
		for (int i = 0; i < X.length; i++) {
			int X1 = X[i] + x;
			int Y1 = Y[i] + y;
			if (X1 >= 0 && Y1 >= 0 && X1 < ch.length && Y1 < ch[X1].length
					&& ch[X1][Y1] != '.'
					&& visit[X1][Y1] == 0) {
				r+=solve(X1, Y1);
			}
		}
		return r;
	}

	public static void goForX(int x, int y) {
		// visit[x][y]=1;
		for (int i = 0; i < X.length; i++) {
			int X1 = X[i] + x;
			int Y1 = Y[i] + y;
			if (X1 >= 0 && Y1 >= 0 && X1 < ch.length && Y1 < ch[X1].length && ch[X1][Y1] == 'X') {
				ch[X1][Y1] = '*';
				goForX(X1, Y1);
			}
		}
	}
}
