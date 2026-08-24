class Solution {
    public int stoneGameVIII(int[] stones) {

        int n = stones.length;

        // Prefix sum
        int[] prefix = new int[n];

        prefix[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        // Initially, if Alice takes all stones
        int ans = prefix[n - 1];

        // Try taking prefix of length >= 2
        for (int i = n - 2; i >= 1; i--) {

            // Current player gets prefix[i]
            // Then opponent gets ans
            ans = Math.max(ans, prefix[i] - ans);
        }

        return ans;
    }
}