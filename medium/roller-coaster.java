import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {

        long start = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        long L = in.nextLong();
        long C = in.nextLong();
        long N = in.nextLong();

        System.err.println("Capacité=" + L);
        System.err.println("Nb tours=" + C);
        System.err.println("Nb groupes=" + N);

        long amount = 0;

        List<Long> groups = new ArrayList<>();

        Map<Integer, Long> cacheAmount = new HashMap<>();
        Map<Integer, Integer> cacheNextIndex = new HashMap<>();
        //List<Long> boarded = new ArrayList<>();
        //System.err.println("Groupes :");
        for (long i = 0; i < N; i++) {
            Long pi = in.nextLong();
            //System.err.println(pi);
            groups.add(pi);
        }
        //System.err.println("=======");

        Long occupation = 0L;
        int index = 0;
        int indexDepart = 0;

        for(long tour = 0; tour <C; tour++ ) {
            occupation = 0L;
            boolean exit = false;
            Long tailleGroupeCourant = 0L;
            indexDepart = index;
            boolean first = true;

            while(occupation < L && !exit) {

                if(first) {
                    indexDepart = index;
                    first = false;
                } else {
                    exit = index == indexDepart;
                }

                if(!exit && cacheAmount.containsKey(indexDepart)) {
                    occupation = cacheAmount.get(indexDepart);
                    index = cacheNextIndex.get(indexDepart);
                    exit = true;
                }

                tailleGroupeCourant = groups.get(index);

                if(!exit && L-occupation >= tailleGroupeCourant) {
                    occupation += tailleGroupeCourant;
                    index++;
                    if(index == groups.size()) {
                        index = 0;
                    }
                } else {
                    exit = true;
                    cacheNextIndex.put(indexDepart, index);
                    cacheAmount.put(indexDepart, occupation);
                }
            }
            amount+=occupation;
        }

        long end = System.currentTimeMillis();
        System.err.println("" + (end-start) +  " ms");
        System.out.println(amount);
    }
}