class leetcode_145 {

    public int sumCounts(List<Integer> nums) {
        int n = nums.size(),
            res = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = i; j < n; j++) {
                s.add(nums.get(j));
                res += s.size() * s.size();
            }
        }
        return res;
    }
    public static void main(String[] args){
        leetcode_145 obj = new leetcode_145();
        List<Integer> nums = Arrays.asList(1, 2, 1);
        System.out.println(obj.sumCounts(nums)); // Output: 14
    }
}