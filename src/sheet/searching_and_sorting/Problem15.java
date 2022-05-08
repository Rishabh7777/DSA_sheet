package sheet.searching_and_sorting;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem15 {
    public static long findSubarray(long[] arr ,int n) {
        //sum(say 2) -> [2, 6]
        //sum is 2 from index 0 to 2 and from 0 to 6 in arr
        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        long sum = 0;
        long res = 0;

        for(int i=0; i<n; i++) {
            sum += arr[i];
            if(sum == 0) {
                res++;
            }
            ArrayList<Integer> list = new ArrayList<>();
            if(map.containsKey(sum)) {
                list = map.get(sum);
                res += list.size();
                map.put(sum, list);
            }
            list.add(i);
            map.put(sum, list);
        }

        return res;
    } //O(n)
}
