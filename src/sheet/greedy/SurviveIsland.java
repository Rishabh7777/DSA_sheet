package sheet.greedy;

public class SurviveIsland {
    public static int minimumDays(int S, int N, int M){
        if(M > N || ((M*7 > N*6) && S > 6)) {
            return -1;
        }
        int days = ((S * M) / N);
        if((S * M) % N != 0) {
            days++;
        }
        return days;
    }
}
