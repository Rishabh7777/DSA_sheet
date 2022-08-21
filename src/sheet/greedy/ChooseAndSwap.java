package sheet.greedy;

import java.util.Arrays;

public class ChooseAndSwap {
    public static String sol(String A) {
        //record first occurrence of each char in A into arr
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for(int i=0; i<A.length(); i++) {
            char c = A.charAt(i);
            if(arr[c - 97] == -1) {
                arr[c - 97] = i;
            }
        }
        //pick a char at index i from A (say c) and its index in arr say idx,
        //move from arr[idx-1...0] and check if at some point, arr[j] > i,
        //so char at i and arr[j] can be replaced to get smaller string
        char one = '-', two = '-';
        for(int i=0; i<A.length(); i++) {
            char c = A.charAt(i);
            int idx = c - 97;
            for(int j=idx-1; j>=0; j--) {
                if(arr[j] > i) {
                    one = c;
                    two = (char)(j + 97);
                }
            }
            if(one != '-') {
                break;
            }
        }
        //swap each occurrence of one and two
        for(int i=0; i<A.length(); i++) {
            if(A.charAt(i) == one) {
                A = A.substring(0, i) + two + A.substring(i+1);
            } else if(A.charAt(i) == two) {
                A = A.substring(0, i) + one + A.substring(i+1);
            }
        }
        return A;
    }

    public static void main(String[] args) {
        String str = "adcab";
        System.out.println(sol(str));
        str = "cacda";
        System.out.println(sol(str));
    }
}
