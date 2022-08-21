package sheet.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class CandyStore {
    public static ArrayList<Integer> sol(int[] candies, int N, int K) {
        Arrays.sort(candies);
        int min = 0, max = 0;
        //to find min cost, add cost from front of array and skip buying candies from back of array
        int i=0, j=N-1;
        while(i <= j) {
            min += candies[i++];
            j -= K;
        }
        i = N - 1;
        j = 0;
        //to find max cost, add cost from back of array and skip buying from front of array
        while(i >= j) {
            max += candies[i--];
            j += K;
        }
        return new ArrayList<>(Arrays.asList(min, max));
    } //O(n * log(n))

    public static void main(String[] args) {
        int n = 5, k = 4;
        int[] candies = {3,2,4,1,5};
        System.out.println(sol(candies, n, k));
    }
}
