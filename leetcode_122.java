
class leetcode_122 {
    int k;
    int n;
    int[] product;
    int[][] cnt;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        this.n = nums.length;

        product = new int[4 * n];
        cnt = new int[4 * n][k];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update persists for subsequent queries
            update(1, 0, n - 1, index, value);

            // Query the range [start, n - 1]
            Node res = query(1, 0, n - 1, start, n - 1);

            ans[i] = res.cnt[x];
        }

        return ans;
    }

    // Segment tree node
    class Node {
        int product;
        int[] cnt;

        Node(int product, int[] cnt) {
            this.product = product;
            this.cnt = cnt;
        }
    }

    // Build segment tree
    void build(int node, int left, int right, int[] nums) {
        if (left == right) {
            int rem = nums[left] % k;

            product[node] = rem;
            cnt[node][rem] = 1;
            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        merge(node);
    }

    // Merge the two children
    void merge(int node) {
        int left = node * 2;
        int right = node * 2 + 1;

        int leftProduct = product[left];

        product[node] =
            (leftProduct * product[right]) % k;

        // Prefixes entirely in the left segment
        for (int r = 0; r < k; r++) {
            cnt[node][r] = cnt[left][r];
        }

        // Prefixes that extend into the right segment
        for (int r = 0; r < k; r++) {
            int newRem = (leftProduct * r) % k;

            cnt[node][newRem] += cnt[right][r];
        }
    }

    // Point update
    void update(int node, int left, int right,
                int index, int value) {

        if (left == right) {
            int rem = value % k;

            product[node] = rem;

            // Reset old remainder frequency
            for (int r = 0; r < k; r++) {
                cnt[node][r] = 0;
            }

            cnt[node][rem] = 1;
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right,
                   index, value);
        }

        merge(node);
    }

    // Range query
    Node query(int node, int left, int right,
               int ql, int qr) {

        // No overlap: empty segment
        if (right < ql || left > qr) {
            return new Node(1, new int[k]);
        }

        // Complete overlap
        if (ql <= left && right <= qr) {
            return new Node(product[node], cnt[node].clone());
        }

        int mid = left + (right - left) / 2;

        Node L = query(node * 2, left, mid, ql, qr);
        Node R = query(node * 2 + 1, mid + 1, right, ql, qr);

        return mergeNodes(L, R);
    }

    // Merge two query results
    Node mergeNodes(Node A, Node B) {
        int newProduct = (A.product * B.product) % k;

        int[] newCnt = new int[k];

        for (int r = 0; r < k; r++) {
            newCnt[r] = A.cnt[r];
        }

        for (int r = 0; r < k; r++) {
            int newRem = (A.product * r) % k;
            newCnt[newRem] += B.cnt[r];
        }

        return new Node(newProduct, newCnt);
    }



    public static void main(String[] args) {
        // Test the solution
       leetcode_122 solution = new leetcode_122();

        int[] nums = {1, 2, 3, 4};
        int k = 5;
        int[][] queries = {
            {0, 5, 1, 2},
            {2, 6, 0, 3},
            {1, 7, 2, 4}
        };

        int[] result = solution.resultArray(nums, k, queries);

        System.out.println(Arrays.toString(result));
    }
}