package _Archive;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Domino {

    public static void main(String[] args) throws Exception {
        PrintWriter pw1 = new PrintWriter(new File("C:/domino.in"));
        PrintWriter pw2 = new PrintWriter(new File("C:/domino.sol"));
        pw1.println(60);
        for (int i = 1; i <= 60; i++) {
            Scanner sc = new Scanner(System.in);
            long[] a = new long[60];
            a[0] = 1;
            a[1] = 2;
            for (int j = 2; j < 60; j++) {
                a[j] = a[j - 1] + a[j - 2];
            }
            pw1.println(i);
            pw2.println("Caso #" + i + ": " + a[i - 1]);
        }
        pw1.close();
        pw2.close();
    }
}
