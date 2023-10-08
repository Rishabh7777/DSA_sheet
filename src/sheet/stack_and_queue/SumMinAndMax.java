package sheet.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

public class SumMinAndMax {
    public static int sumMaxAndMin(int[] arr, int n, int k) {
        Deque<Integer> dqMax = new LinkedList<>();
        Deque<Integer> dqMin = new LinkedList<>();

        // insert first k elements in dq and during each insert check if last element
        // in dq is greater than or equal to the inserting element
        if(n == 0) {
            return 0;
        }
        dqMax.add(arr[0]);
        for(int i=1; i<k; i++) {
            while(!dqMax.isEmpty() && dqMax.getLast() < arr[i]) {
                dqMax.removeLast();
            }
            dqMax.addLast(arr[i]);
        }

        // similarly create dqMin with minimum elements from first k
        dqMin.add(arr[0]);
        for(int i=1; i<k; i++) {
            while(!dqMin.isEmpty() && dqMin.getLast() > arr[i]) {
                dqMin.removeLast();
            }
            dqMin.addLast(arr[i]);
        }

        // for each window, first element of dqMax is the maximum and first element of dqMin is minimum
        // in that window and when window moves with the front of dq then remove it from dq
        int i = 0, j = k - 1, sum = 0;
        while(true) {
            sum += dqMax.getFirst() + dqMin.getFirst();
            if(dqMax.getFirst() == arr[i]) {
                dqMax.removeFirst();
            }
            if(dqMin.getFirst() == arr[i]) {
                dqMin.removeFirst();
            }
            i++;
            j++;
            if(j == n) {
                break;
            }
            // add the new element at j+1 to dq with same check process
            while(!dqMax.isEmpty() && dqMax.getLast() < arr[j]) {
                dqMax.removeLast();
            }
            dqMax.addLast(arr[j]);
            while(!dqMin.isEmpty() && dqMin.getLast() > arr[j]) {
                dqMin.removeLast();
            }
            dqMin.addLast(arr[j]);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, -1, 7, -3, -1, -2};
        int k = 3;
        System.out.println(sumMaxAndMin(arr, 7, k));
    }
}
