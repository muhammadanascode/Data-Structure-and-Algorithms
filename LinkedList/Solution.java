package LinkedList;

import LinkedList.SinglyLinkedList.ListNode;

//Method to check whether the list is palindrome or not

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
    // Problem: Separate the odd and even numbers in list and also maintain relative
    // order for e.g [1,2,3,4]-->[1,3,2,4]

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddHead = new ListNode(0); // Dummy head for odd list
        ListNode evenHead = new ListNode(0); // Dummy head for even list
        ListNode odd = oddHead;
        ListNode even = evenHead;
        ListNode current = head;
        int count = 0 ;

        while (current != null) {
            if (count % 2 != 0) { // Odd
                odd.next = current;
                odd = odd.next;
            } else { // Even
                even.next = current;
                even = even.next;
            }
            current = current.next;
            count++ ;
        }

        odd.next = null; // End of even list
        even.next = oddHead.next; // Combine odd and even lists

        return evenHead.next; // Head of the new list
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head ;
        }
        ListNode prev = head ;
        ListNode current = head.next ;

        while (current != null) {
            if (prev.val == current.val) {
                prev.next = current.next ;
                
            }else{
               prev = current ;
            }
            current = current.next ;
            ;
        }
        return head ;
    }

    public static void main(String[] args) {
        Solution sol = new Solution() ;
        SinglyLinkedList sll =new SinglyLinkedList() ;
        sll.insertAtEnd(2);
        sll.insertAtEnd(1);
        sll.insertAtEnd(3);
        sll.insertAtEnd(4);
       System.out.println(sol.oddEvenList(sll.getHead()).next.next); 
    }
}
