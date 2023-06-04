package sheet.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class CombinationSum {
    private static void helper(ArrayList<Integer> A, int B, int curr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list) {
        // base cases
        if(B == 0) {
            if(!res.contains(list)) {
                res.add(new ArrayList<>(list));
            }
            return;
        } else if(curr == A.size()) {
            return;
        }

        // include curr value if possible
        if(A.get(curr) <= B) {
            list.add(A.get(curr));
            helper(A, B - A.get(curr), curr, res, list);
            list.remove(list.size() - 1); // backtracking
        }

        // exclude curr value
        helper(A, B, curr + 1, res, list);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(A);
        // remove duplicate values from A
        for(int i=0; i<A.size() - 1; i++) {
            if(Objects.equals(A.get(i), A.get(i + 1))) {
                A.remove(i + 1);
            }
        }
        helper(A, B, 0, res, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(7, 2, 6, 5));
        int B = 16;
        System.out.println(combinationSum(A, B));

        A = new ArrayList<>(Arrays.asList(6, 5, 7, 1, 8, 2, 9, 9, 7, 7, 9));
        B = 6;
        System.out.println(combinationSum(A, B));
    }
}
