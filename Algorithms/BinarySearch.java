package Algorithms;

public class BinarySearch {

    static int search(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;
        int i = 1 ;
        while (low <= high) {

            int mid = (high + low) / 2;
            if (arr[mid] == key) {
                System.out.println("Key founded in iterations: " + i);
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            i++ ;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        search(arr, 6);
    }
}
