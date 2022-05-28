package sheet.searching_and_sorting;

import java.util.Arrays;

//improving quick sort using three pointer approach, it reduces possibility of worst case in it
//three-way partitioning
public class Problem36 {
    private static void swap(int[] arr, int point1, int point2) {
        //swap values at point1 and point2
        if(point1 != point2) {
            int temp = arr[point1];
            arr[point1] = arr[point2];
            arr[point2] = temp;
        }
    }

    //function to find left and right partitioning points in array, will return lt and gt pointers
    //lt -> less than, gt -> greater than
    private static int[] partition(int[] arr, int left, int right) {
        int key = arr[left]; //using first value in arr as the partitioning value
        int lt = left, current = left, gt = right;
        //compare each value in arr with key using current pointer
        //and swap them with respective lt or gt pointers if needed
        while(current <= gt) {
            if(arr[current] < key) {
                swap(arr, current, lt);
                lt++;
                current++;
            } else if(arr[current] > key) {
                swap(arr, current, gt);
                gt--;
            } else {
                current++;
            }
        }
        return new int[]{lt, gt};
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int[] partition = partition(arr, left, right);
            quickSort(arr, left, partition[0] - 1);
            quickSort(arr, partition[0] + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 10, 13, 4, 13, 4, 4, 7, 8, 25, 25, 3, 5, 11, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{10, 80, 30, 90, 40, 50, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
