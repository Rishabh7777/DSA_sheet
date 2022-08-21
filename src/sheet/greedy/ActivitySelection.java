package sheet.greedy;

import java.util.ArrayList;
import java.util.Comparator;

public class ActivitySelection {
    static class Pair {
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return "(" + this.start + ", " + this.end + ")";
        }
    }

    static class SortByEndTime implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.end - o2.end;
        }
    }

    public static int maxMeetings(int[] start, int[] end, int n) {
        ArrayList<Pair> meetings = new ArrayList<>();
        for(int i=0; i<start.length; i++) {
            meetings.add(new Pair(start[i], end[i]));
        }
        //sort meetings based on end time
        meetings.sort(new SortByEndTime());
        int endTime = -1, count = 0;
        for(Pair meeting : meetings) {
            if(meeting.start > endTime) {
                count++;
                endTime = meeting.end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int len = 8;
        int[] start = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
        int[] end = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252};
        System.out.println(maxMeetings(start, end, len));
    }
}
