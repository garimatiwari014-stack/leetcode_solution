import java.util.Arrays;
class leetcode_143 {

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        for(int i = 0 ; i < n; i++){
            nums[i] = nums[i] * nums[i];

        }
        Arrays.sort(nums);
        long ans = 0;
        for(int i = 0 ; i < n/2 ; i++){
            ans = ans - nums[i];
        }
        for(int i = n/2 ; i< n; i++){
            ans = ans + nums[i];
        }
        return ans ;
    }

    public static void main(String [] args){
        leetcode_143 obj = new leetcode_143();
        int [] nums = {2,3,4,5,6};
        obj. maxAlternatingSum(nums);
          System.out.println(obj. maxAlternatingSum(nums));
    }
}