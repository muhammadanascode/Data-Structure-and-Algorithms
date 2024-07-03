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

    int length() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    void insertAtStart(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtStart(12);
        sll.insertAtStart(13);
        sll.insertAtStart(78);
        sll.insertAtStart(14);
        sll.insertAtStart(90);
        sll.insertAtEnd(56);

        sll.printLinkedList();
        System.out.println(sll.length());
    }
}