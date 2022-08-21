package sheet.greedy;

public class PickingUpChicks {
    public static int sol(int n, int k, int b, int t, int[] initial, int[] velocity) {
        int count = 0, notPossible = 0, swaps = 0;
        for(int i=n-1; i>=0; i--) {
            int distanceRemaining = b - initial[i];
            int distanceCanTravel = velocity[i] * t;
            if(distanceRemaining <= distanceCanTravel) {
                count++;
                if(notPossible > 0) {
                    swaps += notPossible;
                }
            } else {
                notPossible++;
            }
        }
        return count >= k ? swaps : -1;
    }

    public static void main(String[] args) {
        int n = 5, k = 3, b = 10, t = 5;
        int[] initial = {0, 2, 3, 5, 7};
        int[] velocity = {2, 1, 1, 1, 4};
        System.out.println(sol(n, k, b, t, initial, velocity));
    }
}
