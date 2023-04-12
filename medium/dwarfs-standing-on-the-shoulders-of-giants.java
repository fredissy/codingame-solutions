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
        int n = in.nextInt(); // the number of relationships of influence

        Map<Integer, Personne> personnes = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int x = in.nextInt(); // a relationship of influence between two people (x influences y)
            int y = in.nextInt();
            Personne influenceur = null;
            Personne influence = null;
            if(personnes.containsKey(x)) {
                influenceur = personnes.get(x);
            } else {
                influenceur = new Personne(x);
            }
            if(personnes.containsKey(y)) {
                influence = personnes.get(y);
            } else {
                influence = new Personne(y);
            }
            influenceur.addInfluence(influence);
            personnes.put(x, influenceur);
            personnes.put(y, influence);
        }
        int longest = -1;
        for (Integer key : personnes.keySet()) {
            longest = Math.max(longest, longest(personnes.get(key), 1, ""+key));
        }

        System.out.println(longest);
    }

    public static int longest(Personne personne, int counter, String debug) {
        if(!personne.hasInfluences()) {
            System.err.println("Chaine courante : " + debug);
            System.err.println("=> Personne " + personne.getNumber() + " finale, return " + counter);
            return counter;
        }
        int max = 0;
        for(Integer key : personne.next.keySet()) {
            max = Math.max(max, longest(personne.next.get(key), counter+1, debug + ", " + key));
        }
        return max;
    }

    static class Personne {
        private int number;
        public Map<Integer, Personne> next;

        public Personne(int number) {
            this.number = number;
            this.next = new HashMap<>();
        }

        public void addInfluence(Personne influence) {
            next.put(influence.getNumber(), influence);
        }

        public int getNumber() {
            return number;
        }
        public boolean hasInfluences() {
            return !next.isEmpty();
        }
    }
}