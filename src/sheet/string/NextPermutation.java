package sheet.string;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NextPermutation {
    private static List<Integer> sol(int n, int[] arr) {
        int k = -1, l = -1;
        //find the largest index for which arr[k] < arr[k+1]
        for(int i=0; i<n-1; i++) {
            if(arr[i] < arr[i+1]) {
                k = i;
            }
        }

        //find the largest index for which arr[k] < arr[l]
        if(k != -1) {
            //find the largest index for which arr[k] < arr[l]
            for(int i=k+1; i<n; i++) {
                if(arr[k] < arr[i]) {
                    l = i;
                }
            }
        }

        //if both pointing to -1, then arr is sorted in descending order
        //need to reverse the whole array
        if(k == -1) {
            k = 0;
        } else {
            int temp = arr[k];
            arr[k] = arr[l];
            arr[l] = temp;
            k++;
        }
        l = n - 1;

        //reverse the arr from k to l index
        while(k < l) {
            int temp = arr[k];
            arr[k] = arr[l];
            arr[l] = temp;
            k++;
            l--;
        }

        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        List<Integer> list = sol(arr.length, arr);
        for(int i: list) {
            System.out.print(i + " ");
        }
    }
}
