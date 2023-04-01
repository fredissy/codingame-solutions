import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();

        String binary01 = "";

        for(int i=0; i < MESSAGE.length(); i++) {
            String tmp = Integer.toBinaryString(MESSAGE.charAt(i));
            binary01 += String.format("%1$" + 7 + "s", tmp).replace(' ', '0');
        }
        System.err.println(MESSAGE +"=>" + binary01);

        char charAccumule = '2';
        int compteur = 1;
        for(int i=0; i < binary01.length(); i++) {
            char curChar = binary01.charAt(i);
            System.err.println("curChar=" + curChar);
            if(curChar == charAccumule) {
                compteur++;
                System.err.println("compteur=" + compteur);
            } else {
                if(charAccumule == '1') {
                    System.err.println("1=>" + compteur);
                    System.out.print("0 " + "0".repeat(compteur) + " ");
                } else if(charAccumule == '0') {
                    System.err.println("0=>" + compteur);
                    System.out.print("00 " + "0".repeat(compteur) + " ");
                }
                charAccumule = curChar;
                compteur = 1;
            }
        }
        if(charAccumule == '1') {
            System.err.println("1=>" + compteur);
            System.out.print("0 " + "0".repeat(compteur));
        } else if(charAccumule == '0') {
            System.err.println("0=>" + compteur);
            System.out.print("00 " + "0".repeat(compteur));
        }

        System.out.print("\n");
        
    }
}