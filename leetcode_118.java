
import java.util.*;

class leetcode_118 {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int c = 0; c < 26; c++) {
            if (first[c] == n) continue;

            int l = first[c], r = last[c];
            boolean valid = true;

            for (int i = l; i <= r; i++) {
                int x = s.charAt(i) - 'a';

                if (first[x] < l) {
                    valid = false;
                    break;
                }

                r = Math.max(r, last[x]);
            }

            if (valid) intervals.add(new int[]{l, r});
        }

        intervals.sort((a, b) -> {
            if (a[1] != b[1])
                return a[1] - b[1];
            return b[0] - a[0];
        });

        List<String> ans = new ArrayList<>();
        int end = -1;

        for (int[] in : intervals) {
            if (in[0] > end) {
                ans.add(s.substring(in[0], in[1] + 1));
                end = in[1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // Test the solution
        leetcode_118 sol = new leetcode_118();
        String s = "adefaddaccc";
        List<String> result = sol.maxNumOfSubstrings(s);
        System.out.println(result); // Output: ["e","f","ccc"]
    }
}