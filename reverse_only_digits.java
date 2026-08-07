public class reverse_only_digits{


  String reversedigits(String s){
    char [] arr = s.toCharArray();
    int i = 0 ;
    int j = arr.length-1;
    while(i <j){
        while(i <j && !Character.isDigit(arr[i]))i++;
        while(i<j && !Character.isDigit(arr[j]))j++;
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp ;
        i++;
        j++;
    }
          return new String(arr);

 }


    public static void main(String[] args){
        String s = "23sr78";
        reverse_only_digits obj = new reverse_only_digits();
        System.out.println(obj.reversedigits(s));
    }
}