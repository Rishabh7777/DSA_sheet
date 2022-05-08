package sheet.searching_and_sorting;

import java.util.ArrayList;

public class Problem1 {
    private static ArrayList<Long> find(long[] arr, int n, int x) {
        ArrayList<Long> res = new ArrayList<>();
        long low = 0, high = n;
        boolean flag = false;

        //find first occurrence
        while(low < high) {
            long mid = (low + high) / 2;
            if(x > arr[(int)mid]) {
                low = mid + 1;
            } else if(x < arr[(int)mid]) {
                high = mid;
            } else {
                high = mid;
                flag = true;
            }
        }
        if(flag) {
            res.add(low);
        } else {
            res.add(-1L);
        }

        low = 0;
        high = n;

        //find last occurrence
        if(flag) {
            while (low < high) {
                long mid = (low + high) / 2;
                if (x > arr[(int) mid]) {
                    low = mid + 1;
                } else if (x < arr[(int) mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            res.add(low - 1);
        } else {
            res.add(-1L);
        }

        return res;
    } //O(logn)

    public static void main(String[] args) {
        long[] arr = {1, 3, 5, 5, 5, 5, 7, 123, 125};
        System.out.println(find(arr, 9, 5));
        System.out.println(find(arr, 9, 7));
        System.out.println(find(arr, 9, 9));
    }
}
