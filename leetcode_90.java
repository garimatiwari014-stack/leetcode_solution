class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long left = 1;

        // Maximum possible answer:
        // smallest coin ka k-th multiple
        long minCoin = coins[0];

        for (int coin : coins) {
            minCoin = Math.min(minCoin, coin);
        }

        long right = minCoin * (long) k;

        while (left < right) {

            long mid = left + (right - left) / 2;

            if (count(mid, coins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long count(long x, int[] coins) {

        long count = 0;
        int n = coins.length;

        // All subsets
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            boolean valid = true;

            for (int j = 0; j < n; j++) {

                if ((mask & (1 << j)) != 0) {

                    long g = gcd(lcm, coins[j]);

                    // Prevent overflow
                    lcm = (lcm / g) * coins[j];

                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long ways = x / lcm;

            // Odd number of coins -> add
            // Even number of coins -> subtract
            if (Integer.bitCount(mask) % 2 == 1) {
                count += ways;
            } else {
                count -= ways;
            }
        }

        return count;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}