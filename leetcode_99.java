class leetcode_99 {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {

            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int front = Math.max(minIndex, maxIndex) + 1;

        int back = n - Math.min(minIndex, maxIndex);

        int both = Math.min(minIndex, maxIndex) + 1
                 + n - Math.max(minIndex, maxIndex);

        return Math.min(front, Math.min(back, both));
    }
    public static void main(String [] args){
        int [] nums = {3,6,8,9,6,6};
        leetcode_99 sol = new leetcode_99();
        System.out.println(sol.minimumDeletions(nums));
    }
}