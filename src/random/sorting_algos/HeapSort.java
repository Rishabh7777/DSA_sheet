package random.sorting_algos;

import java.util.Arrays;

public class HeapSort {
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        //get indexes of left and right children
        int left = 2*i + 1, right = 2*i + 2;
        //change the largest if children are greater
        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        //check if largest and parent are same, if not swap them
        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            //recursively call heapify() for the largest
            heapify(arr, n, largest);
        }
    } //O(logn)
    
    private static void sort(int[] arr) {
        int n = arr.length;
        //build max heap with arr
        for(int i=n/2 - 1; i>=0; i--) {
            heapify(arr, n, i);
        }
        //get root element and put it at last index, repeat the process for whole array
        for(int i=n-1; i>0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //call heapify() to rearrange elements so that its max heap again
            //and decrease the size of array each time
            heapify(arr, i, 0);
        }
    } //O(nlogn)

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
