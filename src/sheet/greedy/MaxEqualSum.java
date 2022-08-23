package sheet.greedy;

public class MaxEqualSum {
    public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
        // update all stacks with net sum from back
        for(int i=N1-2; i>=0; i--) {
            S1[i] = S1[i] + S1[i+1];
        }
        for(int i=N2-2; i>=0; i--) {
            S2[i] = S2[i] + S2[i+1];
        }
        for(int i=N3-2; i>=0; i--) {
            S3[i] = S3[i] + S3[i+1];
        }

        int i = 0, j = 0, k = 0;
        while(i < N1 && j < N2 && k < N3) {
            // if stack tops gives same sum
            if(S1[i] == S2[j] && S2[j] == S3[k]) {
                return S1[i];
            }

            // remove the greatest sum between all stacks
            int max = Math.max(S1[i], Math.max(S2[j], S3[k]));
            if(S1[i] == max) {
                i++;
            } else if(S2[j] == max) {
                j++;
            } else {
                k++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int N1 = 3, N2 = 4, N3 = 2;
        int[] S1 = {4, 2, 3};
        int[] S2 = {1, 1, 2, 3};
        int[] S3 = {1, 4};

        System.out.println(maxEqualSum(N1, N2, N3, S1, S2, S3));
    }
}
