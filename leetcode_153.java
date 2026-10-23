class leetcode_153{
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int k = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                if (k == -1) {
                    k = nums[i] & i;
                } else {
                    k = k & nums[i] & i;
                }
            }
        }

        return k == -1 ? 0 : k;
    }
    public static void main(String [] args){
        
        leetcode_153 obj = new leetcode_153();
        System.out.println(obj.sortPermutation(new int[]{1, 2, 3, 4, 0}));
        System.out.println("Hello World");
}
}