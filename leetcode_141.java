class leetcode_141{
    public int   sumofsquares(int nums[]){
   int n = nums.length ;
   int sum = 0 ;
   for(int i = 1 ; i <= n ; i++){
    if( n % i == 0){
        sum = sum + nums[i-1] * nums[i-1] ;
    }
   }
   return sum ;
    
  }



    public static void main(String [] args) {
      leetcode_141 st = new leetcode_141() ;
      int [] nums = {1,2,3,4,5} ;
      st.sumofsquares(nums);
      System.out.println(st.sumofsquares(nums)) ;

    }
}