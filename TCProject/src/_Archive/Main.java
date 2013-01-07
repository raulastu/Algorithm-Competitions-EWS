package _Archive;


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(System.in);
        String game = in.readLine().replace(" ", "").trim();
        Queue<String[]> q = new LinkedList<String[]>();
        Set<String> memo = new HashSet<String>();
        memo.add(game);
        q.add(new String[]{game, ""});
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};
        char[] ds = {'u', 'd', 'l', 'r'};
        boolean sol = false;
        while (!q.isEmpty()) {
            String[] l = q.poll();
            String p = l[0];
            if (p.equals("12345678x")) {
                System.out.println(l[1]);
                sol = true;
                break;
            }
            int x = -1;
            int y = -1;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'x') {
                    x = i / 3;
                    y = i % 3;
                    break;
                }
            }
            int loc = x * 3 + y;
            for (int i = 0; i < 4; i++) {
                int X = x + di[i];
                int Y = y + dj[i];
                if (X >= 0 && X < 3 && Y >= 0 && Y < 3) {
                    StringBuffer sb = new StringBuffer(p);
                    sb.setCharAt(loc, sb.charAt(X * 3 + Y));
                    sb.setCharAt(X * 3 + Y, 'x');
                    if (!memo.contains(sb + "")) {
                        memo.add(sb + "");
                        q.add(new String[]{sb + "", l[1] + ds[i]});
                    }
                }
            }
        }
        if (!sol) {
            System.out.println("unsolvable");
        }
        in.close();
//        System.out.println(System.currentTimeMillis() - a);
    }
}
//rC template