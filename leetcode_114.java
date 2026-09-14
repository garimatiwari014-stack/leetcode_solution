class leetcode_114 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        // No overlap if one rectangle is completely
        // to the left/right/top/bottom of the other

        if (rec1[2] <= rec2[0] ||   // rec1 is left of rec2
            rec2[2] <= rec1[0] ||   // rec2 is left of rec1
            rec1[3] <= rec2[1] ||   // rec1 is below rec2
            rec2[3] <= rec1[1]) {   // rec2 is below rec1

            return false;
        }

        return true;
    }


    public static void main(String [] args){
        leetcode_114 sol = new leetcode_114();

        sol.isRectangleOverlap(new int[]{0,0,2,2}, new int[]{1,1,3,3}); // true
        sol.isRectangleOverlap(new int[]{0,0,1,1}, new int[]{1,0,2,1}); // false
        sol.isRectangleOverlap(new int[]{0,0,1,1}, new int[]{2,2,3,3}); // false
    }
}