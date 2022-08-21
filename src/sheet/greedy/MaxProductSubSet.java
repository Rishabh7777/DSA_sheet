package sheet.greedy;

public class MaxProductSubSet {
    public static int findMaxProduct(int n, int[] arr) {
        int mod = 1000000007;
        if(n == 1) {
            return arr[0];
        }
        long max = 1;
        int maxNegative = Integer.MIN_VALUE;
        int countNeg = 0;
        int countZero = 0;
        for(int i=0; i<n; i++){
            if(arr[i] == 0) {
                countZero++;
                continue;
            } else if(arr[i] < 0) {
                maxNegative = Math.max(maxNegative, arr[i]);
                countNeg++;
            }
            max = (max * arr[i]) % mod;
        }
        if(countZero == n) {
            return 0;
        }
        if(countNeg == 1 && countZero + countNeg == n) {
            return 0;
        }
        if(countNeg % 2 == 1) {
            max /= maxNegative;
        }
        return (int)max;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0};
        System.out.println(findMaxProduct(arr.length, arr));
    }
}
