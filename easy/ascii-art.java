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
        int L = in.nextInt();
        int H = in.nextInt();

        List<String> ascii = new ArrayList<>();

        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            ascii.add(ROW);
        }

        char[] message = T.toUpperCase().toCharArray();
        for(int i = 0; i < H; i++) {

            for (char character : message) {
                if(character >='A' && character <='Z') {
                    int position = character - 'A';
                    System.out.print(ascii.get(i).substring(L * position, L * (position + 1)));
                } else {
                    System.out.print(ascii.get(i).substring(L * 26, L * 27));
                }
            }
            System.out.println();
        }
    }
}