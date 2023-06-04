package sheet.backtracking;

public class LargestNumInKSwaps {
    private static String maxStr;

    private static void helper(char[] arr, int k) {
        if(String.valueOf(arr).compareTo(maxStr) > 0) {
            maxStr = String.valueOf(arr);
        }

        // base case
        if(k == 0) {
            return;
        }

        for(int i=0; i<arr.length-1; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] > arr[i]) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    helper(arr, k-1);
                    // backtrack swapped values
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static String findMaximumNum(String str, int k) {
        maxStr = "-1";
        helper(str.toCharArray(), k);
        return maxStr;
    }

    public static void main(String[] args) {
        System.out.println(findMaximumNum("1234567", 4));
        System.out.println(findMaximumNum("3435335", 3));
        System.out.println(findMaximumNum("1034", 2));
        System.out.println(findMaximumNum("4551711527", 3));
    }
}
