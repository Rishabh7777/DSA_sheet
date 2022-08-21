package sheet.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestJobFirst {
    private static class Process implements Comparable<Process>{
        int processID, arrivalTime, burstTime;
        public Process(int processID, int arrivalTime, int burstTime) {
            this.arrivalTime = arrivalTime;
            this.processID = processID;
            this.burstTime = burstTime;
        }

        @Override
        public int compareTo(Process o) {
            return this.arrivalTime - o.arrivalTime;
        }
    }

    private static class SortByBurstTime implements Comparator<Process> {
        @Override
        public int compare(Process o1, Process o2) {
            return o1.burstTime - o2.burstTime;
        }
    }

    public static void scheduleJobs(Process[] arr) {
        //sort the jobs based on arrival time
        Arrays.sort(arr);
        PriorityQueue<Process> readyQ = new PriorityQueue<>(new SortByBurstTime());
        readyQ.add(arr[0]);
        int i = 1;
        int time = arr[0].arrivalTime;
        while(!readyQ.isEmpty()) {
            Process curr = readyQ.peek();
            System.out.println("Process " + curr.processID + " from " + time + " to " + (time + curr.burstTime));
            time += curr.burstTime;
            readyQ.poll();
            while(i < arr.length && time >= arr[i].arrivalTime) {
                readyQ.add(arr[i++]);
            }
        }
    }

    public static void main(String[] args) {
        Process[] arr = {new Process(1,2,6), new Process(2,5,2),
            new Process(3,1,8), new Process(4,0,3),
            new Process(5,4,4)};

        scheduleJobs(arr);
    }
}
