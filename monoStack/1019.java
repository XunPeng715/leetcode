/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ListNode prev = null;
        int count = 0;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
            count++;
        }
        int[] res = new int[count];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = count - 1; i >= 0; i--) {
            int curr = prev.val;
            prev = prev.next;
            while (!stack.isEmpty() && stack.getFirst() <= curr) {
                stack.removeFirst();
            }
            res[i] = stack.isEmpty() ? 0 : stack.getFirst();
            stack.addFirst(curr);
        }
        return res;
    }
}
