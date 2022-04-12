package sheet.string;

import java.util.Arrays;

public class Problem42 {
    private static boolean areIsomorphic(String str1, String str2) {
        int size = 256; //number of characters in java

        if(str1.length() != str2.length()) {
            return false;
        }

        //using a boolean array to mark visited characters in str2.
        boolean[] marked = new boolean[size]; //initialised with false

        //using map to store mapping of every character from str1 to
        //that of str2. Initializing all entries of map as -1.
        int[] map = new int[size];
        Arrays.fill(map, -1);

        for (int i=0; i<str1.length(); i++) {
            //if current character of str1 is seen first time in map.
            if (map[str1.charAt(i)] == -1) {
                //if current character of str2 is already
                //seen, one to one mapping is not possible.
                if (marked[str2.charAt(i)]) {
                    return false;
                }

                //marking current character of str2 as visited.
                marked[str2.charAt(i)] = true;

                //storing mapping of current characters.
                map[str1.charAt(i)] = str2.charAt(i);
            } else if (map[str1.charAt(i)] != str2.charAt(i)) {
                //if this isn't first appearance of current character in str1 then
                //checking if previous appearance mapped to same character of str2
                return false;
            }
        }

        return true;
    } //O(n)

    public static void main(String[] args) {
        System.out.println(areIsomorphic("aab", "xxy"));
        System.out.println(areIsomorphic("aab", "xyz"));
        System.out.println(areIsomorphic("aba", "xyx"));
    }
}
