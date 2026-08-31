public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class leetcode_99 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int previous = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        while (curr.next != null) {

            // Check whether curr is a critical point
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                // First critical point
                if (first == -1) {
                    first = index;
                    previous = index;
                } 
                else {

                    // Distance from previous critical point
                    int distance = index - previous;

                    minDistance = Math.min(minDistance, distance);

                    // Distance from first critical point
                    maxDistance = index - first;

                    previous = index;
                }
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (first == -1 || minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }

    public static void main(String [] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(2);

        leetcode_99 sol = new leetcode_99();
        int [] result = sol.nodesBetweenCriticalPoints(head);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}