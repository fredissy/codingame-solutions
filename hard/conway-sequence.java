import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int L = in.nextInt();


        List<Integer> input = Arrays.asList(R);

        //String input = String.valueOf(R);

        for(int i = 1; i < L; i++) {
            System.err.println("i = " + i);
            input = countString(input);
            System.err.println("-------");
        }

        String listString = input.stream().map(Object::toString)
                        .collect(Collectors.joining(" "));
        System.out.println(listString);
    }

    public static List<Integer> countString(List<Integer> input) {
        System.err.println("input = " + input);
        List<Integer> output = new ArrayList<>();
        int currentVal = 0;
        int count = 0;
        for(int i=0; i < input.size(); i++) {
            if(currentVal == 0 || currentVal != input.get(i)) {
                if(currentVal > 0) {
                    output.add(count);
                    output.add(currentVal);
                }
                currentVal = input.get(i);
                count = 1;

            } else {
                count++;
            }
        }
        output.add(count);
        output.add(currentVal);
        System.err.println("=> " + output);
        return output;
    }
}