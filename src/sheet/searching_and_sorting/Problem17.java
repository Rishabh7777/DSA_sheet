package sheet.searching_and_sorting;

import java.util.Arrays;

public class Problem17 {
    static void sortBySetBitCount(Integer[] arr, int n) {
        Arrays.sort(arr, (a, b) -> Integer.compare(Integer.bitCount(b), Integer.bitCount(a)));
    }
}
