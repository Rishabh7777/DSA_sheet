package sheet.searching_and_sorting;

public class Problem3 {
    private static int sol(int[] arr, int low, int high, int target) {
        if(low > high) {
            return -1; //target is not found in arr
        }

        int mid = (low + high) / 2;
        if(target == arr[mid]) {
            return mid;
        }

        if(arr[low] <= arr[mid]) {
            //arr is sorted from low to mid
            if(target >= arr[low] && target <= arr[mid]) {
                //target is in the range from index low to high
                return sol(arr, low, mid-1, target);
            }
            //target can be found from mid+1 to high index
            return sol(arr, mid+1, high, target);
        } else {
            //arr is sorted from mid+1 to high
            if(target >= arr[mid] && target <= arr[high]) {
                return sol(arr, mid+1, high, target);
            } else {
                return sol(arr, low, mid-1, target);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(sol(arr, 0, arr.length-1, 0));

        System.out.println(sol(arr, 0, arr.length-1, 3));

        arr = new int[]{1};
        System.out.println(sol(arr, 0, arr.length-1, 0));

        arr = new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(sol(arr, 0, arr.length-1, 6));

        arr = new int[]{1, 3, 5};
        System.out.println(sol(arr, 0, arr.length-1, 5));

        arr = new int[]{5, 1, 3};
        System.out.println(sol(arr, 0, arr.length-1, 5));

        arr = new int[]{3, 1};
        System.out.println(sol(arr, 0, arr.length-1, 0));
    }
}
