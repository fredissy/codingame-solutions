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
        int N = in.nextInt();
        List<Utilisation> besoins = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int J = in.nextInt();
            int D = in.nextInt();
            besoins.add(new Utilisation(J, J + D - 1));
        }

        Collections.sort(besoins);

        int calculations = 0, lastEndTime = 0;
        for (Utilisation utilisation : besoins) {
            if (utilisation.fin > lastEndTime && utilisation.debut > lastEndTime) {
                lastEndTime = utilisation.fin;
                calculations++;
            }
        }

        System.out.println(calculations);

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        //System.out.println("answer");
    }

    static class Utilisation implements Comparable<Utilisation> {
        private int debut;
        private int fin;

        public Utilisation(int debut, int fin) {
            this.debut = debut;
            this.fin = fin;
        }

        @Override
        public int compareTo(Solution.Utilisation o) {
            return this.fin - o.fin;
        }
    }
}