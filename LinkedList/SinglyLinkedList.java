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

        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + data +
                    ", next=" + (next != null ? next.data : "null") +
                    '}';
        }
    }

    // printing the list
    void printLinkedList() {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("Ended");
    }

    // Finding length of list
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

    // Inserting Node at start
    void insertAtStart(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    // Inserting node at the end
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

    // Inserting Node at specific position
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

    // Deleting first Node from List
    ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    // deleting last node
    ListNode deleteLast() {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            ListNode temp = head;
            head = null;
            return temp;
        }
        ListNode previous = null;
        ListNode current = head;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
        return current;
    }

    // deleting nodes from specific position
    ListNode delete(int position) {
        if (position == 1) {
            ListNode temp = head;
            head = head.next;
            return temp;
        }

        ListNode previous = head;
        int count = 1;

        while (count < position - 1) {
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;
        previous.next = current.next;
        return current;
    }

    // searching specific node
    boolean searchNode(int value) {
        ListNode current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Reversing a linkedlist
    void reverse() {

        if (head == null) {
            return;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // referencing head previous
        head = previous;

        return;
    }

    // finding nth node from the end of list
    ListNode getNthListNodeFromEnd(int n) {
        if (head == null) {
            return null;
        }

        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;

        while (count < n) {
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }

        return mainPtr;
    }

    // Removing duplicates item from sorted linkedlist
    void removeDuplicates() {
        if (head == null) {
            return;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

    }

    // method to insert a neew node in sorted linkedlist
    void insertNewNodeInSorted(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        }
        ListNode previous = null;
        ListNode current = head;

        while (current != null && current.data < newNode.data) {
            previous = current;
            current = current.next;
        }
        previous.next = newNode;
        newNode.next = current;
        return;
    }

    // deleting a node with key
    boolean deleteKey(int value) {
        if (head == null) {
            return false;
        }
        ListNode current = head;
        ListNode previous = null;

        if (current != null && current.data == value) {
            head = head.next;
            return true;
        }

        while (current != null && current.data != value) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        previous.next = current.next;
        return true;
    }

    //method to find any node of loop
    private ListNode getLoopNode() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                return slowPtr;
            }
        }
        return null;
    }

    //method to check if the list contains loop
    boolean containsLoop() {
        if (getLoopNode() != null) {
            return true;
        }
        return false;
    }

    //method to get the first node of loop
    ListNode getFirstNodeOfLoop() {
        if (!containsLoop()) {
            return null;
        }
        ListNode slowPtr = getLoopNode();
        ListNode temp = head;

        while (slowPtr != temp) {
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        return temp;
    }

    //removing loop of list
    void removeLoop() {
        if (!containsLoop()) {
            return;
        }
        ListNode slowPtr = getFirstNodeOfLoop();
        ListNode temp = head;
        while (slowPtr.next != temp.next) {
            slowPtr = slowPtr.next;
            temp = temp.next;
        }
        slowPtr.next = null;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        // inserting nodes
        sll.insertAtEnd(41);
        sll.insertAtEnd(41);
        sll.insertAtEnd(43);
        sll.insertAtEnd(44);
        sll.insertAtEnd(45);

        sll.getNthListNodeFromEnd(1).next = sll.getNthListNodeFromEnd(3);

        // displaying nodes
        // sll.printLinkedList();

        // deleting nodes
        // sll.delete(4);

        // displaying nodes
        // sll.printLinkedList();

        // System.out.println(sll.searchNode(90));
        // sll.reverse();
        // sll.removeDuplicates();
        // sll.insertNewNodeInSorted(45);
        // System.out.println(sll.deleteKey(46));
        System.out.println(sll.containsLoop());
        System.out.println(sll.getFirstNodeOfLoop());
        // sll.printLinkedList();
        // System.out.println(sll.getNthListNodeFromEnd(3));

    }
}
