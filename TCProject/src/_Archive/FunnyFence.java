package _Archive;

import java.util.*;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class FunnyFence {

    public int getLength(String s) {
        int res;
        boolean ok = true;
        int max = 1;
        int x = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                x++;
                max = max(x, max);
            } else {
                x = 1;
            }
        }
        return max;
    }

}


// Powered by FileEdit
// Powered by CodeProcessor


// Powered by FileEdit
// Powered by CodeProcessor
