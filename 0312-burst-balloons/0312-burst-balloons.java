class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] padded = new int[n + 2];
        padded[0] = 1;
        padded[n + 1] = 1;
        System.arraycopy(nums, 0, padded, 1, n);
        int[][] memo = new int[n + 2][n + 2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return f(1, n, padded, memo);
    }
    
    private int f(int i, int j, int[] padded, int[][] memo) {
        if (i > j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        
        int maxV = Integer.MIN_VALUE;
        
        for (int index = i; index <= j; index++) {
            int coins = (padded[i - 1] * padded[index] * padded[j + 1])
                        + f(i, index - 1, padded, memo) 
                        + f(index + 1, j, padded, memo);
            
            maxV = Math.max(maxV, coins);
        }
        
        return memo[i][j] = maxV; 
    }
}
