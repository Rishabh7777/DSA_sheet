package sheet.searching_and_sorting;

public class Problem9 {
    private static int search(int[] arr, int key, int x) {
        int i=0;
        while(i < arr.length) {
            if(key == arr[i]) {
                return i;
            }
            i += Math.max(1, Math.abs(arr[i] - key)/x);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 6};
        System.out.println(search(arr, 6, 1));

        arr = new int[]{20, 40, 50, 70, 70, 60};
        System.out.println(search(arr, 60, 20));
    }
}
