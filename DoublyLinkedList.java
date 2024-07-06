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
        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + data +
                    ", next=" + (next != null ? next.data : "null") +
                    '}';
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

    void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode ;
        }
        else{
            tail.next = newNode ;
        }
        newNode.prev = tail;
        tail = newNode ;
        this.length++ ;

    }

    public void printListForward(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printListBackward(ListNode tail) {
        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public void insertAtStart(int data){
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            tail = newNode ;
        }else{
            head.prev = newNode  ;
        }
        newNode.next = head ; 
        head  = newNode ;
    }

    //method yo delete the first Node of list
    ListNode deleteFirst(){
        if (isEmpty()) {
            return null ;
        }
        ListNode temp  = head ;
        if (head == tail) {
            tail = null ;
        }
        else{
            head.next.prev = null ;
        }
        head = head.next ;
        temp.next = null ;
        return temp ;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList() ;
        dll.insertAtEnd(1);
        dll.insertAtEnd(2);
        dll.insertAtEnd(3);
        dll.insertAtEnd(4);
        dll.insertAtEnd(5);

        
        System.out.println(dll.deleteFirst());
        System.out.println(dll.deleteFirst());
        System.out.println(dll.deleteFirst());
        dll.printListForward(dll.head);
    }
}
