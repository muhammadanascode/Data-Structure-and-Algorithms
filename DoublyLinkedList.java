public class DoublyLinkedList {

    ListNode head;
    ListNode tail;
    int length;

    static class ListNode {
        int data;
        ListNode prev;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int length() {
        return this.length;
    }

    public void printListForward(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("Ended");
    }

    public void printListBackward(ListNode tail) {
        ListNode temp = tail;
        while (temp != null) {
            System.out.println(temp.data + "-->");
            temp = temp.prev;
        }
        System.out.println("Ended");
    }
}
