package sheet.string;

public class NumericKeypad {
    private static void sol(String s) {
        //create an array, which maps alphabets to corresponding numeric combination
        String[] arr = {"2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555",
            "6", "66", "666", "7", "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999"};

        StringBuilder res = new StringBuilder(); //takes O(1) time to concat
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                res.append("0");
            } else {
                res.append(arr[s.charAt(i) - 97]);
            }
        }

        System.out.println(res);
    } //O(n)

    public static void main(String[] args) {
        String s = "geeks for geeks";
        sol(s);
    }
}
