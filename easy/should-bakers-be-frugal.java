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
        double side = in.nextFloat();
        double diameter = in.nextFloat();

        double surface = side * side;
        double rayonBiscuit = diameter / 2;
        double surfaceBiscuit = Math.PI * rayonBiscuit * rayonBiscuit;

        int wasteful = countForSide(side, diameter);
        int nb = 0;
        int totalFrugal = 0;
        while ((nb = countForSide(side, diameter)) >= 1) {
            totalFrugal += nb;
            surface = surface - nb * surfaceBiscuit;
            side = Math.sqrt(surface);
        }
        System.out.println(totalFrugal-wasteful);
    }

    public static int countForSide(double side, double diameter) {
        int nbsides = (int) (side / diameter);
        return nbsides *nbsides;
    }

}