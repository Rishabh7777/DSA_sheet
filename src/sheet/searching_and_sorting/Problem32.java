package sheet.searching_and_sorting;

public class Problem32 {
    //calculate the sum in both arrays between bridges, and add the max of that
    //works as greedy, adding local max between bridges builds up global max sum
    private static int sol(int[] arr1, int[] arr2) {
        int sum1 = 0, sum2 = 0, sum = 0;
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                sum1 += arr1[i];
                i++;
            } else if(arr2[j] < arr1[i]) {
                sum2 += arr2[j];
                j++;
            } else if(arr1[i] == arr2[j]) {
                sum += Math.max(sum1, sum2) + arr1[i];
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        while(i < arr1.length) {
            sum1 += arr1[i];
            i++;
        }
        while(j < arr2.length) {
            sum2 += arr2[j];
            j++;
        }
        sum += Math.max(sum1, sum2);
        return sum;
    }

    public static void main(String[] args) {
        int[] arr1 = {-5, 100, 1000, 1005};
        int[] arr2 = {-12, 1000, 1001};
        System.out.println(sol(arr1, arr2));
    }
}
