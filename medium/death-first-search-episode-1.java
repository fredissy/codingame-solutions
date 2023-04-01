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
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        List<String> links = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            links.add(""+N1 + " " + N2);
        }
        List<String> gateways  = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            gateways.add(Integer.toString(EI));
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Bobnet agent is positioned this turn
            
            String link = linksToGateway(Integer.toString(SI), links, gateways);
            if(link != null) {
                System.err.println(link);
                System.out.println(link);
            } else {
                System.err.println(links.get(0));
                System.out.println(links.get(0));
            }
        }
    }

    public static String linksToGateway(String SI, List<String> links, List<String> gateways) {
        for (String gateway : gateways) {
            String linkTest = SI +" " + gateway;
            String linkTest2 = gateway + " " + SI;
            if(links.indexOf(linkTest) > -1) {
                return linkTest;
            }
            if(links.indexOf(linkTest2) > -1) {
                return linkTest2;
            }
        }
        return null;
    }
}