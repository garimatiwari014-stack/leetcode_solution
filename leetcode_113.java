class leetcode_113 {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;
        int maxOverlap = 0;

        // Shift img1 in all possible directions
        for (int rowShift = -(n - 1); rowShift <= n - 1; rowShift++) {

            for (int colShift = -(n - 1); colShift <= n - 1; colShift++) {

                int overlap = 0;

                // Check every cell
                for (int i = 0; i < n; i++) {

                    for (int j = 0; j < n; j++) {

                        // Position of img1 after shifting
                        int x = i + rowShift;
                        int y = j + colShift;

                        // Check if shifted position is inside img2
                        if (x >= 0 && x < n && y >= 0 && y < n) {

                            if (img1[i][j] == 1 && img2[x][y] == 1) {
                                overlap++;
                            }
                        }
                    }
                }

                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }

        return maxOverlap;
    }

public static void main(String [] args){
    leetcode_113 sol =  new leetcode_113();
    int [][] img1 = {{1,1,0},{0,1,0},{0,1,0}};
    int [][] img2 = {{0,0,0},{0,1,1},{0,1,0}};
    System.out.println(sol.largestOverlap(img1,img2));
}
}