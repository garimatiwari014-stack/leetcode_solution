class leetcode_92 {
    public boolean sumGame(String num) {

        int n = num.length();
        int half = n / 2;

        int diff = 0;
        int leftQ = 0;
        int rightQ = 0;

        // First half
        for (int i = 0; i < half; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                leftQ++;
            } else {
                diff += c - '0';
            }
        }

        // Second half
        for (int i = half; i < n; i++) {
            char c = num.charAt(i);

            if (c == '?') {
                rightQ++;
            } else {
                diff -= c - '0';
            }
        }

        int qDiff = rightQ - leftQ;

        // Bob can force equality
        if (diff * 2 == 9 * qDiff) {
            return false;
        }

        return true;
    }


    public static void main(String[] args){
        leetcode_92 st = new leetcode_92();
        String num = "234";

        st.sumGame(num);

    }
}