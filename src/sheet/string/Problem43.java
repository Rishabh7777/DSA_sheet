package sheet.string;

import java.util.ArrayList;

public class Problem43 {
    private static ArrayList<String> sent;

    private static void sol(String[][] words, int row, String curr) {
        if(row == words.length) {
            sent.add(curr);
            return;
        }

        for(int i=0; i<words[row].length; i++) {
            sol(words, row+1, curr+words[row][i]+" ");
        }
    }

    public static void main(String[] args) {
        String[][] words = new String[3][2];
        words[0][0] = "you";
        words[0][1] = "we";
        words[1][0] = "have";
        words[1][1] = "are";
        words[2][0] = "sleep";
        words[2][1] = "eat";
        sent = new ArrayList<>();
        sol(words, 0, "");
        for(String s: sent) {
            System.out.println(s);
        }
    }
}
