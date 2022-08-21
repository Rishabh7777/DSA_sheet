package sheet.greedy;

import java.util.Arrays;

public class MaxAbsoluteDiff {
    public static int sol(int[] arr, int n) {
        Arrays.sort(arr);
        int i=0, j=n-1, sum=0;
        boolean moveLeft = true;
        while(i < j) {
            sum += Math.abs(arr[i] - arr[j]);
            if(moveLeft) {
                i++;
            } else {
                j--;
            }
            moveLeft = !moveLeft;
        }
        sum += Math.abs(arr[0] - arr[n/2]);
        return sum;
    } //O(n * log(n))

    public static void main(String[] args) {
        int[] arr = {1,2,4,8};
        System.out.println(sol(arr, arr.length));
    }
}
