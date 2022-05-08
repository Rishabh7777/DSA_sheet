package sheet.searching_and_sorting;

public class Problem29 {
    int findTrailingZeroes(int num) {
        int count = 0;
        while(num >= 5) {
            count += (num / 5);
            num /= 5;
        }
        return count;
    }

    int findNum(int n) {
        int low = 1, high = 5*n;
        while(low < high) {
            int mid = low + (high - low)/2;
            int count = findTrailingZeroes(mid);
            if(count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
