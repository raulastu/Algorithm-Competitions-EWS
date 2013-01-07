package testing;

import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class NeuralNetwork {

    double wx[];
    double x0;

    public void go(double w[], double x[][], double[] y, double alfa) {
        int loops = 100;
        double _x[][] = new double[x.length * loops][x[0].length];
        double _y[] = new double[y.length * loops];
        for (int ii = 0; ii < loops; ii++) {
            for (int i = 0; i < x.length; i++) {
                _y[i + ii * x.length] = y[i];
                for (int j = 0; j < x[i].length; j++) {
                    _x[i + ii * x.length][j] = x[i][j];
                }
            }
        }
        x = _x;
        y = _y;

        double ww[][] = new double[x.length + 1][w.length];
        ww[0] = w;
        int k = 0;
        x0 = x[0][0];

        do {
//            double g = g(ww[k], x[k]); //sigma
            double g = tan(ww[k], x[k]);
//            System.err.println();
            double e = y[k] - g;
            wx = ww[k];
            if (e == 0) {
                break;
            }
            double norma = 0;
            for (int i = 0; i < ww[k].length; i++) {
                norma += x[k][i] * x[k][i];
            }

            for (int i = 0; i < ww[k].length; i++) {
                ww[k + 1][i] = ww[k][i] + alfa * 2 * e * (1 - g * g) * x[k][i];
            }
            //regla del perceptron
//            for (int i = 0; i < ww[k].length; i++) {
//                ww[k + 1][i] = ww[k][i] + alfa * e / norma * x[k][i];
//            }
            print(ww[k]);
            System.err.println("step " + k + ": " + e);
//            ww[k + 1] = new double[w.length];

        } while (ww.length - 1 > ++k);
        print(ww);
        print("processed in " + k, wx);
    }

    double limitadorDuro(double x[]) {
        double ink = 0;
        for (int i = 0; i < x.length; i++) {
            ink += wx[i + 1] * x[i];
        }
//        System.err.println(ink);
        return ink > 0 ? 1 : -1;
    }

    double tan(double w[], double x[]) {
        double ink = 0;
        for (int i = 0; i < x.length; i++) {
            ink += w[i] * x[i];
        }
//        System.err.println(ink);
        return tanh(ink);
    }

    double g(double w[], double x[]) {
        double s = 0;
        for (int i = 0; i < w.length; i++) {
            s += w[i] * x[i];
        }

        return s < 0 ? -1 : 1;
    }

    public static void main(String[] args) {
        NeuralNetwork boolFunc = new NeuralNetwork();

//        nn.go(new double[]{0.2, 0.1, 0.1},
//                new double[][]{
//                    {1, -1, -1}, //x0 x1, x2
//                    {1, -1, 1},
//                    {1, 1, -1},
//                    {1, 1, 1}},
//                new double[]{
//                    -1,
//                    1,
//                    1,
//                    1},
//                0.1);
        //AND
//        boolFunc.go(new double[]{0.2, 0.1, 0.1},
//                new double[][]{
//                    {1, -1, -1}, //x0 x1, x2
//                    {1, -1, 1},
//                    {1, 1, -1},
//                    {1, 1, 1}},
//                new double[]{
//                    -1,
//                    -1,
//                    -1,
//                    1},
//                0.1);
//        System.err.println(boolFunc.limitadorDuro(new double[]{-1, -1}));

        NeuralNetwork backSux = new NeuralNetwork();
        boolFunc.go(new double[]{0.1, 0.1, 0.1},
                new double[][]{
                    {1, 0.5, 0.4}, //x0 x1, x2
                    {1, 0.4, 0.7},},
                new double[]{
                    0.7,
                    0.8},
                0.1);

    }

    private static void print(Object... rs) {
        print("", rs);
    }

    private static void print(String msg, Object... rs) {
        String x = deepToString(rs);
        if (x.indexOf("[[") == 0) {
            x = x.substring(1, x.length() - 1);
        }
        System.err.println(msg + " " + x);
    }

    private static void printm(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.err.println("[" + a[i] + "]");
        }
    }

    private static void printm(char[][] a) {
        for (int i = 0; i < a.length; i++) {
            System.err.println("[" + new String(a[i]) + "]");
        }
    }
}
