
import java.util.*;

class Solution {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        // Adjacency List
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build Graph
        for (int[] edge : invocations) {
            graph[edge[0]].add(edge[1]);
        }

        // suspicious[i] = true means method i is suspicious
        boolean[] suspicious = new boolean[n];

        dfs(k, graph, suspicious);

        // Check if any non-suspicious method calls a suspicious method
        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }

        // Return remaining methods
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }

        return ans;
    }

    private void dfs(int node, ArrayList<Integer>[] graph, boolean[] suspicious) {

        suspicious[node] = true;

        for (int next : graph[node]) {
            if (!suspicious[next]) {
                dfs(next, graph, suspicious);
            }
        }
    }
}