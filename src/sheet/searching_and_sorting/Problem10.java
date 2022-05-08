package sheet.searching_and_sorting;

import java.util.Arrays;
import java.util.HashMap;

public class Problem10 {
    private static boolean findPair(int[] arr, int size, int n) {
        if(size == 1) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<size; i++) {
            map.put(arr[i], i);
        }

        for(int i=0; i<size; i++) {
            int value = arr[i] + n;
            if(map.containsKey(value) && map.get(value) != i) {
                return true;
            }
        }
        return false;
    } //O(n)

    private static boolean binarySearch(int[] arr, int low, int key) {
        int high = arr.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(key == arr[mid]) {
                return true;
            } else if(key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    private static boolean findPair2(int[] arr, int size, int n) {
        if(size == 1) {
            return false;
        }

        Arrays.sort(arr);

        for(int i=0; i<size; i++) {
            int value = n + arr[i];
            if(binarySearch(arr, i+1, value)) {
                return true;
            }
        }
        return false;
    } //O(nlogn) but O(1) extra space
}
