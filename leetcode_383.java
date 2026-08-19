public class leetcode_383 {
    public boolean canConstruct(String ransomNote , String magazine){
        int [] freq = new int [26];
        for(char c : magazine.toCharArray()){
            freq[c-'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            freq[c-'a']--;
            if(freq[c-'a']<0){
                return false;
            }
        }
        return true;
    }


    public static void main(String [] args) {
        leetcode_383 solution = new leetcode_383();
        String ransomNote = "aa";
        String magazine = "ab";
}
}
