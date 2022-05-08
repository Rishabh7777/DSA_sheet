package sheet.searching_and_sorting;

import java.util.HashMap;
import java.util.Map;

public class Problem8 {
    private static int majorityElement(int[] a, int size) {
        Map<Integer, Integer> count = new HashMap<>();
        int req = size / 2;
        for(int i : a) {
            count.put(i, count.getOrDefault(i, 0) + 1);
            if (count.get(i) > req) {
                return i;
            }
        }
        return -1;
    }
}
