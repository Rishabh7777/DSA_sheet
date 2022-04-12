package sheet.matrix;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n2 < n1) {
            return findMedianSortedArrays(nums2, nums1);
        }

        if(n1 == 0) {
            int idx = n2 / 2;
            if(n2 % 2 == 0) {
                return (nums2[idx] + nums2[idx - 1]) / 2.0;
            }
            return nums2[idx];
        }

        int low = 0, high = n1;
        while(low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = ((n1 + n2) / 2) - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            if(left1 <= right2 && left2 <= right1) {
                if((n1 + n2) % 2 == 0)
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                else
                    return Math.max(left1, left2);
            }
            if(left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}