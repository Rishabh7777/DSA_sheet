package sheet.searching_and_sorting;

import java.util.Arrays;
import java.util.HashMap;

//sort the original array and map original index of each element through sorted array
//traverse the unsorted array, if an element is not found at right place
//swap it with the correct index got though map
public class Problem18 {
    private static int minSwaps(int[] nums) {
        int[] unsorted = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        int swaps = 0;
        int i = 0;
        while(i < unsorted.length) {
            if(map.get(unsorted[i]) == i) {
                i++;
            } else {
                int temp = unsorted[i];
                int index = map.get(unsorted[i]);
                unsorted[i] = unsorted[index];
                unsorted[index] = temp;
                swaps++;
            }
        }
        return swaps;
    }
}
