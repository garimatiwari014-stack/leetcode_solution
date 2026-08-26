class leetcode_95 {
    public String shortestBeautifulSubstring(String s, int k) {

        String ans = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {

            int count = 0;

            for (int j = i; j < s.length(); j++) {

                if (s.charAt(j) == '1') {
                    count++;
                }

                // Exactly k ones
                if (count == k) {

                    String sub = s.substring(i, j + 1);

                    // Smaller length
                    if (sub.length() < minLen) {
                        minLen = sub.length();
                        ans = sub;
                    }

                    // Same length, lexicographically smaller
                    else if (sub.length() == minLen &&
                             sub.compareTo(ans) < 0) {
                        ans = sub;
                    }

                    // Further extending only increases length
                    break;
                }
            }
        }

        return ans;
    }


    public static void main(String [] args){
        leetcode_95 sol = new leetcode_95();
        String s = "110100111"; 
        int k = 3 ;
        sol.shortestBeautifulSubstring(s, k);
        System.out.println(sol.shortestBeautifulSubstring(s, k));
    }
}