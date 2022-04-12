package sheet.string;

import java.util.HashMap;
import java.util.HashSet;

public class SmallestWindowContainingAllCharsOfString {
    private static String sol(String s) {
        HashSet<Character> set =new HashSet<>(); //to store all unique chars from string s
        HashMap<Character,Integer> map =new HashMap<>(); //to map each char with its index in string s
        int start = 0; //starting index of resulting window
        int end = 0; //ending index of resulting window
        int k = 0;
        int fl = Integer.MAX_VALUE;

        //add each char to set
        for(int i=0; i<s.length(); i++) {
            set.add(s.charAt(i));
        }

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i); //keep updating the index of each char to largest
            //when we have all unique chars required in map
            if(map.size() == set.size()){
                //keep updating k, it will point to the first index whose char is not available further
                //in the current window
                while(k < map.get(s.charAt(k))) {
                    k++;
                }

                //i -> index until which all unique chars are present
                //k -> before which chars are repeated in further window
                if(i-k < fl) {
                    fl = i - k;
                    start = k;
                    end = i + 1;
                }
            }
        }
        return s.substring(start,end);
    }

    public static void main(String[] args) {
        String s = "AABBBCBBAC";
        System.out.println(sol(s));
    }
}
