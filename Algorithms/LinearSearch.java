package Algorithms;

public class LinearSearch {
    static int search(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Key founded");
                return i;
            }
        }
        System.out.println("Key not found");
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 6, 8 };
        search(arr, 3);
    }
}
