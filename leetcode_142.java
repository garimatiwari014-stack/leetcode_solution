
import java.util.*;

class Solution {

    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        int[] cnt = new int[30];

        // Count set bits at each position
        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0) {
                    cnt[i]++;
                }
            }
        }

        long res = 0;

        // Construct k maximum numbers
        for (int i = 0; i < k; i++) {
            long cur = 0;

            for (int j = 29; j >= 0; j--) {
                if (cnt[j] > 0) {
                    cur |= (1L << j);
                    cnt[j]--;
                }
            }

            res = (res + cur * cur) % MOD;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int k = 3;

        int result = solution.maxSum(nums, k);
        System.out.println(result);
    }
}
