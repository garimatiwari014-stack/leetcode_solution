class leetcode_136{
    public int singleNumber(int [] nums){
        int  ans = 0 ;
        for(int num :nums){
            ans ^= num;
        }
        return ans;
    }


    public static void main(String [] args) {
        leetcode_136 solution = new leetcode_136();
        int [] nums = {4,1,2,1,2};
        System.out.println(solution.singleNumber(nums));
    }
}
