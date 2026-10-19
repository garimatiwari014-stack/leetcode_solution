
import java.util.*;

class LEETCODE_149 {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LEETCODE_149 solution = new LEETCODE_149();

        int[] nums = {1, 2, 5, 2, 3};
        int target = 2;

        List<Integer> result = solution.targetIndices(nums, target);
        System.out.println(result);
    }
}
