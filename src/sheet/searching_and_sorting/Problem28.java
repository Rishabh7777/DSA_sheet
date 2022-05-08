package sheet.searching_and_sorting;

public class Problem28 {
    private static int inSequence(int A, int B, int C){
        if(A == B) {
            return 1;
        }
        double n = 0;
        try {
            n = (double)(B - A) / C;
        } catch(Exception e) {
            return 0;
        }
        if(n < 0.0) {
            return 0;
        }
        return (n % 1.0 == 0.0) ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(inSequence(1, 3, 2));
        System.out.println(inSequence(1, 2, 3));
        System.out.println(inSequence(4, -12, 4));
        System.out.println(inSequence(4, -12, -4));
        System.out.println(inSequence(10, 10, 0));
        System.out.println(inSequence(10, 0, 10));
    }
}
