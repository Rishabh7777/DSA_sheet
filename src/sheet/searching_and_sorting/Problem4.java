package sheet.searching_and_sorting;

public class Problem4 {
    private static int countSquares(int n) {
        double num = Math.sqrt(n);
        int ceilValue = (int)num;

        if(num > ceilValue) {
            return ceilValue;
        }
        return ceilValue - 1;
    }

    public static void main(String[] args) {
        System.out.println(countSquares(9));
        System.out.println(countSquares(3));
    }
}
