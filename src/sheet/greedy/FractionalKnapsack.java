package sheet.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    private static class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    private static class SortByRatio implements Comparator<Item> {
        @Override
        public int compare(Item o1, Item o2) {
            double ratio1 = (double)o1.value / o1.weight;
            double ratio2 = (double)o2.value / o2.weight;
            if(ratio2 > ratio1) {
                return 1;
            } else if(ratio1 > ratio2) {
                return -1;
            }
            return 0;
        }
    }

    public static double fractionalKnapsack(int W, Item[] arr, int n) {
        //sort arr based on ratio in decreasing order
        Arrays.sort(arr, new SortByRatio());
        double profit = 0;
        for(int i=0; i<n; i++) {
            if(W - arr[i].weight >= 0) {
                //complete value can be picked
                W -= arr[i].weight;
                profit += arr[i].value;
            } else if(W > 0) {
                //partial item can be picked
                profit += (W * ((double)arr[i].value / arr[i].weight));
                break; //no more item can be added
            }
        }
        return profit;
    } // O(n * log(n))

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int w = scan.nextInt();
        Item[] arr = new Item[n];
        for(int i=0; i<n; i++) {
            int val = scan.nextInt();
            int weight = scan.nextInt();
            arr[i] = new Item(val, weight);
        }
        double res = fractionalKnapsack(w, arr, n);
        System.out.println(res);
    }
}
