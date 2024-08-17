package Queue;

public class Queue {

    ListNode front;
    ListNode rear;
    int length;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    private class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    int length() {
        return this.length;
    }

    boolean isEmpty() {
        return this.length == 0;
    }

    void enqueue(int data) {
        ListNode temp = new ListNode(data);
        if (isEmpty()) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    int dequeue() {
        if (isEmpty()) {
            return -1;
        }
        int result = front.data;
        front = front.next;
        return result;
    }

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}