import java.util.ArrayList;
import java.util.List;
public class leetcode_58 {
    

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            result.add(row);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                int newIdx = (idx + k) % total;

                int newRow = newIdx / n;
                int newCol = newIdx % n;

                result.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return result;
    }
}
}