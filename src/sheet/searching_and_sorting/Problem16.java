package sheet.searching_and_sorting;

public class Problem16 {
    public static long[] productExceptSelf(int[] nums, int n) {
        long[] res = new long[n];
        long product = 1; //total product of all nums element except 0
        int zeroCount = 0;
        for(int i: nums) {
            if(i == 0) {
                zeroCount++;
            } else {
                product *= i;
            }
        }
        if(zeroCount > 1) {
            return res;
        }
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                res[i] = product;
            } else if(zeroCount == 0) {
                res[i] = product / nums[i];
            }
        }
        return res;
    } //O(n)

    //prod[i] = (product of elements till i-1 from left) * (product of elements till i+1 from right)
    public static long[] productExceptSelf2(int[] arr, int n) {
        long[] prod = new long[n];
        if (n == 1) {
            prod[0] = 1;
            return prod;
        }
        long temp = 1;
        for (int i = 0; i < n; i++) {
            prod[i] = temp;
            temp *= arr[i];
        }
        temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= arr[i];
        }
        return prod;
    } //O(n)
}
