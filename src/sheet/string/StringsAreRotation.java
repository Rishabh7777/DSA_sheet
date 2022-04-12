package sheet.string;

public class StringsAreRotation {
    private static boolean isRotation(String s1, String s2) {
        String temp = s1 + s1;
        return temp.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";

        System.out.println(isRotation(s1, s2));
    }
}
