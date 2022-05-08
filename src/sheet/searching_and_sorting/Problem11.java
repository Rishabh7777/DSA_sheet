package sheet.searching_and_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Problem11 {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        Arrays.sort(arr);

        for(int i=0; i<arr.length-3; i++) {
            for(int j=i+1; j<arr.length-2; j++) {
                int left = j + 1;
                int right = arr.length - 1;

                while(left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if(sum == k) {
                        ArrayList<Integer> subList = new ArrayList<>(
                                Arrays.asList(arr[i], arr[j], arr[left], arr[right])
                        );
                        if(!set.contains(subList)) {
                            res.add(subList);
                            set.add(subList);
                        }
                    }
                    if(sum < k) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
