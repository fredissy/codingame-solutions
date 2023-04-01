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
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            map.put(EXT.toLowerCase(), MT);
        }
        in.nextLine();
        System.err.println("========");
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            System.err.println(FNAME);
            
            Optional<String> ext = getExtensionByStringHandling(FNAME);

            if(ext.isPresent()) {
                System.out.println(map.getOrDefault(ext.get().toLowerCase(), "UNKNOWN"));
            } else {
                System.out.println( "UNKNOWN");
            }
            System.err.println("--");
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");



    }

public static Optional<String> getExtensionByStringHandling(String filename) {
    return Optional.ofNullable(filename)
      .filter(f -> f.contains("."))
      .map(f -> f.substring(filename.lastIndexOf(".") + 1));
}
}