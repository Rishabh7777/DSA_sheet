package sheet.string;

public class Problem41 {
    private static int sol(String A, String B) {
        //first check if A and B contain the same set of characters
        if(A.length() != B.length()) {
            return -1;
        }
        int[] countChar = new int[26];
        for(int i=0; i<A.length(); i++) {
            countChar[A.charAt(i) - 'A']++;
            countChar[B.charAt(i) - 'A']--;
        }
        for(int i: countChar) {
            if(i != 0) {
                return -1;
            }
        }

        //now find number of operations required to convert A to B
        int i=A.length()-1, j=B.length()-1;
        int res = 0; //number of operations
        while(i >= 0) {
            if(A.charAt(i) == B.charAt(j)) {
                j--;
            } else {
                res++;
            }
            i--;
        }

        return res;
    } //O(n)

    public static void main(String[] args) {
        System.out.println(sol("ABD", "BAD"));
        System.out.println(sol("EACBD", "EABCD"));
    }
}
