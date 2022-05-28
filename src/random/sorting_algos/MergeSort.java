package random.sorting_algos;

import java.util.Arrays;

public class MergeSort {
    private static void merge(int[] arr, int left, int mid, int right) {
        //get left and right arrays to merge
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];
        System.arraycopy(arr, left, leftArray, 0, mid-left+1);
        System.arraycopy(arr, mid+1, rightArray, 0, right-mid);

        //compare elements in both arrays, put the lesser one in arr first
        int i = 0, j = 0, k = left;
        while(i < leftArray.length && j < rightArray.length && k <= right) {
            if(leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //process the remaining elements
        while(i < leftArray.length) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while(j < rightArray.length) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right - left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 10, 12, 1, 5, 6};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}