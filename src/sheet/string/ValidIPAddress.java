package sheet.string;

import java.util.ArrayList;

public class ValidIPAddress {
    public static ArrayList<String> list; //to store all valid IP address combinations

    public static ArrayList<String> restoreIpAddresses(String s) {
        int n = s.length();
        list = new ArrayList<>();

        //cannot be valid
        if (n < 4 || n > 12) {
            return list;
        }

        //dp[0][i] tells if it is possible to form one part of an IP address with substring from i to n
        int[][] dp = new int[4][n];
        for (int i = 0; i < 4; i++) {
            //move from end to 0 index of the string
            System.out.println("i = " + i);
            for (int j = n - 1; j >= 0; j--) {
                System.out.println("j = " + j);
                if (i == 0) {
                    String sub = s.substring(j);
                    System.out.println("substring: " + sub);
                    if (isValid(sub)) {
                        System.out.println("valid substring");
                        dp[i][j] = 1;
                    } else if (j < n - 3) {
                        System.out.println(j + " is less than " + n);
                        break;
                    }
                } else {
                    if (j <= n - i) {
                        for (int k = 1; k <= 3 && j + k <= n; k++) {
                            String temp = s.substring(j, j + k);
                            System.out.println("temp string: " + temp);
                            if (isValid(temp)) {
                                System.out.println("temp is valid");
                                if (j + k < n && dp[i - 1][j + k] == 1) {
                                    dp[i][j] = 1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (dp[3][0] == 0) {
            return list;
        }

        createIpFromDp(dp, 3, 0, s, "");
        return list;
    }

    public static void createIpFromDp(int[][] dp, int r, int c, String s, String ans) {
        if (r == 0) {
            ans += s.substring(c);
            list.add(ans);
            return;
        }

        for (int i = 1; i <= 3 && c + i < s.length(); i++) {
            String substring = s.substring(c, c + i);
            if (isValid(substring) && dp[i][r - 1] == 1) {
                createIpFromDp(dp, r - 1, c + i, s,ans + substring + ".");
            }
        }
    }


    private static boolean isValid(String ip) {
        String[] a = ip.split("[.]");
        for (String s : a) {
            int i = Integer.parseInt(s);
            if (s.length() > 3 || i < 0 || i > 255) {
                return false;
            }
            if (s.length() > 1 && i == 0) {
                return false;
            }
            if (s.length() > 1 && s.charAt(0) == '0') {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135").toString());
    }
}