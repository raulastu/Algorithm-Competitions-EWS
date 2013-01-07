/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Arrays;

/**
 *
 * @author danteUser
 */
public class FloydWarshall {

    public int floyd(int n, String[] l) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i], Integer.MAX_VALUE);
            mat[i][i] = 0;
        }
        for (int i = 0; i < l.length; i++) {
            String[] string = l[i].split(" ");
            int a = Integer.parseInt(string[0]);
            int b = Integer.parseInt(string[1]);
            int dist = Integer.parseInt(string[2]);
            mat[a - 1][b - 1] = dist;
            mat[b - 1][a - 1] = dist;
        }
        printm(mat);
        for (int k = 0; k < mat.length; k++) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = i + 1; j < mat[i].length; j++) {
                    int c = (mat[i][k] == Integer.MAX_VALUE || mat[k][j] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : mat[i][k] + mat[k][j];
                    mat[i][j] = Math.min(mat[i][j], c);
                    mat[j][i] = mat[i][j];
//                    }
                }
            }
        }
        printm(mat);
        return mat[2][3];
    }

    public static void main(String[] args) {
        String[] a = {"1 2 3", "1 3 5", "2 5 9", "3 4 7", "3 6 1", "4 6 4", "1 4 1", "3 5 7"};
        System.err.println(new FloydWarshall().floyd(6, a));
    }

    private static void printm(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.err.print("[" + a[i][j] + "]");
            }
            System.err.println("");
        }
    }
}
