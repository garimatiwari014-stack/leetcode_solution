import java.util.HashSet;

public class leetcode_217 {
    public boolean containsDuplicate(int [] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true ;
            }
            set.add(num);

        }
        return false;
    }




    public static void main(String [] args){

        leetcode_217 obj = new leetcode_217();
        int [] nums ={ 2,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10 ,11 ,12 ,13 ,14 ,15 ,16 ,17 ,18 ,19 ,20};

        System.out.println(obj.containsDuplicate(nums));
    }
}
