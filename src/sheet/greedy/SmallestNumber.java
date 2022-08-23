package sheet.greedy;

public class SmallestNumber {
    public static String smallestNumber(int S, int D){
        StringBuilder sb = new StringBuilder();
        while(D > 0) {
            if(S > 9) {
                sb.insert(0, 9);
                S -= 9;
            } else if(D == 1) {
                sb.insert(0, S);
                S = 0;
            } else if(S == 1) {
                sb.insert(0, 0);
            } else {
                sb.insert(0, S-1);
                S = 1;
            }
            D--;
        }
        return (S > 0) ? "-1" : sb.toString();
    }

    public static void main(String[] args) {
        int S = 15, D = 4;
        System.out.println(smallestNumber(S, D));
    }
}
