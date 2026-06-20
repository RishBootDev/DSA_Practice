import java.util.Arrays;

public class JobSequencingWithProfit {

        public static long calculateMaxProfit(
                int[] start,
                int[] end,
                int[] profit) {

            int n = start.length;

            Job[] jobs = new Job[n];

            for(int i = 0; i< n; i++) {
                Job j = new Job(start[i], end [i], profit[i]);
                jobs[i] = j;
            }

            Arrays.sort(jobs, (a, b) -> a.end - b.end);

            long dp [] = new long[n];
            dp[0] = jobs[0].profit;

            int []ends = new int[n];

            for(int i = 0; i< n; i++) {
                ends[i] =  jobs[i].end;

            }

            for(int i = 1; i< n; i++) {
                long curr = jobs[i].profit;

                int idx = search(ends, jobs[i]. start);
                if(idx != -1) {
                    curr += dp[idx];
                }

                dp[i] = Math.max(dp[i - 1], curr);

            }


            return dp[n - 1];
        }
        public static int search(int ends[], int target) {
            int left = 0;
            int right = ends.length -1;
            int result = -1;

            while(left <= right) {
                int mid = left + (right - left)/2;
                if(ends[mid] <= target) {
                    result = mid;
                    left = mid + 1;
                }else {
                    right = mid -1;
                }
            }

            return result;
        }

        static class Job{
            int start, end, profit;

            public Job(int start, int end, int profit) {
                this.start= start;
                this.end = end;
                this.profit = profit;
            }
        }
    }


