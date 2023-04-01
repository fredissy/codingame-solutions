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
        String textToDecode = in.nextLine();

        int decalage = trouveDecalage(textToDecode);
        System.err.println("decalage trouve=" + decalage);
        if(decalage == -999) {
            System.out.println("WRONG MESSAGE");
        } else {
            for(int i=0; i < textToDecode.length(); i++) {
                if(textToDecode.charAt(i) == ' ') {
                    System.out.print(" ");
                } else {
                    int charCible = (textToDecode.charAt(i)+decalage);
                    if(charCible < 'A') {
                        charCible = charCible + 'Z' - 'A'+1;
                    }
                    System.err.print("i="+charCible + " ");

                    System.out.print(Character.toString((char)(charCible)));
                }
            }
        }

    }

    private static int trouveDecalage(String input) {
        int chiefLength = "CHIEF".length();
        System.err.println("Debut trouveDecalage()");
        for (int i = 0; i < input.length() - chiefLength+1; i++) {
            System.err.println("i=" + i);
            if (matchCHIEF(input.substring(i).toCharArray())) {
                 
                if ((i == 0 || input.substring(i - 1, i).equals(" "))
                 && (i + chiefLength == input.length()
                 || (i+chiefLength+1 < input.length()
                    &&input.substring(i+chiefLength, i+chiefLength+1).equals(" ")))) {
                return 'C' - input.codePointAt(i);
            }
            }
        }
        return -999;
    }

    private static boolean matchCHIEF(char[] chief) {
        System.err.println("Tentative match sur " + Arrays.toString(chief));
        boolean result = (chief[1] - chief[0] == 5
                && chief[2] - chief[1] == 1
                && chief[3] - chief[2] == -4
                && chief[4] - chief[3] == 1);

        System.err.println("result= " + result);

        return result;
    }
}