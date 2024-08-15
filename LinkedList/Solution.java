package LinkedList;

import java.util.List;

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
        int count = 0;

        while (current != null) {
            if (count % 2 != 0) { // Odd
                odd.next = current;
                odd = odd.next;
            } else { // Even
                even.next = current;
                even = even.next;
            }
            current = current.next;
            count++;
        }

        odd.next = null; // End of even list
        even.next = oddHead.next; // Combine odd and even lists

        return evenHead.next; // Head of the new list
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode current = head.next;

        while (current != null) {
            if (prev.data == current.data) {
                prev.next = current.next;

            } else {
                prev = current;
            }
            current = current.next;
            ;
        }
        return head;
    }

    public static ListNode mergeTwoSortedList(ListNode x, ListNode y) {
        ListNode temp = new ListNode(0);
        ListNode tail = temp;

        while (x != null && y != null) {
            if (x.data <= y.data) {
                tail.next = x;
                x = x.next;
            } else {
                tail.next = y;
                y = y.next;
            }
            tail = tail.next;
        }
        if (x == null) {
            tail.next = y;
        } else {
            tail.next = x;
        }
        return temp.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newNode = new ListNode(0);
        ListNode current = newNode;

        while (head != null) {
            if (head.data != val) {
                ListNode temp = new ListNode(head.data);
                current.next = temp;
                current = current.next;
            }
            head = head.next;
        }
        return newNode.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode newNode = new ListNode(0);
        ListNode current = newNode;
        int sum = 0;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int data1 = (l1 != null) ? l1.data : 0;
            int data2 = (l2 != null) ? l2.data : 0;
            sum = data1 + data2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode temp = new ListNode(sum);
            current.next = temp;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return newNode.next;

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null ;
        }
        ListNode lengthFinder = head ;
        int length = 0 ;
        while (lengthFinder != null) {
            length++ ;
            lengthFinder = lengthFinder.next ;
        }
        System.out.println(length);
        if (n == length) {
            return head.next ;
        }
        ListNode current = head.next ;
        ListNode prev = head ;

        for(int i= 1 ; i<=length-n-1 ; i++){
            current = current.next ;
            prev = prev.next ;
        }
        prev.next = current.next ; 

        return head ;
    }

    public ListNode reverseList(ListNode head) {
     if (head == null || head.next == null) {
        return head ;
     }  
     ListNode current = head ;
     ListNode prev = null ; 
     while (current != null) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
     }
     return prev ;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        SinglyLinkedList sll = new SinglyLinkedList();
        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll.insertAtEnd(1);
        sll.insertAtEnd(2);
        sll.insertAtEnd(3);
        sll.insertAtEnd(4);
        sll.insertAtEnd(5);
        System.out.println(sol.reverse(sll.getHead()));
    }
}
