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
        int w = in.nextInt();
        int h = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        int[][] tableau = new int[w][h];
        int y = -1;
        for (int i = 0; i < h; i++) {
            String line = in.nextLine();
            y++;
            for(int x = 0; x < w; x++) {
                tableau[x][y] = line.charAt(x) == 'x' ?1:0;
            }
        }
        for(y = 0; y < h; y++) {
            for(int x = 0; x < w; x++) {
                countMines(tableau, x, y, w, h);
            }
            System.out.print("\n");
        }
    }

    public static void countMines(int[][] tableau, int x, int y, int w, int h) {
        int mines = 0;
        for(int yy = Math.max(0, y-1); yy <= Math.min(y+1, h-1); yy++) {

            for(int xx = Math.max(0,x-1); xx <=Math.min(x+1, w-1); xx++) {
                if(xx !=x || yy != y) {
                    mines += tableau[xx][yy];
                }
            }
        }
        System.out.print(mines == 0 || tableau[x][y] ==1 ? ".": mines);
    }
}