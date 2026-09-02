class leetcode_102_1 {
    public boolean uniformArray(int[] nums1) {
        int [] nums2 = new int[nums1.length];
         
        for(int i = 0 ; i <nums1.length -1; i++){
            nums2[i] = nums1[i] - nums1[i+1];
            nums2[i+1] = nums1[i+1];


        }
        for(int i = 0 ; i<nums2.length -1; i++){

            if(nums2[i] % 2 == 0 && nums2[i+1] % 2== 0){
                return true;

            }
            else if(nums2[i] % 2 != 0 && nums2[i+1] % 2!= 0){
                return true;
            }
        }
       

             return false ;
    }
     public static void main(String [] args){
        int [] nums = {2,3,4};
        leetcode_102_1 s = new leetcode_102_1();
        System.out.println(s.uniformArray(nums));

     }
}