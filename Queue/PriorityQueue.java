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

    public static void main(String[] args) {

    }

}