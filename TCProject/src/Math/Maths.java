/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

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
}
