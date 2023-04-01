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
        String ans = in.nextLine();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        for (int j = 0; j < N; j++) {
            String answer=ans; // reset answer
            char[] result = new char[5];
            Arrays.fill(result, '?');

            String attempt = in.nextLine();
            // 1ere boucle, on match les # (bonnes places) :
            for (int i = 0; i < attempt.length(); i++) {
                char c = attempt.charAt(i);
                if (c == answer.charAt(i) && result[i] == '?') {
                    result[i]='#';
                    char[] ansChar = answer.toCharArray();
                    ansChar[i]='.';
                    answer = String.valueOf(ansChar);
                }
            }

            // 2eme boucle, les lettres présentes au mauvais emplacement O :
            for (int i = 0; i < attempt.length(); i++) {
                char c = attempt.charAt(i);
                int idxAnswer = answer.indexOf(c);
                if (idxAnswer > -1 && idxAnswer != i && result[i] == '?') {
                    result[i]='O';
                    char[] ansChar = answer.toCharArray();
                    ansChar[idxAnswer]='.';
                    answer = String.valueOf(ansChar);
                }
            }

            // 3e boucle, on match les lettres absentes X :
            for (int i = 0; i < attempt.length(); i++) {
                char c = attempt.charAt(i);
                if(answer.indexOf(c) == -1 && result[i] == '?') {
                    result[i]='X';
                }
            }
            System.out.println(String.valueOf(result));
        }
    }
}