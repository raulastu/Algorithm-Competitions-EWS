package Util;

import java.awt.Graphics;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sun.swing.PrintColorUIResource;

/**
 *
 * @author rC
 */
public class Drawing {

    public static int drawXY(final int[] x, final int[] y) {
        final int m = 400;
        final int width = 20;

//        String[] res = transform(x, y);
//        print(res);
//        for (int i = 0; i < res.length; i++) {
//            x[i] = Integer.parseInt(res[i].split(" ")[0]);
//            y[i] = Integer.parseInt(res[i].split(" ")[1]);
//        }

        JPanel pan = new JPanel() {

            @Override
            public void paint(Graphics g) {
                for (int i = width / 2; i < (m + width) * 2; i += width) {
                    g.drawLine(i, 0, i, (m + width) * 2);
                }
                for (int i = width / 2; i < (m + width) * 2; i += width) {
//                    System.out.println(i);
                    g.drawLine(0, i, (m + width) * 2, i);
                }
                for (int i = 0; i < y.length; i++) {
                    g.fillOval(
                            x[i] * width + m, -y[i] * width + m, width, width);
                    g.fill3DRect(0, m + width / 2, (m + width / 2) * 2, 2, false);
                    g.fill3DRect(m + width / 2, 0, 2, 2 * (m + width / 2), false);
                }
            }
        };
        JFrame fr = new JFrame();
        fr.add(pan);
        fr.setSize((m + width) * 2, (m + width) * 2);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return 1;
    }

    public static int drawXY2(final int[] x, final int[] y) {
        final int m = 400;
        final int width = 20;

        String[] res = transform(x, y);
        print(res);
        for (int i = 0; i < res.length; i++) {
            x[i] = Integer.parseInt(res[i].split(" ")[0]);
            y[i] = Integer.parseInt(res[i].split(" ")[1]);
        }

        JPanel pan = new JPanel() {

            @Override
            public void paint(Graphics g) {
                for (int i = width / 2; i < (m + width) * 2; i += width) {
                    g.drawLine(i, 0, i, (m + width) * 2);
                }
                for (int i = width / 2; i < (m + width) * 2; i += width) {
//                    System.out.println(i);
                    g.drawLine(0, i, (m + width) * 2, i);
                }
                for (int i = 0; i < y.length; i++) {
                    g.fillOval(
                            x[i] * width + m, -y[i] * width + m, width, width);
                    g.fill3DRect(0, m + width / 2, (m + width / 2) * 2, 2, false);
                    g.fill3DRect(m + width / 2, 0, 2, 2 * (m + width / 2), false);
                }
            }
        };
        JFrame fr = new JFrame();
        fr.add(pan);
        fr.setSize((m + width) * 2, (m + width) * 2);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return 1;
    }
    static int factor = 200;

    static public String[] transform(int[] x, int[] y) {
        String[] res;
        int minx = x[0], miny = y[0], maxx = x[0], maxy = y[0];
        for (int i = 0; i < x.length; i++) {
            minx = Math.min(minx, x[i]);
            maxx = Math.max(maxx, x[i]);
            miny = Math.min(miny, y[i]);
            maxy = Math.max(maxy, y[i]);
        }
        double fx = factor / (double) (maxx - minx);
        double fy = factor / (double) (maxy - miny);
        for (int i = 0; i < x.length; i++) {
            x[i] += -minx;
            x[i] = (int) Math.round(x[i] * fx);
            y[i] += -miny;
            y[i] = (int) Math.round(y[i] * fy);
        }
        res = new String[x.length];
        for (int i = 0; i < x.length; i++) {
            res[i] = x[i] + " " + y[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] x = {1, 2};
        int[] y = {1, 2};
//        Drawing.drawXY(x, y);
//        Drawing.drawXY(new int[]{-1, 1, 0, 0}, new int[]{0, 0, -1, 1});
//        Drawing.drawXY(new int[]{4, 5, 0, 8, -3, 5, 4, 7}, new int[]{9, -4, 2, 1, 1, 11, 0, 2});
//        Drawing.drawXY(new int[]{4, 4, 4}, new int[]{7, 7, 7});
//        Drawing.drawXY(new int[]{1, 7, 3, 4, 9, 3, 7, 1, 1, 6, 1, 6, 1, 9, 7, 9, 4, 9, 1, 4, 7, 1, 2, 5, 3, 8, 7, 7, 1}, new int[]{7, 2, 8, 9, 4, 3, 4, 1, 4, 1, 7, 8, 1, 1, 1, 4, 7, 1, 9, 4, 9, 1, 4, 1, 1, 1, 2, 4, 3});
        Drawing.drawXY2(x, y);
        Drawing.drawXY2(new int[]{-1, 1, 0, 0}, new int[]{0, 0, -1, 1});
        Drawing.drawXY2(new int[]{4, 5, 0, 8, -3, 5, 4, 7}, new int[]{9, -4, 2, 1, 1, 11, 0, 2});
        Drawing.drawXY2(new int[]{4, 4, 4}, new int[]{7, 7, 7});
        Drawing.drawXY2(new int[]{1, 7, 3, 4, 9, 3, 7, 1, 1, 6, 1, 6, 1, 9, 7, 9, 4, 9, 1, 4, 7, 1, 2, 5, 3, 8, 7, 7, 1}, new int[]{7, 2, 8, 9, 4, 3, 4, 1, 4, 1, 7, 8, 1, 1, 1, 4, 7, 1, 9, 4, 9, 1, 4, 1, 1, 1, 2, 4, 3});
    }

    private static void print(Object... rs) {
        print("", rs);
    }

    private static void print(String msg, Object... rs) {
        String x = Arrays.deepToString(rs);
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

