package sheet.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//similar as activity selection problem
public class MaxMeetingsInRoom {
    private static class Meeting {
        int start, end, num;
        Meeting(int start, int end, int num) {
            this.start = start;
            this.end = end;
            this.num = num;
        }
        public String toString() {
            return "(" + this.start + "," + this.end + "," + this.num + ")";
        }
    }

    private static class SortByEndTime implements Comparator<Meeting> {
        public int compare(Meeting o1, Meeting o2) {
            return o1.end - o2.end;
        }
    }

    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        Meeting[] arr = new Meeting[N];
        for(int i=0; i<N; i++) {
            arr[i] = new Meeting(S[i], F[i], i+1);
        }

        Arrays.sort(arr, new SortByEndTime());

        int prevEnd = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<N; i++) {
            if(arr[i].start > prevEnd) {
                prevEnd = arr[i].end;
                res.add(arr[i].num);
            }
        }

        Collections.sort(res);
        return res;
    } // O(n * log(n))

    public static void main(String[] args) {
        int n = 10;
        int[] s = {12, 6, 16, 12, 6, 9, 16, 6, 17, 5};
        int[] f = {17, 13, 16, 18, 17, 10, 18, 12, 18, 11};
        System.out.println(maxMeetings(n, s, f));
    }
}
