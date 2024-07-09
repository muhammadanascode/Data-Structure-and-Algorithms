package LinkedList;

public class CircularSinglyLinkedList {
    ListNode last;
    int length;

    static class ListNode {
        ListNode next;
        int data;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    CircularSinglyLinkedList() {
        this.last = null;
        this.length = 0;
    }

    public int length() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    //method to add the node at the end
    void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    //method to add a node in start
    void insertAtStart(int data) {
        ListNode newNode = new ListNode(data);
        if (last == null) {
            last = newNode;
        } else {
            newNode.next = last.next;
        }
        last.next = newNode;
        length++;

    }

    //method to remove the first node from circular linked list
    public ListNode deleteNode(){
        if (last == null || last.next == last) {
            this.last = null ;
            return this.last ;
        }
        ListNode firstNode = last.next ;
        ListNode secondNode = firstNode.next ;
        last.next = secondNode ;
        firstNode.next = null ;
        length-- ;
        return firstNode ;
    }

    // method to print list
    void printList() {
        if (last == null) {
            return;
        }
        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.data + "-->");
        }
        System.out.println("null");
    }

}
