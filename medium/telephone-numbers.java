import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        Map<Character,StoredDigit> racine = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < N; i++) {
            String telephone = in.next();
            counter+=storePhoneNumber(telephone, racine, 0);
        }
        System.out.println(counter);
    }

    private static int storePhoneNumber(String telephone, Map<Character,StoredDigit> map, int counter) {
        if(telephone.length() == 0) {
            return counter;
        } else {
            Character c = telephone.charAt(0);
            StoredDigit digit;
            if(!map.containsKey(c)) {
                digit = new StoredDigit(c);
                counter++;
                map.put(c, digit);
            } else {
                digit = map.get(c);
            }
            return storePhoneNumber(telephone.substring(1), digit.next, counter);
        }
    }

    static class StoredDigit {
        public Character digit;
        public Map<Character,StoredDigit> next;

        public StoredDigit(Character digit) {
            this.digit = digit;
            next = new HashMap<>();
        }
    }
}
