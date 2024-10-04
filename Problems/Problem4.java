package Problems;

public class Problem4 {
    // Dutch national flag problem - sort 0s, 1s, and 2s
    static void sort(int[] arr) {

        int i = 0;            // Pointer for traversing the array
        int j = 0;            // Pointer for placing 0s
        int k = arr.length - 1; // Pointer for placing 2s

        while (i <= k) {
            if (arr[i] == 0) {
                // Swap arr[i] and arr[j], then move both i and j forward
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            } else if (arr[i] == 1) {
                // If it's 1, just move i forward
                i++;
            } else if (arr[i] == 2) {
                // Swap arr[i] and arr[k], then move k backward
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 2, 0, 1, 0, 2, 2};

        // Sorting the array
        sort(arr);

        // Printing the sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
