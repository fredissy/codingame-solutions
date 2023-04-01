import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt(); // position de départ X
        int Y0 = in.nextInt(); // position de départ Y

        int zoneXmax = W;
        int zoneXmin = 0;
        int zoneYmax = H;
        int zoneYmin = 0;

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            System.err.println("bombDir="+bombDir);
            switch(bombDir) {
                case "UR": // ok
                    zoneXmin = X0+1; // R
                    zoneYmax = Y0-1; // U
                    break;
                case "R": // ok
                    zoneXmin = X0+1; // R
                    zoneYmin = Y0;
                    zoneYmax = Y0;
                    break;
                case "DR": // ok
                    zoneXmin = X0+1; // R
                    zoneYmin = Y0+1; // D
                    break;
                case "D":
                    zoneXmin = X0;
                    zoneXmax = X0;
                    zoneYmin = Y0+1; // D
                    break;
                case "DL":
                    zoneXmax = X0-1; // L
                    zoneYmin = Y0-1; //D
                    
                    break;
                case "L":
                    zoneYmin = Y0;
                    zoneYmax = Y0;
                    zoneXmax = X0-1; // L
                    break;
                case "UL":
                    zoneXmax = X0-1; // L
                    zoneYmax = Y0-1; // U
                    break;
                case "U":
                    zoneXmin = X0;
                    zoneXmax = X0;
                    zoneYmax = Y0-1; // U
                    break;

            }
            System.err.println("zoneX=" + zoneXmin + "-" + zoneXmax);
            System.err.println("zoneY=" + zoneYmin + "-" + zoneYmax);
            X0 = (zoneXmax + zoneXmin)/2;
            Y0 = (zoneYmax + zoneYmin)/2;

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // the location of the next window Batman should jump to.
            System.out.println(""+X0+" " + Y0);
        }
    }
}