package sheet.searching_and_sorting;

public class Problem23 {
    public static long kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
        //make sure that arr1 has less size than arr2 to get O(min(logn, logm))
        if(n > m) {
            return kthElement(arr2, arr1, m, n, k);
        }

        //assigning with base cases
        int low = Math.max(0, k-m), high = Math.min(k, n);

        while(low <= high) {
            int cut1 = (low + high) >> 1; //number of elements form arr1
            int cut2 = k - cut1; // number of elements from arr2
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : arr2[cut2];

            if(l1 <= r2 && l2 <= r1) {
                //if division is successful
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return -1;
    } //O(min(logn, logm))

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {100, 112, 256, 349, 770};
        int m = 7;
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        System.out.println(kthElement(arr1, arr2, n, m, 2));
    }
}
