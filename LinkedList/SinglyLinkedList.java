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

    //printing the list
    void printLinkedList() {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("Null");
    }

    //Finding length of list
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

    //Inserting Node at start
    void insertAtStart(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    //Inserting node at the end
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


    //Inserting Node at specific position
    void insertAtPosition(int value, int position) {
        ListNode newNode = new ListNode(value);
        if (position == 1) {
           insertAtStart(value);
        }
        ListNode previousNode = head;
        int count = 1;
        while (count < position - 1) {
            previousNode = previousNode.next;
            count++;
        }
        ListNode current = previousNode.next;
        newNode.next = current;
        previousNode.next = newNode;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtStart(12);
        sll.insertAtStart(13);
        sll.insertAtStart(78);
        sll.insertAtStart(14);
        sll.insertAtStart(90);
        sll.insertAtEnd(56);
        sll.insertAtPosition(5,3);
        sll.insertAtPosition(6, 4);

        sll.printLinkedList();
        System.out.println(sll.length());
    }
}