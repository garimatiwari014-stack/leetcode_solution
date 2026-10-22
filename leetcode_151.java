import java.util.*;

class leetcode_151 {
    public int minOperations(int[] nums) {
        int n = nums.length;
        List<int[]> starts = new ArrayList<>();
        boolean inc = true, dec = true;
        for (int i = 0; i < n; i++) {
            if (nums[(i + 1) % n] != (nums[i] + 1) % n) inc = false;
            if (nums[(i + 1) % n] != (nums[i] - 1 + n) % n) dec = false;
        }
        if (inc) starts.add(new int[]{0, nums[0]});
        if (dec) starts.add(new int[]{1, (n - 1 - nums[0] + n) % n});
        if (starts.isEmpty()) return -1;

        int[][] dist = new int[2][n];
        for (int[] row : dist) Arrays.fill(row, -1);
        Queue<int[]> q = new ArrayDeque<>();
        for (int[] p : starts) {
            dist[p[0]][p[1]] = 0;
            q.offer(p);
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int t = cur[0], s = cur[1];
            if (t == 0 && s == 0) return dist[t][s];
            int d = dist[t][s];
            int nt = t, ns = (s + 1) % n;
            if (dist[nt][ns] == -1) {
                dist[nt][ns] = d + 1;
                q.offer(new int[]{nt, ns});
            }
            nt = 1 - t;
            ns = (n - s) % n;
            if (dist[nt][ns] == -1) {
                dist[nt][ns] = d + 1;
                q.offer(new int[]{nt, ns});
            }
        }
        return -1;
    }

    public static void main(String[] args){
        leetcode_151 obj = new leetcode_151();
        System.out.println(obj.minOperations(new int[]{1, 2, 3, 4, 0}));
        System.out.println("Hello World");
    }
}