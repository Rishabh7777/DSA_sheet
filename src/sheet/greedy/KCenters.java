package sheet.greedy;

import java.util.Arrays;

// popular np-hard problem, has a greedy solution (approximate algo) with polynomial time complexity
// but choosing first center is a non-deterministic step (below taking 0 as first selected city)
// will give wrong answer for k = 2 if 0 city should not be selected
// Plus it approximates that distance between two points is always lesser than distance between them via a third point
// The correct solution has exponential time complexity (taking all pairs of cities)
public class KCenters {
    public static int findMaxDist(int n, int[][] arr, int k) {
        // make a dist[] to record minimum distance of a city at i from any selected center
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // take 0 as the first selected city
        int city = 0;
        // k is the number of cities that can be selected
        for(int i=0; i<k; i++) {
            // print the selected city
            System.out.println("City " + city + " is selected");

            // update the distances of all cities from the selected city
            for(int j=0; j<n; j++) {
                dist[j] = Math.min(dist[j], arr[city][j]);
            }

            // select the next center i.e. city
            // in order to minimize the maximum distance from selected center to any city,
            // pick maximum value from dist[] as assign its index to city
            int max = 0;
            for(int j=0; j<n; j++) {
                if(dist[max] < dist[j]) {
                    max = j;
                }
            }
            city = max;
        }

        // after selecting k-centers, city hold index of max value in dist[]
        return dist[city];
    } // O(n * k)

    public static void main(String[] args) {
        int n = 4, k = 2;
        int[][] arr = {{ 0, 4, 8, 5 }, { 4, 0, 10, 7 }, { 8, 10, 0, 9 }, { 5, 7, 9, 0 }};

        System.out.println("Max distance: " + findMaxDist(n, arr, k));
    }
}
