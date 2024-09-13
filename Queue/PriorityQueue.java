package Queue;

public class PriorityQueue {

    Integer[] heap;
    int n;

    public PriorityQueue(int capacity) {
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    void insert(int val) {
        if (n == heap.length - 1) {
            System.out.println("Heap out of memory");
            return;
        }
        heap[++n] = val;
        swim(n);
    }

    // restoring the property of binary heap after inserting an element
    private void swim(int k) {
        while (k > 1 && heap[k / 2] < heap[k]) {
            int temp = heap[k];
            heap[k] = heap[k / 2];
            heap[k / 2] = temp;
            k = k / 2;
        }
    }

    public static void main(String[] args) {

    }

}