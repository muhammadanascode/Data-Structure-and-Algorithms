package Algorithms;

public class SelectionSort {

    static void selectionsort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[min] > arr[j]) {
                    min = j ;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 4, 2, 5 };
        selectionsort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
