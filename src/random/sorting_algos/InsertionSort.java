package random.sorting_algos;

import java.util.Arrays;

public class InsertionSort {
    private static void sort(int[] arr) {
        //pick one element from arr[1] to arr[n-1]
        //find its correct position in sorted array previous to it
        //shift the array forward by 1 and place picked element at right place
        for(int i=1; i<arr.length; i++) {
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 10, 12, 1, 5, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
