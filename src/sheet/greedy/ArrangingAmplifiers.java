package sheet.greedy;

import java.util.Arrays;

public class ArrangingAmplifiers {
    public static void sol(int[] arr, int n) {
        Arrays.sort(arr);
        int i = 0;
        // print all the 1's first
        while(i < n && arr[i] == 1) {
            System.out.print(arr[i++] + " ");
        }
        if(i == n-2 && arr[i] == 2 && arr[i+1] == 3) {
            System.out.print(2 + " " + 3);
        } else {
            int j = n-1;
            while(j >= i) {
                System.out.print(arr[j--] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 4};
        sol(arr, arr.length);
        System.out.println();

        arr = new int[]{2, 3};
        sol(arr, arr.length);
    }
}
