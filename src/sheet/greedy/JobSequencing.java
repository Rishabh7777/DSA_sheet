package sheet.greedy;

import java.util.*;

public class JobSequencing {
    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }

        public String toString() {
            return "(" + this.id + ", " + this.deadline + ", " + this.profit + ")";
        }
    }

    static class SortByProfit implements Comparator<Job> {
        public int compare(Job o1, Job o2) {
            return (o2.profit - o1.profit);
        }
    }

    public static int[] JobScheduling(Job[] arr, int n) {
        ArrayList<Job> jobs = new ArrayList<>();
        Collections.addAll(jobs, arr);
        jobs.sort(new SortByProfit());
        int[] jobSchedule = new int[n];
        int count = 0, profit = 0;
        for(Job i: jobs) {
            for(int j=Math.min(n-1, i.deadline-1); j>=0; j--) {
                if(jobSchedule[j] == 0) {
                    jobSchedule[j] = i.id;
                    count++;
                    profit += i.profit;
                    break;
                }
            }
        }
        return new int[]{count, profit};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Job[] arr = new Job[n];
        for(int i=0; i<n; i++) {
            int id = scan.nextInt();
            int deadline = scan.nextInt();
            int profit = scan.nextInt();
            arr[i] = new Job(id, deadline, profit);
        }
        int[] res = JobScheduling(arr, n);
        System.out.println(Arrays.toString(res));
    }
}
