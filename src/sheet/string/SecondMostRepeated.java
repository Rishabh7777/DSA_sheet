package sheet.string;

import java.util.HashMap;
import java.util.Map;

public class SecondMostRepeated {
    private static String sol(String[] str) {
        Map<String, Integer> map = new HashMap<>();

        //put count of each string into map
        for(String s: str) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        //get the max number of times a string appeared in str
        int max = 0;
        for(Map.Entry element: map.entrySet()) {
            if((int)element.getValue() > max) {
                max = (int)element.getValue();
            }
        }

        int secondMax = 0;
        String res = "";
        for(Map.Entry element: map.entrySet()) {
            int value = (int)element.getValue();
            if(value < max && value > secondMax) {
                secondMax = value;
                res = (String)element.getKey();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] str = {"geek"};
        System.out.println(sol(str));
    }
}
