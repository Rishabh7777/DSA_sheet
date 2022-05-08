package sheet.searching_and_sorting;

import java.util.ArrayList;

public class Problem2 {
    private static ArrayList<Integer> valueEqualToIndex(int[] arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=1; i<=arr.length; i++) {
            if(arr[i-1] == i) {
                res.add(arr[i-1]);
            }
        }

        return res;
    }
}
