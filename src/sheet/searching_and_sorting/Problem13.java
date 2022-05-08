package sheet.searching_and_sorting;

import java.util.Arrays;

public class Problem13 {
    private static long countTriplets(long[] arr, int n, int sum) {
        Arrays.sort(arr); //O(nlogn)

        long count = 0;
        for(int i=0; i<arr.length-2; i++) {
            int left = i+1;
            int right = arr.length-1;

            while(left < right) {
                long value = arr[i] + arr[left] + arr[right];
                if(value < sum) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
    } //O(n^2)
}
