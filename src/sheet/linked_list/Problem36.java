package sheet.linked_list;

public class Problem36 {
    public static String firstNonRepeating(String A) {
        int[] arr = new int[26];
        for(int i=0; i<26; i++) {
            arr[i] = Integer.MAX_VALUE;
        }
        StringBuilder res = new StringBuilder();
        for(int i=0; i<A.length(); i++) {
            char c = A.charAt(i);
            if(arr[c - 'a'] == Integer.MAX_VALUE) {
                arr[c - 'a'] = i; //char has appeared once
            } else if(arr[c - 'a'] < A.length()) {
                arr[c - 'a'] = A.length(); //char has appeared more than once (repeated)
            }
            //get min index from arr
            int min = Integer.MAX_VALUE;
            for(int j=0; j<26; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                }
            }
            res.append(min == A.length() ? '#' : A.charAt(min));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "hsvmhv";
        System.out.println(firstNonRepeating(str));
    }
}
