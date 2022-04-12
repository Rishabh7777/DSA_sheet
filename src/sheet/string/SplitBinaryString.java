package sheet.string;

//we have to split the string into maximum number of substrings containing equal number of 0s and 1s
public class SplitBinaryString {
    private static int sol(String s) {
        int count0 = 0, count1 = 0, res = 0; //res means number of substrings

        //loop through string s
        //count the number of 0s and 1s in the traversal, when they are equal, a required substring is found
        for(int i=0; i<s.length(); i++) {
            //increase respective count
            if(s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }

            if(count0 == count1) {
                res++;
                count0 = 0;
                count1 = 0;
            }
        }

        return res == 0 ? -1 : res;
    } //O(n)

    public static void main(String[] args) {
        String s = "0100110101";
        System.out.println(sol(s));
    }
}
