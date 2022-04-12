package sheet.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    private static int romanToDecimal(String str) {
        int[] arr = new int[str.length()];
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i=0; i<str.length(); i++) {
            arr[i] = map.get(str.charAt(i));
        }

        int sum = 0;
        //if current value of roman number is greater than next
        //add it to the total sum
        //else subtract it from the sum
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] >= arr[i+1]) {
                sum += arr[i];
            } else {
                sum -= arr[i];
            }
        }
        sum += arr[arr.length-1];

        return sum;
    }

    public static void main(String[] args) {
        String str = "III";
        System.out.println(romanToDecimal(str));
    }
}
