 import java.util.*;
public class Leetcode_67 {


class Solution {
    private static final long LIMIT = 1_000_000L;
    private List<Integer> primes = new ArrayList<>();

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] half = new int[26];
        int halfLen = 0;
        String mid = "";

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLen += half[i];
            if ((freq[i] & 1) == 1) {
                mid = String.valueOf((char) ('a' + i));
            }
        }

        sieve(halfLen);

        if (countWays(half, halfLen) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        while (halfLen > 0) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;

                long ways = countWays(half, halfLen - 1);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    halfLen--;
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        String right = new StringBuilder(left).reverse().toString();
        return left.toString() + mid + right;
    }

    private void sieve(int n) {
        boolean[] composite = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (!composite[i]) {
                primes.add(i);
                if ((long) i * i <= n) {
                    for (int j = i * i; j <= n; j += i) {
                        composite[j] = true;
                    }
                }
            }
        }
    }

    private long countWays(int[] cnt, int total) {
        long ans = 1;

        for (int p : primes) {
            int exp = exponent(total, p);

            for (int x : cnt) {
                exp -= exponent(x, p);
            }

            while (exp-- > 0) {
                ans *= p;
                if (ans >= LIMIT) {
                    return LIMIT;
                }
            }
        }

        return ans;
    }

    private int exponent(int n, int p) {
        int res = 0;
        while (n > 0) {
            n /= p;
            res += n;
        }
        return res;
    }
}
}
