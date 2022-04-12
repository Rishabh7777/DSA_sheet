package sheet.string;

public class Problem40 {
    private static int sol(int comp, String customers) {
        int[] cafe = new int[26];
        //cafe[i] == 0 -> current customer is not in cafe
        //cafe[i] == 1 -> current customer is in cafe but did not get a seat
        //cafe[i] == 2 -> current customer is in cafe and got a seat

        int res = 0; //customers gone without using computers
        int occupied = 0; //number of seats currently occupied in cafe
        for(int i=0; i<customers.length(); i++) {
            int idx = customers.charAt(i) - 'A'; //index of customer in cafe[]

            if(cafe[idx] == 0) {
                cafe[idx] = 1; //customer is in the cafe
                if(occupied < comp) {
                    cafe[idx] = 2; //customers occupies a seat
                    occupied++;
                }
            } else if(cafe[idx] == 1) {
                //current customer is in cafe but did not get a seat
                cafe[idx] = 0;
                res++;
            } else {
                //current customer is using a computer
                cafe[idx] = 0;
                occupied--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(sol(2, "ABBAJJKZKZ"));
        System.out.println(sol(3, "GACCBDDBAGEE"));
        System.out.println(sol(3, "GACCBGDDBAEE"));
        System.out.println(sol(1, "ABCBCA"));
        System.out.println(sol(1, "ABCBCADEED"));
    }
}
