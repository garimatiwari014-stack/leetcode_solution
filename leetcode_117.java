class leetcode_117 {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int[] best = new int[n];

        int INF = 1000000;
        int ans = INF;

        int left = 0;
        int sum = 0;
        int minLen = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int len = right - left + 1;

                // Previous non-overlapping subarray
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                minLen = Math.min(minLen, len);
            }

            // Best subarray till current index
            best[right] = minLen;
        }

        return ans == INF ? -1 : ans;
    }


    public static void main(String [] args){
        int [] arr = {1,2,3,4,5};
        int target = 3;
        leetcode_117 sol = new leetcode_117();
        System.out.println(sol.minSumOfLengths(arr, target));
    }
}