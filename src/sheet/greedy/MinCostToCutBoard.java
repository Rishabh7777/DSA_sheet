package sheet.greedy;

import java.util.Arrays;

public class MinCostToCutBoard {
    public static int minimumCostOfBreaking(int[] X, int[] Y, int M, int N) {
        Arrays.sort(X);
        Arrays.sort(Y);
        int i = X.length-1, j = Y.length-1;
        int rowParts = 1, colParts = 1, totalCost = 0;
        while(i >= 0 && j >= 0) {
            if(X[i] >= Y[j]) {
                totalCost += (X[i] * colParts);
                i--;
                rowParts++;
            } else {
                totalCost += (Y[j] * rowParts);
                j--;
                colParts++;
            }
        }
        //finish X[] or Y[] if left
        while(i >= 0) {
            totalCost += (X[i--] * colParts);
        }
        while(j >= 0) {
            totalCost += (Y[j--] * rowParts);
        }
        return totalCost;
    } //O(n * log(n)) + O(m * log(m))

    public static void main(String[] args) {
        int M = 6, N = 4;
        int[] X = {2,1,3,1,4}; // cuts column wise
        int[] Y = {4,1,2}; // cuts row wise
        System.out.println(minimumCostOfBreaking(X, Y, M, N));
    }
}
