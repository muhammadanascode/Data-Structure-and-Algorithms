package LinkedList;

import LinkedList.SinglyLinkedList.ListNode;

public class Solution {
    

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode copyList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(head.data);
        ListNode current = head.next;
        ListNode newCurrent = newHead;

        while (current != null) {
            newCurrent.next = new ListNode(current.data);
            newCurrent = newCurrent.next;
            current = current.next;
        }

        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        } else if (head.next == null) {
            return true;
        }

        // Step 1: Create a copy of the linked list
        ListNode copiedHead = copyList(head);

        // Step 2: Reverse the copied linked list
        ListNode reversedHead = reverse(copiedHead);

        // Step 3: Compare the original list with the reversed copied list
        ListNode originalCurrent = head;
        ListNode reversedCurrent = reversedHead;

        while (originalCurrent != null && reversedCurrent != null) {
            if (originalCurrent.data != reversedCurrent.data) {
                return false;
            }
            originalCurrent = originalCurrent.next;
            reversedCurrent = reversedCurrent.next;
        }

        return true;
    }
}
