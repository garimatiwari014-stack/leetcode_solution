```java
public class leetcode_105 {

    public int firstStableIndex(int[] nums, int k) {

        int n = nums.length;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        // Prefix Maximum
        prefixMax[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        // Suffix Minimum
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        // Find first stable index
        for (int i = 0; i < n; i++) {

            int instability = prefixMax[i] - suffixMin[i];

            if (instability <= k) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        leetcode_105 sol = new leetcode_105();

        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;

        int result = sol.firstStableIndex(nums, k);

        System.out.println("The first stable index is: " + result);
    }
}
```
