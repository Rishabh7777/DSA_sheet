package sheet.searching_and_sorting;

import java.util.Arrays;
import java.util.Comparator;

public class Problem27 {
    private static class Job {
        int start, end, profit;

        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return start + " -> " + end + ": " + profit;
        }
    }

    private static class JobComparator implements Comparator<Job> {
        @Override
        public int compare(Job o1, Job o2) {
            return o1.end - o2.end;
        }
    }

    private static int findNonConflictingJob(Job[] jobs, int idx) {
        //idx cannot give last non-conflicting job
        int low = 0, high = idx-1;
        while(low < high) {
            int mid = (low + high) / 2;
            if(jobs[mid].end > jobs[idx].start) {
                high = mid;
            } else {
                if(jobs[mid+1].end <= jobs[idx].start) {
                    //we have to find the last non-conflicting job to get max profit
                    low = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    private static int findMaxProfit(Job[] jobs) {
        //sort the jobs based on finish time
        Arrays.sort(jobs, new JobComparator());
        int n = jobs.length;
        //profitTill[i] -> maximum profit till ith index
        int[] profitTill = new int[n];
        profitTill[0] = jobs[0].profit;

        for(int i=1; i<n; i++) {
            int inc = jobs[i].profit; //on including current job
            int res = findNonConflictingJob(jobs, i);
            //on including current job, find the last non-conflicting job to set profit
            if(res != -1) {
                inc += profitTill[res];
            }
            profitTill[i] = Math.max(inc, profitTill[i-1]);
        }

        return profitTill[n-1];
    } //O(nlogn)

    public static void main(String[] args) {
        Job[] jobs = {new Job(0, 6, 60), new Job(1, 4, 30),
            new Job(3, 5, 10), new Job(5, 7, 30), new Job(5, 90, 50),
            new Job(7, 8, 10)};

        System.out.println(findMaxProfit(jobs));
    }
}