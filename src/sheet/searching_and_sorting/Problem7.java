package sheet.searching_and_sorting;

public class Problem7 {
    private static int[] findTwoElement(int[] arr, int n) {
        int[] res = new int[2];

        int[] count = new int[arr.length + 1]; //store count of each number appeared in arr
        for(int i : arr) {
            count[i]++;
            if (count[i] > 1) {
                res[0] = i;
            }
        }

        for(int i=1; i<count.length; i++) {
            if(count[i] == 0) {
                res[1] = i;
            }
        }

        return res;
    }
}
