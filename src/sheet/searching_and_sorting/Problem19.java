package sheet.searching_and_sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem19 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] inputArray = input.split(" ");
        int[] soldierPowers = new int[n];
        for(int i=0; i<n; i++) {
            soldierPowers[i] = Integer.parseInt(inputArray[i]);
        }
        int rounds = Integer.parseInt(br.readLine());
        int[] powerInRounds = new int[rounds];
        for(int i=0; i<rounds; i++) {
            powerInRounds[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        Arrays.sort(soldierPowers); //O(nlogn)

        //use binary search on soldierPowers
        int[][] res = new int[rounds][2];
        for(int key: powerInRounds) {
            //base case
            if(key < soldierPowers[0]) {
                System.out.print(0 + " ");
                System.out.println(0);
                continue;
            }
            if(key > soldierPowers[n-1]) {
                System.out.print(n + " ");
                System.out.println(Arrays.stream(soldierPowers).sum());
                continue;
            }
            int low = 0, high = soldierPowers.length-1;
            while(low < high) {
                int mid = (low + high) / 2;
                if(key >= soldierPowers[mid]) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            }
            int totalPower = 0;
            for(int i=0; i<low; i++) {
                totalPower += soldierPowers[i];
            }
            System.out.print(low + " ");
            System.out.println(totalPower);
        }
    }
}
