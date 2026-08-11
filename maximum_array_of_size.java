public class maximum_array_of_size{
    public static  int main(String[] args){
        int [] arr = {2,3,4,5,6};
        int max = 0 ;
         int k = 4;
        for(int i = 0 ; i<arr.length -k ; i++){
            max = arr[i];
            for(int j = i ; j< i+k; j++){
                max = Math.max(max , arr[j]);
            }

        }
       return max ;
    }

}
