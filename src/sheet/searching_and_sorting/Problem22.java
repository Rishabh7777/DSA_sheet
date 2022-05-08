package sheet.searching_and_sorting;

public class Problem22 {
    private static void findPivot(int[] arr) {
        int low = 0, high = arr.length-1;
        //base case
        //if arr is not rotated even once
        if(arr[low] <= arr[high]) {
            System.out.println("Pivot: " + arr[high]);
            System.out.println("Rotated: " + 0 + " times");
            return;
        }
        //use binary search
        while(low < high) {
            int mid = (low + high) / 2;
            //if found the point of rotation
            if(arr[mid] > arr[mid+1]) {
                System.out.println("Pivot: " + arr[mid]);
                System.out.println("Rotated: " + (mid+1) + " times");
                break;
            } else if(arr[low] <= arr[mid]) {
                //left part is sorted and pivot is not arr[mid]
                low = mid + 1;
            } else {
                high = mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        findPivot(arr);
        System.out.println("*************************");

        arr = new int[]{3, 4, 5, 6, 1, 2};
        findPivot(arr);
        System.out.println("*************************");

        arr = new int[]{10, 1, 3, 7, 9};
        findPivot(arr);
        System.out.println("*************************");

        arr = new int[]{1, 2, 3, 4, 5};
        findPivot(arr);
        System.out.println("*************************");
    }
}
