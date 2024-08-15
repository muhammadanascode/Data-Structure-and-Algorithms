package Stack;
public class StackUsingArray {
    int top = -1;
    int[] arr;

    StackUsingArray(int capacity) {
        this.top = -1;
        arr = new int[capacity];
    }

    StackUsingArray() {
        this(10);
    }

    boolean isFull() {
        return arr.length == size();
    }

    int size() {
        return top + 1;
    }

    void push(int data) {
        if (isFull()) {
            System.out.println("Stack out of capacity");
            return;
        }
        top++;
        arr[top] = data;

    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack is empty");
            return -1;
        }
        int result = arr[top];
        top--;
        return result;
    }

    public static void main(String[] args) {

    }
}
