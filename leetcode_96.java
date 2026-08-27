class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder prefix = new StringBuilder();

        return dfs(0, false, target, freq, prefix);
    }

    private String dfs(int pos, boolean greater, String target,
                       int[] freq, StringBuilder prefix) {

        if (pos == target.length()) {
            return greater ? prefix.toString() : "";
        }

        int start = greater ? 0 : target.charAt(pos) - 'a';

        for (int ch = start; ch < 26; ch++) {

            if (freq[ch] == 0) continue;

            if (!greater && ch < target.charAt(pos) - 'a') continue;

            freq[ch]--;
            prefix.append((char) ('a' + ch));

            String ans = dfs(pos + 1,
                    greater || ch > target.charAt(pos) - 'a',
                    target, freq, prefix);

            if (!ans.isEmpty()) return ans;

            prefix.deleteCharAt(prefix.length() - 1);
            freq[ch]++;
        }

        return "";
    }
}