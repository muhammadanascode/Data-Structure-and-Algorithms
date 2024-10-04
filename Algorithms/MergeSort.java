package Algorithms;

public class MergeSort {

   static void sort(int[] arr, int[] temp, int low, int high) {
        // Base condition: If the subarray has one or no elements
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        // Recursively split and sort the left half
        sort(arr, temp, low, mid);
        // Recursively split and sort the right half
        sort(arr, temp, mid + 1, high);
        // Merge the sorted halves
        merge(arr, temp, low, mid, high);
    }

    static void merge(int[] arr, int[] temp, int low, int mid, int high) {
        // Copy the elements to the temp array
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i]; 
        }

        int i = low;      // Starting index for the left subarray
        int j = mid + 1;  // Starting index for the right subarray
        int k = low;      // Starting index to store in the original array

        // Merge the two sorted halves
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // Copy any remaining elements of the left half (if any)
        while (i <= mid) {
            arr[k++] = temp[i++];
        }

        // No need to copy the right half because it's already in the correct position
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 8, 7, 6};
        int[] temp = new int[arr.length];

        // Call the sort method
        sort(arr, temp, 0, arr.length - 1);

        // Print the sorted array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
