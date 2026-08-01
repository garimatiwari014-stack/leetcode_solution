class Solution {

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n];

        return solve(nums, 0, n - 1, dp) >= 0;
    }

    private int solve(int[] nums, int i, int j, Integer[][] dp) {

        // Base Case
        if (i == j) {
            return nums[i];
        }

        // Already computed
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Pick left
        int left = nums[i] - solve(nums, i + 1, j, dp);

        // Pick right
        int right = nums[j] - solve(nums, i, j - 1, dp);

        // Store answer
        dp[i][j] = Math.max(left, right);

        return dp[i][j];
    }
}