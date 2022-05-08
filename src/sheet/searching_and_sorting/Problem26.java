package sheet.searching_and_sorting;

import java.util.Arrays;

public class Problem26 {
    private static boolean isWoodSufficient(int[] heights, int h, int M) {
        int total = 0;
        for(int i: heights) {
            total += Math.max(0, (i - h));
        }
        return total >= M;
    }

    private static int sol(int[] heights, int N, int M) {
        int low = 0;
        int high = Arrays.stream(heights).max().getAsInt();

        while(low < high) {
            int mid = low + (high - low)/2;
            if(isWoodSufficient(heights, mid, M)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return (low - 1);
    }

    public static void main(String[] args) {
        int N = 4, M = 7;
        int[] heights = {20, 15, 10, 17};
        System.out.println(sol(heights, N, M));

        N = 5;
        M = 20;
        heights = new int[]{4, 42, 40, 26, 46};
        System.out.println(sol(heights, N, M));
    }
}
