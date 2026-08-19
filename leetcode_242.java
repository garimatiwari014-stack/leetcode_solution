public class leetcode_242 {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        // s ke characters count karo
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // t ke characters count ghatao
        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
        }

        // Check karo sab frequency 0 hai ya nahi
        for (int x : freq) {
            if (x != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        leetcode_242 solution = new leetcode_242();

        String s = "anagram";
        String t = "nagaram";

        System.out.println(solution.isAnagram(s, t));
    }
}