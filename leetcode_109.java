class leetcode_109 {
    public long countCommas(long n) {
        long count = 0;

        for (long p = 1000; p <= n; p *= 1000)
            count += n - p + 1;

        return count;
    }

    public static void main(String [] args){
        long n =10000;
         leetcode_109 sol = new leetcode_109();
         sol.countCommas(n);
         System.out.println(sol.countCommas(n));
    }
}