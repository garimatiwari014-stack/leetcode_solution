

public class first_negative_in_every_window{

    public static void main(String [] args){
           int [] arr = {-8, 2, 3, -6, 10};
            int k = 3;
            for(int i = 0 ; i<arr.length -k; i++){
                boolean flag = false;
                for(int j = i ; j < i+k ; j++){
                    if(arr[j]<0){
          System.out.println(arr[j] + "");
          flag = true ;
       break;
                    }

                }
            }
        if(!flag){
            System.out.println("0");
        }

     


    }
}