package sheet.string;

import java.util.Stack;

//remove adjacent duplicate characters in a string
public class Problem38 {
    //using Stack
    //push char into Stack if current char does not match with top of Stack
    //after traversing whole String, pop chars from Stack and form result string
    private static String removeConsecutiveCharacter(String S) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<S.length(); i++) {
            if(st.isEmpty()) {
                st.push(S.charAt(i));
            } else {
                if(st.peek() != S.charAt(i)) {
                    st.push(S.charAt(i));
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) {
            res.insert(0, st.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "aabaa";
        System.out.println(removeConsecutiveCharacter(s));
    }
}
