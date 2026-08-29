import java.util.*;

class leetcode_97 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        // value + original index
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = nums[i];  // value
            a[i][1] = i;        // index
        }

        // value ke according sort
        Arrays.sort(a, (x, y) -> x[0] - y[0]);

        int i = 0;

        while (i < n) {

            int j = i;

            // Same group find karo
            while (j + 1 < n &&
                   a[j + 1][0] - a[j][0] <= limit) {
                j++;
            }

            // Group ke original indices
            int[] index = new int[j - i + 1];

            for (int k = i; k <= j; k++) {
                index[k - i] = a[k][1];
            }

            // Original indices ko sort karo
            Arrays.sort(index);

            // Small values -> small indices
            for (int k = 0; k < index.length; k++) {
                nums[index[k]] = a[i + k][0];
            }

            // Next group
            i = j + 1;
        }

        return nums;
    }

    public static void main(String [] args){
        leetcode_97 obj = new leetcode_97();
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        int [] nums = new int[sc.nextInt()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
          
        System.out.println(Arrays.toString(obj.lexicographicallySmallestArray(nums , limit)));
    }
}