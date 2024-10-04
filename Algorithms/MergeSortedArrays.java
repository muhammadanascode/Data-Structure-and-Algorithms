package Algorithms;

public class MergeSortedArrays {

    static int[] mergesortedarray(int[] arr1, int[] arr2, int n, int m) {

        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (arr1[i] > arr2[j]) {
                result[k] = arr1[i++];
            } else {
                result[k] = arr2[j++];
            }
            k++;
        }
        while (i < n) {
            result[k++] = arr1[i++];
        }
        while (j < n) {
            result[k++] = arr2[j++];
        }

        return result ;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 6, 7 };
        int arr2[] = { 3, 4, 5, 8 };
        System.out.println(mergesortedarray(arr1, arr2, arr1.length, arr2.length));

    }
}
