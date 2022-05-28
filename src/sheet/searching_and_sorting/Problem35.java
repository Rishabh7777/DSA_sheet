package sheet.searching_and_sorting;

import java.util.Arrays;

public class Problem35 {
    private static void mergeInPlace(int[] arr, int low, int mid, int high) {
        int max = Math.max(arr[mid], arr[high]) + 1; //add 1 to avoid facing 0%max
        int i=low, j=mid+1, k=low;
        //replace arr[k] with (element * max)
        //to get new element do /, and to get previous element do %
        while(i <= mid && j <= high && k <= high) {
            int e1 = arr[i] % max;
            int e2 = arr[j] % max;
            if(e1 <= e2) {
                arr[k] += (e1 * max);
                i++;
                k++;
            } else {
                arr[k] += (e2 * max);
                j++;
                k++;
            }
        }

        //process remaining elements
        while(i <= mid) {
            int e1 = arr[i] % max;
            arr[k] += (e1 * max);
            i++;
            k++;
        }
        while(j <= high) {
            int e2 = arr[j] % max;
            arr[k] += (e2 * max);
            j++;
            k++;
        }

        //update elements by dividing them with max
        for(i=low; i<=high; i++) {
            arr[i] /= max;
        }
    }

    private static void mergerSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) / 2;
            mergerSort(arr, low, mid);
            mergerSort(arr, mid+1, high);
            //merge the left and right arrays in-place
            mergeInPlace(arr, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergerSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
