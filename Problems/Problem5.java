package Problems;

public class Problem5 {

    // Return the squares of array(which is in ascending order) in sorted form

    static int[] sortedSquare(int arr[]) {
        int n = arr.length;
        int[] result = new int[n];
        int i = 0;
        int j = n - 1;

        for (int k = n - 1; k > 0; k--) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                result[k++] = arr[i] * arr[i];
                i++;
            } else {
                result[k++] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { -5, -4, 0, 1, 2, 3 };
        System.out.println(sortedSquare(arr));
    }
}
