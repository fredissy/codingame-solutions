import java.util.*;
import java.io.*;
import java.math.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String BEGIN = in.next();
        String END = in.next();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate dateBegin = LocalDate.parse(BEGIN, formatter);
        LocalDate dateEnd = LocalDate.parse(END, formatter);

        long years=ChronoUnit.YEARS.between(dateBegin, dateEnd);
        long months=ChronoUnit.MONTHS.between(dateBegin, dateEnd)-(years*12);
        long days=ChronoUnit.DAYS.between(dateBegin, dateEnd);

         String out = "";
         if(years > 1) {
             out +=years + " years, ";
         } else if (years==1) {
             out +=years + " year, ";
         }

         if(months > 1) {
             out +=months + " months, ";
         } else if (months==1) {
             out +="1 month, ";
         }
         out +="total " + days + " days";

        System.out.println(out);
    }
}
