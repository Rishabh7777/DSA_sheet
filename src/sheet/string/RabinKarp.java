package sheet.string;

public class RabinKarp {
    private static void sol(String s, String pat) {
        int n = s.length();
        int m = pat.length();

        int p = 0; //hash value of pattern
        int t = 0; //hash value of substring in s of length m
        int h = (int)Math.pow(256, m-1); //for decreasing only hash value of first char in every window
        int q = 1 << 31; //to limit the value in range of int

        //find hash value of pattern
        //and hash value of initial substring in s of length m
        for(int i=0; i<m; i++) {
            p = (p * 256 + (int)pat.charAt(i)) % q;
            t = (t * 256 + (int)s.charAt(i)) % q;
        }
        //initial values of p and t can only be positive, if s and t consist of only alphabets

        for(int i=0; i<=n-m; i++) {
            if(p == t) {
                //if hash value matches, check for each char in the window
                int j = 0;
                for(; j<m; j++) {
                    if(pat.charAt(j) != s.charAt(j+i)) {
                        break; //char does not match
                    }
                }

                if(j == m) {
                    System.out.println("Pattern found at index: " + i);
                }
            }

            //use rolling hash function to update t
            //decrease hash value of first char and add hash value of next char
            if(i < n-m) {
                t = (256 * (t - s.charAt(i) * h) + s.charAt(i+m)) % q;
            }
            //the cyclic range of int can make t negative, but p is always positive
            if(t < 0) {
                t += q;
            }
        }
    } //O(n * m)

    public static void main(String[] args) {
        String s = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        sol(s, pat);
    }
}
