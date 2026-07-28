class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = 0;

        // Build the left half in lexicographical order
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }

            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }
        }

        // Create the palindrome
        String right = new StringBuilder(left).reverse().toString();

        if (middle != 0) {
            return left.toString() + middle + right;
        }

        return left.toString() + right;
    }
}