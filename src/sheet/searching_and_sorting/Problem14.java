package sheet.searching_and_sorting;

import java.util.Arrays;

public class Problem14 {
    public void merge(int[] arr1, int[] arr2, int n, int m) {
        int i = 0, j = 0, k = n - 1;
        while (i <= k && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else {
                int temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }
        } //O(n + m)

        Arrays.sort(arr1); //O(n * log(n))
        Arrays.sort(arr2); //O(m * log(m))
    } //O(nlogn + mlogn)
}
