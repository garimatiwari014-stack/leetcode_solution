import java.util.*;

class leetcode_112_ {

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // [left, right, weight, originalIndex]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {

            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by right endpoint
        Arrays.sort(arr, (a, b) -> {

            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[3], b[3]);
        });

        // prev[i] = last interval which does not overlap with i
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {

            int low = 0;
            int high = i - 1;
            int ans = -1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                // Strictly less because touching boundaries overlap
                if (arr[mid][1] < arr[i][0]) {

                    ans = mid;
                    low = mid + 1;

                } else {

                    high = mid - 1;
                }
            }

            prev[i] = ans;
        }

        // dp[k][i] = maximum score
        // using at most k intervals among first i intervals
        long[][] dp = new long[5][n + 1];

        // Store selected original indices
        List<Integer>[][] path = new ArrayList[5][n + 1];

        for (int k = 0; k <= 4; k++) {

            for (int i = 0; i <= n; i++) {

                path[k][i] = new ArrayList<>();
            }
        }

        // We can select at most 4 intervals
        for (int k = 1; k <= 4; k++) {

            for (int i = 1; i <= n; i++) {

                // -------------------------
                // OPTION 1: SKIP INTERVAL
                // -------------------------

                dp[k][i] = dp[k][i - 1];

                path[k][i] =
                    new ArrayList<>(path[k][i - 1]);


                // -------------------------
                // OPTION 2: TAKE INTERVAL
                // -------------------------

                int p = prev[i - 1] + 1;

                long takeScore =
                    dp[k - 1][p] + arr[i - 1][2];

                List<Integer> takePath =
                    new ArrayList<>(path[k - 1][p]);

                // Add original index
                takePath.add(arr[i - 1][3]);

                // Sort indices because answer must be
                // lexicographically compared
                Collections.sort(takePath);


                // -------------------------
                // CHOOSE BETTER OPTION
                // -------------------------

                if (takeScore > dp[k][i]) {

                    dp[k][i] = takeScore;
                    path[k][i] = takePath;

                } else if (takeScore == dp[k][i]) {

                    // Same score
                    // Choose lexicographically smaller answer

                    if (smaller(takePath, path[k][i])) {

                        dp[k][i] = takeScore;
                        path[k][i] = takePath;
                    }
                }
            }
        }

        // Convert List<Integer> to int[]
        List<Integer> answer = path[4][n];

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {

            result[i] = answer.get(i);
        }

        return result;
    }


    // --------------------------------------------------
    // Check lexicographically smaller list
    // --------------------------------------------------

    private static boolean smaller(
            List<Integer> a,
            List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {

                return a.get(i) < b.get(i);
            }
        }

        // If one list is prefix of another,
        // shorter list is lexicographically smaller
        return a.size() < b.size();
    }


    // --------------------------------------------------
    // MAIN METHOD FOR LOCAL TESTING
    // --------------------------------------------------

    public static void main(String[] args) {

        leetcode_112_ sol = new leetcode_112_();


        List<List<Integer>> intervals = new ArrayList<>();


        intervals.add(Arrays.asList(1, 3, 4));

        intervals.add(Arrays.asList(2, 5, 2));

        intervals.add(Arrays.asList(4, 6, 3));

        intervals.add(Arrays.asList(7, 8, 5));

        intervals.add(Arrays.asList(5, 9, 1));


        int[] result = sol.maximumWeight(intervals);


        System.out.println(Arrays.toString(result));
    }
}