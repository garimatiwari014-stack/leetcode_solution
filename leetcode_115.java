class leetcode_115 {
    public int maxPalindromes(String s, int k) {

        int n = s.length();

        // palindrome[i][j] = true if s[i...j] is palindrome
        boolean[][] palindrome = new boolean[n][n];

        // Length 1
        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
        }

        // Length 2 se n tak
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {

                    if (len == 2) {
                        palindrome[i][j] = true;
                    } else {
                        palindrome[i][j] = palindrome[i + 1][j - 1];
                    }
                }
            }
        }

        // dp[i] = first i characters mein maximum palindromes
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            // Current character ko skip karo
            dp[i] = dp[i - 1];

            // Check all substrings ending at i-1
            for (int j = 0; j < i; j++) {

                int len = i - j;

                if (len >= k && palindrome[j][i - 1]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n];
    }



    public static void main(String [] args){
        String s = "avvvasd";
        int k = 2;
        leetcode_115 sol = new leetcode_115();
        System.out.println(sol.maxPalindromes(s, k));
    }
}