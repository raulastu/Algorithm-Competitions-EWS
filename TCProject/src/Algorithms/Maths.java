/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

public class Maths {

    //greatest common divisor
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    //lowest common multiply

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
//        System.err.println();
        for (int i = 0; i < 1000000; i++) {
            int a = new Primos().gcd(i, 145);
            System.err.println("err");
            break;
        }
        System.err.println(new Primos().lcm(6, 9));
        System.err.println(new Primos().gcd(56, 42));
    }
}
