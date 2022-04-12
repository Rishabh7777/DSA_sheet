package sheet.string;

public class PrintDuplicates {
    private static void sol(String s) {
        s = s.replaceAll("\\s", "");
        int[] count = new int[25];

        for(char c: s.toCharArray()) {
            count[c - 97]++;
        }

        for(int i=0; i<25; i++) {
            if(count[i] > 1) {
                System.out.println((char)(97+i) + " = " + count[i]);
            }
        }
    }

    public static void main(String[] args) {
        String s = "test string main";
        sol(s);
    }
}
