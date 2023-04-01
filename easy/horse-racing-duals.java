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
        List<Integer> puissances = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            puissances.add(pi);
        }
        Collections.sort(puissances);
        int diff = Integer.MAX_VALUE;
        for(int i=0;i<puissances.size()-1; i++) {
            int p1 = puissances.get(i);
            int p2 = puissances.get(i+1);
            diff = Math.min(diff, Math.abs(p1-p2));
        }
        System.out.println(diff);
    }
}