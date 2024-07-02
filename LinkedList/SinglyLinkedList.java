package LinkedList;

public class SinglyLinkedList {

    private ListNode head;

    static class ListNode {
        private int data;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

     void printLinkedList() {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(5);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(8);
        sll.head.next = second;
        second.next = third;

        sll.printLinkedList();
    }
}