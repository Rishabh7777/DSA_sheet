package sheet.searching_and_sorting;

public class Problem31 {
    private static boolean ifPossible(int[] time, int prata, int cooks, int givenTime) {
        int prataMade = 0, totalTimeByCook = 0, multipleFactor = 1;
        //made maximum number of prata by each cook under given time limit
        //if total pratas can be made then return true else false
        for(int i=0; i<cooks; ) {
            if(totalTimeByCook + (multipleFactor * time[i]) <= givenTime) {
                prataMade++;
                totalTimeByCook += (multipleFactor * time[i]);
                multipleFactor++;
            } else {
                i++;
                totalTimeByCook = 0;
                multipleFactor = 1;
            }
            if(prataMade == prata) {
                return true;
            }
        }
        return false;
    }

    private static int sol(int[] time, int prata, int cooks) {
        //maximum time taken to build all prata, when initial time taken by cook is 1
        //1st -> 1, 2nd -> 2, 3rd -> 3, ...., 10th -> 10 (sum of n natural numbers)
        int low = 0, high = (prata * (prata+1)) / 2;
        while(low < high) {
            //mid -> maximum time allowed to each cook to made as much prata they can made
            int mid = low + (high - low)/2;
            if(ifPossible(time, prata, cooks, mid)) {
                //given number of pratas can be made with current mid, so lower the time limit
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int prata = 10, cooks = 4;
        int[] time = {1, 2, 3, 4};
        System.out.println(sol(time, prata, cooks));

        prata = 8;
        cooks = 1;
        time = new int[] {1};
        System.out.println(sol(time, prata, cooks));

        cooks = 8;
        time = new int[] {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(sol(time, prata, cooks));
    }
}
