package sheet.string;

public class KMP {
    //it can be done with preprocessing part of KMP algo
    //prefix always starts with index 0 and does not include last index
    //while suffix always includes last index and does not include first index
    private static int[] lps(String s) {
        int[] lps = new int[s.length()]; //lps[i] have max length of prefix which is same as suffix

        int i = 1, j = 0;
        while(i < s.length()) {
            if(s.charAt(j) == s.charAt(i)) {
                //current prefix is same as suffix
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if(j > 0) {
                    //try to match with a substring of current prefix
                    j = lps[j-1];
                } else {
                    //j cannot be decreased more, current prefix do not match with suffix
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    } //O(n)

    private static void sol(String s, String pat) {
        int[] lps = lps(pat);

        int i=0, j=0; //i -> pat, j -> s
        while(j < s.length()) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            } else {
                if(i > 0) {
                    i = lps[i - 1];
                } else {
                    j++;
                }
            }

            if(i == pat.length()) {
                System.out.println("pattern found at index: " + (j-pat.length()));
                i = 0;
            }
        }
    } //O(n)

    public static void main(String[] args) {
        String s = "geeks for geeks";
        String pat = "geek";
        sol(s, pat);
    }
}
