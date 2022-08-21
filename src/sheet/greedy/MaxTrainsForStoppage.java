package sheet.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaxTrainsForStoppage {
    private static class Train {
        int arrivalTime, deptTime, platform;

        public Train(int arrivalTime, int deptTime, int platform) {
            this.arrivalTime = arrivalTime;
            this.deptTime = deptTime;
            this.platform = platform;
        }

        public String toString() {
            return "(" + this.arrivalTime + "," + this.deptTime + "," + this.platform + ")";
        }
    }

    private static class SortByDeptTime implements Comparator<Train> {
        @Override
        public int compare(Train o1, Train o2) {
            return o1.deptTime - o2.deptTime;
        }
    }

    public static int maxTrains(int n, int p, Train[] trains) {
        //sort the trains based on dept time
        Arrays.sort(trains, new SortByDeptTime());

        int[] time = new int[p + 1]; //time until which a platform is busy holding another train
        Arrays.fill(time, -1); //as arrival time can also be 0 (00:00)

        int count = 0;
        for(int i=0; i<n; i++) {
            Train curr = trains[i];
            //for a particular platform, dept time (time[i]) for it should be greater than arrival time of next train
            if(curr.arrivalTime > time[curr.platform]) {
                //train can stop
                count++;
                time[curr.platform] = curr.deptTime;
            }
        }

        return count;
    } //time = O(n * log(n)), space = O(p)

    public static void main(String[] args) {
        int n = 5, p = 2;
        Train[] trains = {new Train(1000, 1030, 1),
                new Train(1010, 1020, 1), new Train(1025, 1040, 1),
                new Train(1130, 1145, 2), new Train(1130, 1140, 2)};

        System.out.println("Maximum Stopped Trains = " + maxTrains(n, p, trains));
    }
}
