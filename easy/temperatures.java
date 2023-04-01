import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static int resultatNeg = -274;
    static int resultatPos = 5527;
    static boolean positiveFound = false;
    static boolean negativeFound = false;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        for (int i = 0; i < n; i++) {
            int t = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            System.err.println("lu="+t);
            if(t > 0) {
                resultatPos = Math.min(t, resultatPos);
                positiveFound = true;
            }
            if(t < 0) {
                resultatNeg = Math.max(t, resultatNeg);
                negativeFound = true;
            }
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        if(!positiveFound && !negativeFound) {
            System.out.println(0);
        } else {
            System.err.println("resultatPos = " + resultatPos);
            System.err.println("resultatNeg = " + resultatNeg);
            if(positiveFound && !negativeFound) {
                System.out.println(resultatPos);
            }
            if(!positiveFound && negativeFound) {
                System.out.println(resultatNeg);
            }
            if(positiveFound && negativeFound) {
                if(resultatPos == Math.abs(resultatNeg)) {
                    System.out.println(resultatPos);
                } else {
                    System.out.println(Math.min(resultatPos, Math.abs(resultatNeg)));
                }
            }

        }
    }
}