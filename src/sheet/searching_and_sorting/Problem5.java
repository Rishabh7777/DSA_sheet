package sheet.searching_and_sorting;

public class Problem5 {
    private static int middle(int A, int B, int C){
        int max = Math.max(A, Math.max(B, C));
        if(max == A) {
            return Math.max(B, C);
        }
        if(max == B) {
            return Math.max(A, C);
        }
        return Math.max(A, B);
    }

    public static void main(String[] args) {
        System.out.println(middle(978, 518, 300));
        System.out.println(middle(162, 934, 200));
    }
}
