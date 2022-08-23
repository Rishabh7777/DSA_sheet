package sheet.greedy;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    private static class CompareInteger implements Comparator<Long> {
        @Override
        public int compare(Long o1, Long o2) {
            if(Objects.equals(o1, o2)) {
                return 0;
            } else if(o1 > o2) {
                return 1;
            }
            return -1;
        }
    }

    public static long minCost(long[] arr, int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>(new CompareInteger());
        for(long i: arr) {
            pq.add(i);
        }
        long cost = 0;
        while(pq.size() > 1) {
            long val1 = pq.poll();
            long val2 = pq.poll();
            long res = val1 + val2;
            cost += res;
            pq.add(res);
        }
        return cost;
    } // O(n * log(n))

    public static void main(String[] args) {
        long[] arr = {4, 2, 7, 6, 9};
        System.out.println(minCost(arr, arr.length));
    }
}
