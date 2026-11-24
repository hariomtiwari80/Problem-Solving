class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] dp = new int[n];
        dp[0] = 1;

        int[] idx = new int[k];
        long[] vals = new long[k];
        for (int j = 0; j < k; j++) {
            vals[j] = primes[j];
        }

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (vals[j] < min) {
                    min = vals[j];
                }
            }
            dp[i] = (int) min;

            for (int j = 0; j < k; j++) {
                if (vals[j] == min) {
                    idx[j]++;
                    vals[j] = (long) primes[j] * dp[idx[j]];
                }
            }
        }

        return dp[n - 1];
    }
}