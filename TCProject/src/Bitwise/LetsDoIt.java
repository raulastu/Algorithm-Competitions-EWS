package Bitwise;

import java.util.*;
import java.util.ArrayList;
import java.util.regex.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.util.Collections.*;

public class LetsDoIt {

    public static void main(String[] args) {
        int A = 10;
        float a = A;
        int B = 12;
        int C = A | B;

        System.err.println(toBinaryString(A) + " " + toBinaryString(B));
        System.err.println(Integer.toBinaryString(C));
        System.err.println(toBinaryString(1 << 2));
        System.err.println(Integer.numberOfTrailingZeros(A));
    }
}
