public class leetcode_977 {
class Solution {
    public int[] sortedSquares(int[] nums) {

        // for (int i = 0; i < nums.length; i++) {
        //     nums[i] = nums[i] * nums[i];

            
        // }
        // Arrays.sort(nums);
        
        // return nums;


 int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0, j = n - 1, k = n - 1; i <= j; --k) {

            int a = nums[i] * nums[i];
            int b = nums[j] * nums[j];

            if (a > b) {
                ans[k] = a;
                ++i;
            } else {
                ans[k] = b;
                --j;
            }
        }

        return ans;
    }
}
}
