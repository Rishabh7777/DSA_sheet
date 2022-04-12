package sheet.string;

//find a window of minimum length in s which contains all characters of p even the repeated
//if more than 1 window of minimum length found then return window with minimum index
public class Problem37 {
    private static String smallestWindow(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();

        //if length of string p is greater than string s then we return -1.
        //if chars in p are repeated then they should be present in same number in s
        if(len1 < len2) {
            return "-1";
        }

        //using hash tables to store the count of characters in strings.
        int[] countP = new int[256];
        int[] countS = new int[256];

        //storing the count of characters in string p in hash table.
        for(int i=0; i<len2; i++){
            countP[p.charAt(i)]++;
        }

        int start = 0;
        int startIndex = -1;
        int minLen = Integer.MAX_VALUE; //min length of window required
        int count = 0;

        for(int j=0; j<len1; j++) {
            //storing the count of characters in string s in hash table.
            countS[s.charAt(j)]++;

            //if count of current character in string s is equal to or less
            //than in string p, we increment the counter.
            if(countP[s.charAt(j)] != 0 && countS[s.charAt(j)] <= countP[s.charAt(j)]) {
                count++;
            }

            //if all the characters are matched
            if(count == len2) {
                while(countS[s.charAt(start)] > countP[s.charAt(start)] || countP[s.charAt(start)] == 0) {
                    //we try to minimize the window
                    if(countS[s.charAt(start)] > countP[s.charAt(start)]) {
                        countS[s.charAt(start)]--;
                    }
                    start++;
                }

                //updating window size.
                int lenWindow = j - start + 1;
                if(minLen > lenWindow) {
                    //if new minimum sub-string is found, we store value
                    //of its starting index for newly found window.
                    minLen = lenWindow;
                    startIndex = start;
                }
            }
        }

        //returning the smallest window or -1 if no such window is present.
        if(startIndex == -1) {
            return("-1");
        } else {
            return(s.substring(startIndex, startIndex + minLen));
        }
    }

    public static void main(String[] args) {
        String s = "zoomlazapzo";
        String p = "oza";
        System.out.println(smallestWindow(s, p));
    }
}
