package sheet.string;

//minimum chars to be inserted in front of a string to make it palindrome
public class MakeStringPalindrome {
    private static boolean checkPalindrome(String str) {
        for(int i=0; i<str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    } //O(n)

    private static int naive(String str) {
        //check each time weather the string is palindrome or not
        //if not delete last char of the string and check again
        int cnt = 0;
        while(!checkPalindrome(str)) {
            str = str.substring(0, str.length()-1);
            cnt++;
        }

        return cnt;
    }

    //using the lps array of KMP algo
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

    private static int optimized(String str) {
        StringBuilder rev = new StringBuilder(str);
        rev.reverse();
        String s = str + "$" + rev;

        int[] lps = lps(s);
        //the last value of lps gives the longest palindrome in str from index 0
        //thus the remaining chars needs to be inserted at front
        return str.length() - lps[lps.length - 1];
    } //O(n)

    public static void main(String[] args) {
        String str = "ABC";
        System.out.println(optimized(str));
    }
}
