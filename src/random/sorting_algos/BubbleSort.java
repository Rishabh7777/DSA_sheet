package random.sorting_algos;

import java.util.Arrays;

public class BubbleSort {
    private static void sort(int[] arr) {
        //total passes needed = arr.length - 1
        //in one pass, the greatest element (for ascending order) will take the last place in the array
        for(int i=0; i<arr.length-1; i++) {
            boolean swapped = false;
            for(int j=0; j<arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
