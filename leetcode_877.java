class Solution {
    public int[] sortedSquares(int[] nums) {
        int sum = 0 ;
        int n = nums.length;
        int [] aftersquare = new int [n];
        for(int i = 0 ; i < n ; i++){
            aftersquare[i] = nums[i] * nums[i];

            
        }
        Array.sort(aftersquare);

        return aftersquare;
    }
}