package random.sorting_algos;

import java.util.Arrays;

public class CountingSort {
    private static void sort(char[] arr) {
        //count occurrences of each num in arr
        int[] count = new int[256];
        for(int j : arr) {
            count[j]++;
        }
        //arr[i] will hold sum of all previous counts
        for(int i=1; i<256; i++) {
            count[i] += count[i-1];
        }
        //rotate count array clockwise one-time
        for(int i=255; i>0; i--) {
            count[i] = count[i-1];
        }
        count[0] = 0;
        //traverse through the input array from n-1 to maintain stability
        // and check position of each value in count array, and increase its value in count array by 1
        char[] res = new char[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            int index = count[arr[i]];
            count[arr[i]]++;
            res[index] = arr[i];
        }
        //change res to arr
        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    //can sort arrays even if it contains -ve values
    private static void countSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];
        for(int j : arr) {
            count[j - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        char[] arr = {'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's'};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {-5, -10, 0, -3, 8, 5, -1, 10};
        countSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
