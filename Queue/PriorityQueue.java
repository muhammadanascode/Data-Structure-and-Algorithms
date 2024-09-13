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

    void resize(int l) {
        Integer[] arr = new Integer[l];
        System.arraycopy(heap, 1, arr, 1, n);
        heap = arr;
    }

    void insert(int val) {
        if (n == heap.length - 1) {
            resize(2 * heap.length);
        }
        System.out.println(heap.length);
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
        PriorityQueue maxhp = new PriorityQueue(4);
        maxhp.insert(1);
        maxhp.insert(9);
        maxhp.insert(5);
        maxhp.insert(4);
        maxhp.insert(3);
        maxhp.insert(11);
    }

}