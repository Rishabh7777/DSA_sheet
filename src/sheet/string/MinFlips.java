package sheet.string;

public class MinFlips {
    private static int minFlips(String S) {
        //even indices contains 1
        int even = 0;
        for(int i=0; i<S.length(); i++) {
            if(i%2 == 0) {
                //at even index
                if(S.charAt(i) != '1') {
                    even++;
                }
            } else {
                //at odd index
                if(S.charAt(i) != '0') {
                    even++;
                }
            }
        }

        //odd indices should contain 0s
        int odd = 0;
        for(int i=0; i<S.length(); i++) {
            if(i%2 == 0) {
                //at even index
                if(S.charAt(i) != '0') {
                    odd++;
                }
            } else {
                //at odd index
                if(S.charAt(i) != '1') {
                    odd++;
                }
            }
        }

        return Math.min(even, odd);
    }

    public static void main(String[] args) {
        String str = "0001010111";
        System.out.println(minFlips(str));
    }
}
