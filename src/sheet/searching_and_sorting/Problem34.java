package sheet.searching_and_sorting;

public class Problem34 {
    static long merge(long[] arr, int low, int mid, int high) {
        long count = 0;
        int size1 = mid - low + 1;
        int size2 = high - mid;
        long[] arrLeft = new long[size1];
        long[] arrRight = new long[size2];
        int index = low;
        for(int i = 0; i < size1; i++) {
            arrLeft[i] = arr[index];
            index++;
        }
        index = mid + 1;
        for(int i = 0; i < size2; i++) {
            arrRight[i] = arr[index];
            index++;
        }
        int i = 0;
        int j = 0;
        index = low;
        while(i < size1 && j < size2) {
            if(arrLeft[i] <= arrRight[j]) {
                arr[index] = arrLeft[i];
                i++;
            } else {
                count += arrLeft.length - i;
                arr[index] = arrRight[j];
                j++;
            }
            index++;
        }

        if(i < size1) {
            for(int k = i; k < size1; k++) {
                arr[index] = arrLeft[k];
                index++;
            }
        } else {
            for(int k = j; k < size2; k++) {
                arr[index] = arrRight[k];
                index++;
            }
        }

        return count;
    }

    static long mergeSort(long[] arr, int low, int high) {
        if(low < high) {
            long count = 0;
            int mid = (low + high) / 2;
            count += mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += merge(arr, low, mid, high);
            return count;
        }
        return 0;
    }

    static long inversionCount(long[] arr, long N) {
        return mergeSort(arr, 0, arr.length - 1);
    }
}
