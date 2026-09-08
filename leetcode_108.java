class leetcode_108 {
    public int countCommas(int n) {
        if( n < 1000){
            return 0;
        }
        return n - 1000 +1;
    }

    public static void main(String [] args){
        int n = 1002;
        leetcode_108 sol = new leetcode_108();
        sol.countCommas(n);
        System.out.println("Number of commas in " + n + " is: " + sol.countCommas(n));

    }
}