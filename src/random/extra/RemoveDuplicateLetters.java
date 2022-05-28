package random.extra;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        //to count total occurrences of each letter in s
        int[] freq = new int[26];
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        //to keep track of all chars already included in result
        boolean[] included = new boolean[26];
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            //do not process already included char
            if(included[curr - 'a']) {
                freq[curr - 'a']--;
                continue;
            }
            //pop the elements from stack is possible
            while(!st.isEmpty() && st.peek() > curr && freq[st.peek() - 'a'] > 0) {
                included[st.peek() - 'a'] = false;
                st.pop();
            }
            //push current char into stack
            st.push(curr);
            freq[curr - 'a']--;
            included[curr - 'a'] = true;
        }
        //now stack contains the result string
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) {
            res.insert(0, st.pop());
        }
        //return result
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "abacb";
        System.out.println(removeDuplicateLetters(str));

        str = "acabc";
        System.out.println(removeDuplicateLetters(str));
    }
}
