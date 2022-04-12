package sheet.string;

public class LongestCommonPrefix {
    private static String longestCommonPrefix(String[] str) {
        //if there is only one string in str
        if(str.length == 0) {
            return "";
        }

        String ans = str[0];
        for(int i=1; i<str.length; i++){
            //keep reducing the common substring, if the current string in str does not starts with ans
            while(!str[i].startsWith(ans)){
                ans = ans.substring(0, ans.length()-1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));
    }
}
