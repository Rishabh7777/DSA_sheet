package sheet.greedy;

public class WineTrading {
    public static int sol(int[] arr, int n) {
        int totalWork = 0, netBottles = 0;
        for(int i=0; i<n; i++) {
            netBottles += arr[i];
            totalWork += Math.abs(netBottles);
        }
        return totalWork;
    }

    public static void main(String[] args) {
        int[] arr = {-1000, -1000, -1000, 1000, 1000, 1000};
        System.out.println(sol(arr, arr.length));
    }
}
