class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // Process first string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != '#') {
                sb.append(ch);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        // Process second string
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            if (ch != '#') {
                sb2.append(ch);
            } else if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
        }

        return sb.toString().equals(sb2.toString());
    }
}