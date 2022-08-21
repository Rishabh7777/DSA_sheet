package sheet.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxStocks {
    private static class Stock {
        int stockPrice, canBuy;
        Stock(int stockPrice, int canBuy) {
            this.stockPrice = stockPrice;
            this.canBuy = canBuy;
        }
        public String toString() {
            return "(" + this.stockPrice + "," + this.canBuy + ")";
        }
    }

    private static class SortByPrice implements Comparator<Stock> {
        @Override
        public int compare(Stock o1, Stock o2) {
            return o1.stockPrice - o2.stockPrice;
        }
    }

    public static int buyMaximumProducts(int n, int k, int[] price) {
        Stock[] arr = new Stock[n];
        //store prices and max stocks that can be bought on particular day as pair
        for(int i=0; i<n; i++) {
            arr[i] = new Stock(price[i], i+1);
        }
        //to get max stocks, pick stocks with fewer prices first
        Arrays.sort(arr, new SortByPrice());
        int count = 0;
        for(int i=0; i<n; i++) {
            Stock curr = arr[i];
            int x = Math.min(curr.canBuy, (k / curr.stockPrice)); //max stocks for particular day
            count += x;
            k -= (x * curr.stockPrice);
        }
        return count;
    } //O(n * log(n))

    public static void main(String[] args) {
        int n = 3, k = 45;
        int[] price = {10,7,19};
        int res = buyMaximumProducts(n, k, price);
        System.out.println(res);
    }
}
