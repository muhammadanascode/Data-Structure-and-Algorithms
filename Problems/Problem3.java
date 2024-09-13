package Problems;

/**
 * Given a sorted array of distinct integers and a target value
 * return the index if the target is found.
 * if not then return index where it would be if it is inserted in order
 */
public class Problem3 {

    static int search(int[] arr, int key) {

        int low = 0;
        int high = arr.length - 1;
        int i = 1;
        int mid = 0;
        while (low <= high) {

            mid = low + (high - low) / 2;
            System.out.println(mid);
            if (arr[mid] == key) {
                System.out.println("Key founded in iterations: " + i);
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            i++;
        }
        System.out.println("Value should be inserted there: " + low);
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        search(arr, 9);
    }
}
