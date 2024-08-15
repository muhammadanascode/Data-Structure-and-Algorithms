public class Stack {

    ListNode top;
    int length;

    public Stack() {
        this.top = null;
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

    void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = this.top;
        this.top = temp;
        length++;
        return;
    }

    void pop(){
        if (isEmpty()) {
            return ;
        }
        top = top.next ;
        length-- ;
        return ;
    }

    int peek(){
        return top.data ;
    }

    public static void main(String[] args) {

    }
}
