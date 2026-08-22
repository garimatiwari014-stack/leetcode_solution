class leetcode_91 {
    public boolean checkDivisibility(int n) {
          char [] str = String.valueOf(n).toCharArray();
          int sum = 0 ;
           int product = 1 ;
           


          for(char nums : str){
            int digit = nums - '0';
               sum = sum + digit;
               product = product * digit;
                     

          }
         
                    int max = sum  + product ;

                            if((n / max) == 0){
                                return true;
                            }



  return  false ;

    }



    public static void main(String [] args){
        int n = 59;

        leetcode_91 st = new leetcode_91( );
        st.checkDivisibility(n);

    }
}