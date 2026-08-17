// iven a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

// Example 1:

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// Example 2:

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined



class leetcode_1004{
    public int longestOnes(int [] nums , int k ){
        int left = 0 ;
        int max = 0 ;
        int countzero = 0 ;
        for(int right = 0 ; right <= nums.length ; right++){
            if(nums[right] == 0)countzero++;
            while(countzero > k){
                if(nums[left] == 0 ) countzero --;
                left++;
            }
            max = Math.max(max , right -left+1);
        }
        return max ;
    }

    public static void main(String [] args){
        int [] nums = { 1,00,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 2 ;
         leetcode_1004 obj = new leetcode_1004();
         obj.longestOnes(nums, k);

    }
}

