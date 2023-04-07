import java.util.*;
import java.io.*;
import java.math.*;
import java.time.Duration;
import java.time.temporal.TemporalUnit;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Duration shortest = null;
        String sDuration = null;

        for (int i = 0; i < N; i++) {
            String t = in.next();
            String[] parts = t.split(":");
            Duration current = Duration.parse(String.format("P0DT%sH%sM%sS", parts[0], parts[1],parts[2]));
            if(shortest == null || current.getSeconds() < shortest.getSeconds()) {
                shortest = current;
                sDuration = t;
            }
        }
        System.out.println(sDuration);

    }
}
