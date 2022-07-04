package sheet.binary_tree;

import java.util.*;

public class problem21 {
    private static int[] inOrder;
    private static int iter;

    //get an in-order traversal of BT from level-order
    private static void getInOrder(int[] arr, int idx) {
        if(idx >= arr.length) {
            return;
        }
        getInOrder(arr, (2 * idx) + 1);
        inOrder[iter++] = arr[idx];
        getInOrder(arr, (2 * idx) + 2);
    }

    private static int getMinSwaps() {
        //create a map from arr and index of each element
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        int swaps = 0;
        for(int i=0; i<inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        //as in-order of BST is always sorted, so sort arr to get natural position of each element
        int[] sorted = new int[inOrder.length];
        System.arraycopy(inOrder, 0, sorted, 0, inOrder.length);
        Arrays.sort(sorted);
        //visit each element in arr and if not found as per sorted[], then swap it with correct element
        for(int i=0; i<inOrder.length; i++) {
            if(inOrder[i] != sorted[i]) {
                int j = inOrderMap.get(sorted[i]);
                //swap elements at i and j
                int temp = inOrder[i];
                inOrder[i] = inOrder[j];
                inOrder[j] = temp;
                //update the inOrderMap as per the updated arr
                inOrderMap.put(inOrder[i], i);
                inOrderMap.put(inOrder[j], j);
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        inOrder = new int[arr.length];
        iter = 0;
        getInOrder(arr, 0);
        System.out.println(getMinSwaps());
    }
}
