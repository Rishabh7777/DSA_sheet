package sheet.stack_and_queue;

import java.util.*;

public class GameWithString {
    public static int minValue(String s, int k){
        // create a map to count each char in s
        Map<Character, Integer> map = new HashMap<>();

        // create a max heap which contain the max counting char at the front
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // traverse the string and populate maxHeap
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        } // O(n) time

        // build the initial maxHeap with data from map
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(entry.getValue());
        } // O(log(p)) time

        // decrease the value at front of maxHeap k times
        while(k > 0 && !maxHeap.isEmpty()) {
            int val = maxHeap.poll() - 1;
            if(val > 0) {
                maxHeap.add(val);
            }
            k--;
        } // O(k * log(p)) time
        // p - number of distinct alphabets

        // calculate the final value from maxHeap
        int res = 0;
        while(!maxHeap.isEmpty()) {
            res += (int) Math.pow(maxHeap.poll(), 2);
        }

        return res;
    } // O(n + (k * log(p)))
}
