public class maximum_vowel_in_Window_of_size{
    static boolean isVowel(char c){
        return "aeiou".indexOf(c) != -1 ;
    }   
    public static void main(String [] args){
      String s = "aoninv";
int count = 0;
      int max = 0 ;
      int k = 3 ;
      for(int i = 0 ; i < s.length() -k ; i++){
        if(isVowel(s.charAt(i))){
            count ++;
        }
    }
        for(int i = 0 ; k <s.length() ; i++){
            if(isVowel(s.charAt(i))){
                count ++ ;
            }
            if(isVowel(s.charAt(i-k))){
                count -- ;
            }

        
      }
    System.out.println(max);
    }

}