package random.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AggressiveCows {
    private static boolean canPlaced(int[] stalls, int numCows, int minDist) {
        int posPlaced = stalls[0]; //1
        int numPlaced = 1;

        for(int curr = 1; curr < stalls.length; curr++) {
            if(numPlaced == numCows) {
                return true;
            }
            if(stalls[curr] - posPlaced >= minDist) {
                numPlaced++;
                posPlaced = stalls[curr];
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0) {
            String input = br.readLine();
            String[] strArr = input.split("\\s+");
            int N = Integer.parseInt(strArr[0]);
            int C = Integer.parseInt(strArr[1]);
            int[] stalls = new int[N];
            for (int i = 0; i < N; i++) {
                stalls[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(stalls);

            int r = stalls[N-1] - stalls[0];
            int l = 0;
            while(r > l + 1) {
                int minDist = (l + r) / 2;//mid
                if(canPlaced(stalls, C, minDist)) {
                    l = minDist;
                } else {
                    r = minDist;
                }
            }
            System.out.println(l);

            t--;
        }
    }
}
