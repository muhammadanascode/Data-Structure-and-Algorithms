package Algorithms;

public class InsertionSort {
    static void insertionsort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 1, 2, 4 };
        insertionsort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
