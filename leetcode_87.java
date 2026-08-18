import java.util.HashMap;
import java.util.HashSet;
class leetcode_87{


    public int findlargestOne(int [] nums, int k ){
        HashMap<Integer , Integer> count = new HashMap<>();
          for(int i = 0 ; i <nums.length -k ; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i ; j < i+k ; j++){
                set.add(nums[j]);
            }

          

          for(int num : set){
            count.put(num , count.getOrDefault(num, 0) + 1);
          }

    }
    int ans = -1;
    for(int num:count.keySet()){
        if(count.get(num) == 1){
            ans = Math.max(ans , num);
        }
    }
    return ans;
    }   
    public static void main(String [] args){
        int [] nums = {9 ,1 ,2,3,4};
        int k = 3;


        leetcode_87 obj = new leetcode_87();
        System.out.println(obj.findlargestOne(nums, k));

    }
}