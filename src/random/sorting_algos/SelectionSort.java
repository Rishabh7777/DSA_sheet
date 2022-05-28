package random.sorting_algos;

import java.util.Arrays;

public class SelectionSort {
    private static void sort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            //find the min element in unsorted array
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //swap elements at i and minIndex
            if(minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    } //O(n^2)

    private static void stableSort(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            //find the min element in unsorted array
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //put min element at right place and shift the array to the right by 1
            if(minIndex != i) {
                int key = arr[minIndex];
                while(minIndex > i) {
                    arr[minIndex] = arr[minIndex - 1];
                    minIndex--;
                }
                arr[i] = key; //put the min element at right place
            }
        }
    } //O(n^2)

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        stableSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
