/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 92. Reverse Linked List II
    // https://leetcode.com/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prevNode = null, currNode = null, nextNode = head,
                startNode = null, startRevNode = null;

        int count = 1;

        while (count < left && nextNode != null) {
            if (count == left - 1)
                startNode = nextNode;
            nextNode = nextNode.next;
            count++;
        }

        startRevNode = nextNode;

        while (count <= right && nextNode != null) {
            currNode = nextNode;
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            count++;
        }

        if (startNode != null)
            startNode.next = prevNode;
        else
            head = prevNode;

        startRevNode.next = nextNode;

        return head;
    }
}