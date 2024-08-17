import java.util.*;

public class ReverseBtwNodes {

    // Definition for a singly-linked list node
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || left == right) {
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;

            // Move prev to the node just before the sublist to be reversed
            for (int i = 1; i < left; i++) {
                prev = prev.next;
            }

            // Reverse the sublist from left to right
            ListNode curr = prev.next;
            for (int i = left; i < right; i++) {
                ListNode nextNode = curr.next;
                curr.next = nextNode.next;
                nextNode.next = prev.next;
                prev.next = nextNode;
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ReverseBtwNodes rn = new ReverseBtwNodes();
        ReverseBtwNodes.Solution solution = rn.new Solution();

        // Test cases
        ListNode head = rn.new ListNode(1);
        head.next = rn.new ListNode(2);
        head.next.next = rn.new ListNode(3);
        head.next.next.next = rn.new ListNode(4);
        head.next.next.next.next = rn.new ListNode(5);

        int left = 2, right = 4;
        ListNode reversed = solution.reverseBetween(head, left, right);

        // Print the reversed list for verification
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}
