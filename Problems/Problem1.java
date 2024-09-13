package Problems;

//Problem : Search a specific key in n*n matrix which is sorted column wise
public class Problem1 {

    static void search(int[][] arr, int key) {
        int n = 0;
        int i = 0;
        int j = arr[0].length - 1;

        while (j > -1 && i < arr[0].length) {
            n++;
            if (arr[i][j] == key) {
                System.out.println("Key founded in iterations: " + n);
                return;
            } else if (key < arr[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Not founded");
    }

    public static void main(String[] args) {
        int[][] arr = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 52 } };
        search(arr, 32);
    }
}
