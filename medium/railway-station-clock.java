import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;
import java.time.format.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String time = in.nextLine();

        System.err.println("Entrée = " + time);

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("h:mm:ss a");
        LocalTime observe = LocalTime.parse(time, pattern);
        LocalTime reset = LocalTime.parse("08:00:00 AM", pattern);
        int nbSec = 0;
        if(observe.equals(reset)) {
            nbSec = 0;
        } else if(observe.isAfter(reset)) {
            // nb de secondes depuis 8h00m00s le jour même :
            nbSec = (observe.getHour()-8)*3600 + observe.getMinute() * 60 + observe.getSecond();
        } else {
            // nb de secondes depuis 8h00m00s la veille :
            nbSec = (16 + observe.getHour())*3600 + observe.getMinute() * 60 + observe.getSecond();
        }
        int nbSecReelles = (nbSec * 240) / 239;

        reset = reset.plusSeconds(nbSecReelles);

        



        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(reset.format(pattern));
    }
}