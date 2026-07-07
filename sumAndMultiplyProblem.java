
class Solution {
    public long sumAndMultiply(int n) {
       String str = String.valueOf(n);
       long num = 0 ;
       int sum = 0;
       int digit = 0;
       for(int i = 0 ; i < str.length(); i++){
        char ch = str.charAt(i);
        if(ch !='0'){
            digit = ch - '0';
            sum = sum + digit ;
             num = num * 10 + digit;

        }

       }
     return (long)sum * num ;
    }
}