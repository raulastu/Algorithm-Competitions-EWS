

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[][] grid;
	int[][] memo;
	int[] A = { 1, 1, 1, 0, 0, -1, -1, -1 };
	int[] B = { 1, 0, -1, 1, -1, 1, 0, -1 };

	public int countCell() {
		memo = new int[grid.length][grid[0].length];
		int mayor = 0;
		for (int ind = 0; ind < grid.length; ind++) {
			for (int j = 0; j < grid[ind].length; j++) {
				if (memo[ind][j] == 0 && grid[ind][j] == '1') {
					int cant = buscar(ind, j);
					mayor = Math.max(mayor, cant);
				}
			}
		}
		return mayor;
	}

	public int buscar(int x, int y) {

		memo[x][y] = 1;
		int cant = 1;
		for (int i = 0; i < B.length; i++) {
			int X = x + A[i];
			int Y = y + B[i];
			if (X >= 0 && Y >= 0 && X < grid.length && Y < grid[X].length && memo[X][Y] == 0
					&& grid[X][Y] == '1') {
				cant = cant + buscar(X, Y);
			}
		}
		return cant;
	}

	public static void main(String[] args) throws Exception{

//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("/Users/rc/git/TCProject/src/Judges_HuaHCoding/input_temp_case"));
		int numC = Integer.parseInt(sc.nextLine());
		sc.nextLine();
		for (int ind = 0; ind < numC; ind++) {
			ArrayList<char[]> arr = new ArrayList<char[]>();
			while (sc.hasNextLine()){
				String lin = sc.nextLine();
				if(lin.equals("")){
					System.out.println();
					break;
				}
					
				arr.add(lin.toCharArray());
			}
			grid= new char[arr.size()][arr.get(0).length];
			for (int i = 0; i < arr.size(); i++) {
				grid[i]=arr.get(i);
			}
//			printm(grid);
			Main m = new Main();
			System.out.println(m.countCell());
		}
	}
	static void print(Object... ob){
		System.out.println(Arrays.deepToString(ob));
	}
	static void printm(Object... ob){
		System.out.println(Arrays.deepToString(ob).replace("],", "],\n"));
	}
}