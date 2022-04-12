package sheet.string;

public class MinSwapsBracketBalancing {
    private static int minSwaps(String s) {
        int ob = 0; //count of opening brackets
        int cb = 0; //count of closing brackets
        int fault = 0; //number of brackets still unbalanced
        int swaps = 0; //swaps to balance s

        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == ']') {
                cb++;
                //if cb > ob -> unbalanced string s
                fault = cb - ob;
            } else {
                //when an opening bracket is found
                //use it to balance the previous closing bracket by swaps
                //swapping will start from the current opening bracket and till the last unbalanced closing bracket
                ob++;
                if(fault > 0) {
                    //means we have unbalanced s -> cb > ob
                    swaps += fault;
                    fault--; //one ob can balance only one cb
                }
            }
        }

        return swaps;
    }
}
