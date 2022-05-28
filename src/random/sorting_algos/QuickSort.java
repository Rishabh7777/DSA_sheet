package random.sorting_algos;

import java.util.Arrays;

//using median of (low, mid, high) as pivot
public class QuickSort {
    private static int getMedian(int low, int mid, int high) {
        if(low < mid) {
            if(mid < high) {
                return mid;
            }
            return Math.max(low, high);
        } else {
            if(low < high) {
                return low;
            }
            return Math.max(mid, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int mid = low + (high - low)/2;
        //get median as pivot
        int pivot = getMedian(low, arr[mid], high);
        //after loop, i will point to the correct place of pivot element in sorted array
        int i = low-1;
        for(int j=low; j<=high; j++) {
            if(arr[j] < arr[pivot]) {
                //swap arr[j] and arr[i+1]
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //swap arr[i+1] and pivot
        int temp = arr[i+1];
        arr[i+1] = arr[pivot];
        arr[pivot] = temp;
        return (i+1);
    }

    private static void sort(int[] arr, int low, int high) {
        if(low < high) {
            //find and place pivot at its right place in sorted arr
            int pivot = partition(arr, low, high);
            //recursive calls for left and right sub-arrays
            sort(arr, low, pivot-1);
            sort(arr, pivot+1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
