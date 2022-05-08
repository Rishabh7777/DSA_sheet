package random.extra;

import java.util.Arrays;

public class FenwickTree {
    private static int sumQuery(int[] fen, int i) {
        int sum = 0;

        while(i > 0) {
            sum += fen[i];
            int l = intervalLength(i);
            i = i - l;
        }

        return sum;
    }

    //index = 1, val = arr[1]
    private static void update(int[] fen, int index, int val) {
        while(index < fen.length) {
            fen[index] += val;
            int l = intervalLength(index);
            index = index + l;
        }
    }
    private static int intervalLength(int pos) {
        return pos & -pos;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
        int[] fen = new int[12];

        for(int i = 1; i < arr.length; i++) {
            update(fen, i, arr[i]);
        }

        System.out.println(sumQuery(fen, 7));
        //range sum
        int l = 4, r = 7;

        int s17 = sumQuery(fen, r);
        int s13 = sumQuery(fen, l - 1);
        System.out.println(s17 - s13);
        System.out.println(Arrays.toString(fen));
		update(fen, 2, 3);
		System.out.println(Arrays.toString(fen));
    }
}
