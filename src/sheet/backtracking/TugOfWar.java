package sheet.backtracking;

import java.util.ArrayList;

public class TugOfWar {
    private static int minDiff;
    private static ArrayList<Integer> res;

    private static void helper(int n, int[] arr, int curr, int currSum, int totalSum, ArrayList<Integer> list) {
        // base cases
        if(list.size() == n/2) {
            int currDiff = Math.abs(currSum - (totalSum - currSum));
            if(currDiff < minDiff) {
                res = new ArrayList<>(list);
                minDiff = currDiff;
            }
            return;
        } else if(curr == n) {
            return;
        }

        // include current value in first list
        list.add(arr[curr]);
        helper(n, arr, curr+1, currSum+arr[curr], totalSum, list);
        // backtracking step, remove added element
        list.remove(list.size() - 1);

        // exclude current value
        helper(n, arr, curr+1, currSum, totalSum, list);
    }

    public static void sol(int n, int[] arr) {
        int totalSum = 0;
        for(int i: arr) {
            totalSum += i;
        }

        minDiff = Integer.MAX_VALUE;
        res = new ArrayList<>();

        helper(n, arr, 0, 0, totalSum, new ArrayList<>());

        System.out.println("Min diff possible: " + minDiff);

        System.out.print("First list: ");
        for(int i: res) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("Second list: ");
        for(int i=0; i<n; i++) {
            if(!res.contains(arr[i])) {
                System.out.print(arr[i] + " ");
                res.remove(Integer.valueOf(arr[i]));
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        sol(arr.length, arr);
    }
}
